// ==UserScript==
// @name         mObywatel Source Code Downloader
// @namespace    https://mobywatel.gov.pl/
// @version      2.0
// @description  Downloads source code of mObywatel (Android/iOS) as ZIP. Handles SPA navigation.
// @author       fajfer ,n1ghtmare13
// @license      MIT
// @match        https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny*
// @grant        none
// ==/UserScript==

/**
 * TECHNICAL COMPLIANCE NOTICE:
 * 1. PRIVACY: This script operates 100% client-side. No data is transmitted to external servers.
 * 2. SECURITY: This script does NOT bypass any authentication. User must be logged in via official Gov.pl channels.
 * 3. METHODOLOGY: It uses standard DOM manipulation to automate visual tasks (expanding trees, reading iframes).
 * 4. PURPOSE: Facilitates the exercise of rights granted by the MIT License attached to the source code by the authors (COI).
*/

(function() {
    'use strict';

    // LICENSE provided by original source
    const LICENSE_TEXT = `Licencja MIT
    Copyright (c) 2025 Centralny Ośrodek Informatyki

    Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania
    i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa
    do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń
    prawa do używania, kopiowania, modyfikowania, łączenia, publikowania,
    dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania,
    a także do zezwalania osobom, którym Oprogramowanie jest dostarczane,
    na to samo, z zastrzeżeniem następujących warunków:

    Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być
    dołączone do wszystkich kopii lub istotnych części Oprogramowania.

    OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI,
    WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI
    HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW.
    W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ
    ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA,
    CZY TO W WYNIKU UMOWY, CZYNU NIEDOZWOLONEGO, CZY W INNY SPOSÓB,
    WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ
    ZWIĄZANYCH Z OPROGRAMOWANIEM.
    `.replace(/^ +/gm, '').trim();

    // DOM Helpers
    const $ = (sel, el = document) => el.querySelector(sel);
    const $$ = (sel, el = document) => Array.from(el.querySelectorAll(sel));
    const sleep = ms => new Promise(r => setTimeout(r, ms));

    // UI Configuration
    const styles = `
        #mob-downloader-btn {
            position: fixed; bottom: 20px; right: 20px; z-index: 99999;
            padding: 10px 20px; background-color: #0052a5; color: white;
            border: none; border-radius: 4px; font-weight: bold; cursor: pointer;
            font-family: sans-serif; font-size: 13px; display: none;
            box-shadow: 0 4px 12px rgba(0,0,0,0.3);
        }

        #mob-downloader-btn.done {
            background-color: #2e7d32;
            cursor: default;
            pointer-events: none;
            opacity: 1;
        }

        #mob-console {
            position: fixed; bottom: 60px; right: 20px; z-index: 99999;
            width: 450px; max-height: 300px; overflow-y: auto;
            background: rgba(0, 0, 0, 0.9); color: #0f0;
            font-family: monospace; font-size: 11px; padding: 10px;
            border-radius: 4px; display: none; border: 1px solid #333;
            pointer-events: none;
        }
        .mob-log-line { border-bottom: 1px solid #333; padding: 2px 0; }
        .mob-type { color: #00bfff; font-weight: bold; margin-left: 5px; }
    `;
    document.head.insertAdjacentHTML('beforeend', `<style>${styles}</style>`);

    const btn = document.createElement('button');
    btn.id = 'mob-downloader-btn';
    btn.innerText = 'DOWNLOAD SOURCE';
    document.body.appendChild(btn);

    const consoleDiv = document.createElement('div');
    consoleDiv.id = 'mob-console';
    document.body.appendChild(consoleDiv);

    const log = (msg) => {
        consoleDiv.style.display = 'block';
        consoleDiv.insertAdjacentHTML('afterbegin', `<div class="mob-log-line">&gt; ${msg}</div>`);
    };

    // Logic

    // Removes file headers and line numbers from text content
    function cleanCodeContent(text, filename) {
        if (!text) return "";
        let lines = text.split('\n');

        // Remove filename header if present in first 3 lines
        for (let i = 0; i < Math.min(lines.length, 3); i++) {
            if (lines[i].trim() === filename.trim()) lines[i] = '';
        }

        // Detect line number column width
        let prefixWidth = 0;
        let detected = false;

        for (let i = 0; i < Math.min(lines.length, 30); i++) {
            const match = lines[i].match(/^(\s*\d+[\s\t]+)/);
            if (match) {
                prefixWidth = match[1].length;
                detected = true;
                break;
            }
        }

        // Strip line numbers
        if (detected && prefixWidth > 0) {
            lines = lines.map(line => line.length <= prefixWidth ? '' : line.substring(prefixWidth));
        }

        // Trim end of lines and remove empty leading lines
        return lines.map(l => l.trimEnd()).join('\n').trimStart();
    }

    // Handles double extensions like .iml.html correctly
    function cleanFilename(name) {
        if (name.endsWith('.html')) {
            const base = name.slice(0, -5);
            // If another extension exists (ds.iml), return it. Else keep original (index.html).
            if (base.includes('.')) return base;
        }
        return name;
    }

    // Binary files and SVGs should be fetched as Blobs
    function shouldUseFetch(filename) {
        return /\.(svg|png|jpg|jpeg|gif|ico|webp|ttf|woff|woff2|eot|pdf|zip|mp4|mov)$/i.test(filename);
    }

    function getZipFilename() {
        const url = window.location.href.toLowerCase();
        if (url.includes('/android')) return 'mObywatel-Android.zip';
        if (url.includes('/ios')) return 'mObywatel-iOS.zip';
        return 'mObywatel-Source.zip';
    }

    // Reset button state when navigating away
    function resetButton() {
        btn.classList.remove('done');
        btn.innerText = 'DOWNLOAD SOURCE';
        btn.style.display = 'none';
        btn.disabled = false;
        btn.onclick = mainClickHandler;
        consoleDiv.style.display = 'none';
        consoleDiv.innerHTML = '';
    }

    // SPA Observer
    new MutationObserver(() => {
        const isProjectPage = /android|ios/i.test(window.location.href);
        const hasTree = !!$('mat-tree');

        // Check if we left the project page
        if (!isProjectPage || !hasTree) {
            // Only reset if visible to avoid redundant calls
            if (btn.style.display !== 'none') {
                resetButton();
            }
            return;
        }

        // Show button if we are on project page and it is not done
        if (!btn.classList.contains('done')) {
            btn.style.display = 'block';
        }
    }).observe(document.body, { childList: true, subtree: true });

    // Main Handler
    async function mainClickHandler() {
        if (btn.classList.contains('done')) return;
        // Disable click immediately
        btn.onclick = null;
        btn.innerText = "PROCESSING...";

        let fflate;
        try {
            log("Initializing libraries...");
            fflate = await import('https://cdn.jsdelivr.net/npm/fflate@0.8.2/+esm');
        } catch (e) {
            alert("Init error: " + e.message);
            btn.disabled = false;
            // Restore handler on error
            btn.onclick = mainClickHandler;
            return;
        }

        const filesToZip = {};

        // Phase 1: Expand Directory Tree
        log("Scanning directory structure...");
        const emptyFolders = new Set();
        let expansionNeeded = true;

        while (expansionNeeded) {
            expansionNeeded = false;
            const nodes = $$('mat-tree-node');

            for (const node of nodes) {
                const button = $('button', node);
                if (!button) continue;

                const label = button.getAttribute('aria-label') || "";
                const level = parseInt(node.getAttribute('aria-level') || '1');
                const text = button.innerText.trim();
                const nodeId = `${level}__${text}`;

                if (label.includes('Toggle')) {
                    let isExpanded = false;
                    const nextNode = node.nextElementSibling;
                    // Check if next node is a child (higher indentation level)
                    if (nextNode) {
                        const nextLevel = parseInt(nextNode.getAttribute('aria-level') || '1');
                        if (nextLevel > level) isExpanded = true;
                    }

                    if (!isExpanded && !emptyFolders.has(nodeId)) {
                        log(`Expanding: ${text}`);
                        node.scrollIntoView({ block: 'center', behavior: 'instant' });
                        const countBefore = $$('mat-tree-node').length;

                        button.click();

                        // Wait for Angular to update DOM
                        let waits = 0;
                        while(waits < 40) {
                            await sleep(50);
                            if ($$('mat-tree-node').length > countBefore) {
                                expansionNeeded = true; break;
                            }
                            waits++;
                        }
                        if (!expansionNeeded) emptyFolders.add(nodeId);
                        else break; // Restart loop on DOM change
                    }
                }
            }
        }

        // Phase 2: Download Files
        log("Downloading files...");
        const finalNodes = $$('mat-tree-node');
        let pathStack = [];
        let fileCount = 0;

        for (const node of finalNodes) {
            const level = parseInt(node.getAttribute('aria-level') || '1');
            const button = $('button', node);
            const label = button.getAttribute('aria-label') || "";
            const rawText = button.innerText.trim();
            const isFolder = label.includes('Toggle');
            const name = isFolder ? label.replace('Toggle ', '').trim() : rawText;

            pathStack = pathStack.slice(0, level - 1);

            if (isFolder) {
                pathStack.push(name);
            } else {
                const fileName = cleanFilename(name);
                const fullPath = [...pathStack, fileName].join('/');

                const isFetchMode = shouldUseFetch(fileName);
                const modeLabel = isFetchMode ? '[BLOB]' : '[TEXT]';

                log(`[${++fileCount}] ${fileName} <span class="mob-type">${modeLabel}</span>`);
                node.scrollIntoView({ block: 'center', behavior: 'instant' });

                // Reset iframe to detect load event via src change
                const iframe = $('iframe');
                if (iframe) iframe.src = 'about:blank';

                button.click();

                let newBlobUrl = null;
                let attempts = 0;
                while (attempts < 100) {
                    const curr = $('iframe');
                    if (curr?.src?.startsWith('blob:')) {
                        if (!isFetchMode) {
                            // Ensure text content is rendered
                            if (curr.contentDocument?.body?.innerText.trim().length > 0) {
                                newBlobUrl = curr.src; break;
                            }
                        } else {
                            newBlobUrl = curr.src; break;
                        }
                    }
                    await sleep(50);
                    attempts++;
                }

                if (newBlobUrl) {
                    try {
                        if (isFetchMode) {
                            // Binary/SVG: Fetch blob directly to preserve exact bytes
                            const resp = await fetch(newBlobUrl);
                            filesToZip[fullPath] = new Uint8Array(await resp.arrayBuffer());
                        } else {
                            // Code: Extract text from DOM to strip visualization artifacts
                            const rawText = $('iframe').contentDocument.body.innerText || "";
                            filesToZip[fullPath] = fflate.strToU8(cleanCodeContent(rawText, fileName));
                        }
                    } catch (e) {
                        log(`Error: ${e.message}`);
                        filesToZip[fullPath + ".error.txt"] = fflate.strToU8(e.message);
                    }
                } else {
                    log(`Timeout: ${fileName}`);
                    filesToZip[fullPath + ".empty"] = fflate.strToU8("Error/Timeout");
                }
            }
        }

        // Phase 3: Save ZIP
        log("Generating ZIP...");
        const outputFilename = getZipFilename();

        try {
            // Add LICENSE
            filesToZip["LICENSE"] = fflate.strToU8(LICENSE_TEXT);
            // Level 0: Store (No compression) for speed (user will unpack it later anyway)
            const zipped = fflate.zipSync(filesToZip, { level: 0 });
            const blob = new Blob([zipped], { type: 'application/zip' });
            const url = URL.createObjectURL(blob);

            const a = document.createElement('a');
            a.href = url;
            a.download = outputFilename;
            document.body.appendChild(a);
            a.click();

            setTimeout(() => { a.remove(); URL.revokeObjectURL(url); }, 100);

            log("Success!");
            btn.innerText = "DONE";
            btn.classList.add('done');
            // onclick is already null here
            setTimeout(() => { consoleDiv.style.display = 'none'; }, 4000);

        } catch (e) {
            log(`ZIP Error: ${e.message}`);
            alert("ZIP Error: " + e.message);
            btn.innerText = "ERROR";
            btn.disabled = false;
            // Restore handler so user can try again
            btn.onclick = mainClickHandler;
        }
    }

    // Initial listener assignment
    btn.onclick = mainClickHandler;

})();
