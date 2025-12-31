![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Platform: Android | iOS](https://img.shields.io/badge/Platform-Android%20%7C%20iOS-blue)

# mObywatel Mobile

[Polska wersja tutaj](README.md)

On December 29, 2025, the publication of the mObywatel source code was grandly announced.

What exactly did we receive? In accordance with the statutory obligation resulting from the Act of May 26, 2023, on the mObywatel application:

- [A website with the code](https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny), which requires logging in via mObywatel/Trusted Profile/Bank/eID.
- A gallery for browsing selected assets and the code itself under the MIT license (included in this mirror in the [Android](./Android) and [iOS](./iOS) directories along with the license) regarding the design system of the mObywatel app, i.e., UI components, colors used, styles, and pictograms.
- A disabled right-click context menu, which can be re-enabled using extensions like [Allow Right Click](https://webextension.org/listing/allow-right-click.html).

This means that the following were **not** published:

- Business logic (in any scope)
- API, communication with other components
- Authentication module
- Documentation

Imagine that mObywatel is a massive building complex. We were supposed to learn the secrets of this complex—instead, we only found out what kind of paint was used to decorate the building's facade...

## How to download the code yourself

In this repository, you will find a tool that automates the entire process: from scanning the file tree and cleaning the code of line numbers to generating a ready-to-use ZIP archive.

| Tool                                                                     | Function                                                                                         |
| :----------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------- |
| [**mobywatel-downloader-userscript.js**](./mobywatel-downloader.user.js) | Downloads the entire repository (Android or iOS) as a clean ZIP file directly from your browser. |

### 1. Browser Preparation

To run the script, a Userscript Manager extension is required.

- **Recommended solution:** **Firefox** browser + [**Violentmonkey**](https://addons.mozilla.org/en-US/firefox/addon/violentmonkey/) extension.
- **For Chromium-based browsers** (Chrome, Edge, Brave): [**ScriptCat**](https://chromewebstore.google.com/detail/ndcooeababalnlpkfedmmbbbgkljhpjf) extension.

> [!IMPORTANT]
> Notice for Chrome users (Manifest V3):
> Google Chrome restricts script execution. For the tool to work correctly:
>
> 1. Enable **Developer Mode** in the extensions settings.
> 2. In the ScriptCat extension settings, allow user script execution ([instructions here](https://docs.scriptcat.org/en/docs/use/open-dev/)).

### 2. Installation and Usage

1. **Install the extension:** Install your chosen script manager in your browser.
   - **Important:** If you are using Chrome/Edge, you must additionally enable **Developer Mode** and allow the extension to run user scripts (details in the section above).
2. In this repository, find the [mobywatel-downloader-userscript.js](./mobywatel-downloader.user.js) file, click the **"Raw"** button, and then confirm the script installation in the extension window.
3. Log in to the official website: [mObywatel - Source Code](https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny).
4. Navigate to the Android or iOS section.
5. Click the blue **DOWNLOAD SOURCE** button that will appear in the bottom right corner of the screen.

## Security and Legal Aspects

The provided tool has been designed with respect for security and privacy principles:

1. **No Authorization Bypass:** The script **does not** allow access to the code for unauthorized users. The user must independently and legally complete the identity verification process on the official government website. The tool only begins to function once the user already has full access to the resources.
2. **Local Execution (Client-Side):** The entire process of scanning, cleaning, and packaging the code takes place exclusively in the user's browser. The script **does not send any data** to external servers. The ZIP file is generated in your computer's RAM.
3. **Automation, Not Hacking:** The script does not exploit security vulnerabilities. It merely performs a sequence of standard operations (clicking folders, reading `iframe` content) that any user could perform manually. The tool only saves the time required to manually copy/transcribe hundreds of files.
4. **MIT License Compliance:** According to the official COI information, the mObywatel source code is released under the MIT License. This license explicitly permits the copying and distribution of the software. Technical blocks implemented on the website (e.g., disabling right-click or text selection) are interface-level restrictions, not legal ones, and do not invalidate the freedoms granted by the MIT License.
5. **Accountability:** The tool does not violate the "accountability" principle mentioned in the CSIRT MON opinions. The fact that the code was downloaded by a user remains recorded in the government server's logs (via the logged-in user's session), just as it is during manual browsing.

---

## Media Publications

> [!NOTE]
> The following articles and official announcements are available in **Polish**.

### Ministry of Digital Affairs has published the mObywatel source code

**Source [PL]:** https://www.gov.pl/web/cyfryzacja/ministerstwo-cyfryzacji-opublikowalo-kod-zrodlowy-mobywatela

In accordance with the regulations, the Ministry of Digital Affairs has made the mObywatel application source code available—allowing everyone to better understand the government app used by nearly 11 million Poles.

The publication of information regarding the source code results from the Act of May 26, 2023, on the mObywatel application. To ensure this process was secure, expert opinions were provided by key institutions of the national cybersecurity system – CSIRT GOV, CSIRT MON, and CSIRT NASK.

A link to the mObywatel application code has been posted in the Public Information Bulletin (BIP) of the Ministry of Digital Affairs.

---

### Source Code of the mObywatel Application (BIP)

**Source [PL]:** https://mc.bip.gov.pl/aplikacja-mobywatel/kod-zrodlowy-aplikacji-mobywatel.html

Pursuant to the statutory obligation resulting from the Act of May 26, 2023, on the mObywatel application (Journal of Laws of 2023, item 1234), the Minister of Digital Affairs publishes information on the availability of the mObywatel application source code.

After obtaining the legally required opinions from CSIRT MON, CSIRT ABW, and CSIRT NASK, the Minister of Digital Affairs made a portion of the application's source code available, presenting its coding philosophy and structure. Parts of the code not made available for public view may contain functions of key importance from the perspective of application security. The published code does not contain any user data.

Access to the shared part of the mObywatel source code is possible after confirming identity using one of the selected methods. This requirement results from recommendations contained in the CSIRT MON opinion regarding the criteria for user accountability.

The mObywatel application source code has been made available for public inspection at: https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny

---

### Analyzing the CSIRT MON opinion on the mObywatel code publication

**Source [PL]:** https://kontrabanda.net/r/analizujemy-opinie-csirt-mon-w-sprawie-publikacji-kodu-mobywatela/

This article contains a .pdf copy of the official CSIRT MON opinion on this matter.
