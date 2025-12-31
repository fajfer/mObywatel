![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Platform: Android | iOS](https://img.shields.io/badge/Platform-Android%20%7C%20iOS-blue)

# mObywatel mobilny

[English version here](README-en.md)

Dnia 29.12.2025 zostało hucznie ogłoszone opublikowanie kodu źródłowego mObywatela

Co dokładnie dostaliśmy? Zgodnie z obowiązkiem ustawowym wynikającym z ustawy z dnia 26 maja 2023 r. o aplikacji mObywatel (Dz. U. z 2023 r. poz. 1234):

- [stronę z kodem](https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny), do której należy się zalogować mObywatelem/profilem zaufanym/bankiem/eID,
- galerię do przeglądania części assetów oraz samego kodu na licencji MIT (w tym mirrorze umieszczonego w katalogach [Android](./Android) i [iOS](./iOS) wraz z licencją) dotyczącego designu systemu aplikacji mObywatel, tj. komponenty UI, użyte kolory, style, piktogramy,
- zablokowany prawy przycisk myszy, który odblokować można dodatkiem takim jak np. [Allow Right Click](https://webextension.org/listing/allow-right-click.html)

Oznacza to, że nie zostały opublikowane takie rzeczy jak:

- logika biznesowa (w żadnym zakresie)
- API, komunikacja z innymi komponentami
- moduł uwierzytelniania
- dokumentacja

Wyobraźmy sobie, że mObywatel jest wielkim kompleksem budowli, mieliśmy poznać sekrety tego kompleksu - zamiast tego dowiedzieliśmy się, jaka farba została użyta do pomalowania fasady obiektu...

## Jak ściągnąć kod samemu

W tym repozytorium znajdziesz narzędzie, które automatyzuje cały proces: od skanowania drzewa plików, przez czyszczenie kodu z numerów linii, aż po generowanie gotowego archiwum ZIP.

| Narzędzie                                                                      | Funkcja                                                                                       |
| :----------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------- |
| [**mobywatel-downloader-userscript.js**](./mobywatel-downloader-userscript.js) | Pobiera całe repozytorium (Android lub iOS) jako czysty plik ZIP bezpośrednio z przeglądarki. |

### 1. Przygotowanie przeglądarki

Do uruchomienia skryptu wymagany jest dodatek typu Userscript Manager.

- **Rekomendowane rozwiązanie:** Przeglądarka **Firefox** + dodatek [**Violentmonkey**](https://addons.mozilla.org/pl/firefox/addon/violentmonkey/).
- **Dla przeglądarek Chromium** (Chrome, Edge, Brave): Dodatek [**ScriptCat**](https://chromewebstore.google.com/detail/ndcooeababalnlpkfedmmbbbgkljhpjf).

> [!IMPORTANT] Uwaga dla użytkowników Chrome (Manifest V3):
> Google Chrome ogranicza działanie skryptów. Aby narzędzie działało poprawnie:
>
> 1. Włącz **Tryb Dewelopera** w ustawieniach rozszerzeń.
> 2. W ustawieniach rozszerzenia ScriptCat zezwól na obsługę Userscriptów ([instrukcja tutaj](https://docs.scriptcat.org/en/docs/use/open-dev/)).

### 2. Instalacja i użycie

1. **Instalacja dodatku:** Zainstaluj wybrany manager skryptów w przeglądarce.
   - **Ważne:** Jeśli używasz Chrome/Edge, musisz dodatkowo włączyć **Tryb Dewelopera** oraz zezwolić rozszerzeniu na uruchamianie skryptów użytkownika (szczegóły w sekcji powyżej).
2. W tym repozytorium znajdź plik [mobywatel-downloader-userscript.js](./mobywatel-downloader-userscript.js) i wybierz przycisk **"Raw"**, następnie zatwierdź instalację skryptu w oknie dodatku.
3. Zaloguj się na oficjalną stronę: [mObywatel - Kod źródłowy](https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny).
4. Przejdź do sekcji Android lub iOS.
5. Kliknij niebieski przycisk **DOWNLOAD SOURCE**, który pojawi się w prawym dolnym rogu ekranu.

## Bezpieczeństwo i aspekty prawne

Udostępnione narzędzie zostało zaprojektowane z poszanowaniem zasad bezpieczeństwa i prywatności:

1.  **Brak omijania autoryzacji:** Skrypt **nie pozwala** na dostęp do kodu osobom niezalogowanym. Użytkownik musi samodzielnie i legalnie przejść proces weryfikacji tożsamości na oficjalnej stronie rządowej. Narzędzie zaczyna działać dopiero w momencie, gdy użytkownik posiada już pełny dostęp do zasobów.
2.  **Działanie lokalne (Client-Side):** Cały proces skanowania, czyszczenia i pakowania kodu odbywa się wyłącznie w przeglądarce użytkownika. Skrypt **nie wysyła żadnych danych** na zewnętrzne serwery. Plik ZIP jest generowany w pamięci RAM Twojego komputera.
3.  **Automatyzacja, nie włamanie:** Skrypt nie wykorzystuje luk w bezpieczeństwie. Wykonuje on jedynie sekwencję standardowych operacji (kliknięcie w folder, odczyt zawartości ramki `iframe`), które każdy użytkownik może wykonać ręcznie. Narzędzie jedynie oszczędza czas potrzebny na ręczne kopiowanie/przepisywanie setek plików.
4.  **Zgodność z Licencją MIT:** Zgodnie z oficjalną informacją COI, kod źródłowy mObywatela jest udostępniony na licencji MIT. Licencja ta jawnie zezwala na kopiowanie i dystrybucję oprogramowania. Zastosowane na stronie blokady techniczne (np. zablokowanie prawego przycisku myszy czy kopiowania) mają charakter interfejsowy, a nie prawny i nie unieważniają swobód przyznanych przez licencję MIT.
5.  **Rozliczalność:** Narzędzie nie narusza postulatu "rozliczalności" wspomnianego w opiniach CSIRT MON. Fakt pobrania kodu przez użytkownika pozostaje odnotowany w logach systemowych serwera rządowego (poprzez sesję zalogowanego użytkownika), tak samo jak przy ręcznym przeglądaniu plików.

---

## Publikacje medialne
> [!NOTE]
> Poniższe artykuły i oficjalne komunikaty są dostępne w języku polskim.

### Ministerstwo Cyfryzacji opublikowało kod źródłowy mObywatela
**Źródło:** https://www.gov.pl/web/cyfryzacja/ministerstwo-cyfryzacji-opublikowalo-kod-zrodlowy-mobywatela

Zgodnie z przepisami resort cyfryzacji udostępnił kod źródłowy aplikacji mObywatel - dzięki temu każdy może lepiej poznać rządową aplikację, z której korzysta już blisko 11 milionów Polek i Polaków.

Publikacja informacji dotyczącej kodu źródłowego wynika z ustawy z dnia 26 maja 2023 r. o aplikacji mObywatel. Aby proces ten był bezpieczny, opinie eksperckie w tej sprawie przedstawiły kluczowe instytucje krajowego systemu cyberbezpieczeństwa – CSIRT GOV, CSIRT MON i CSIRT NASK.

Link do kodu aplikacji mObywatel został zamieszczony w Biuletynie Informacji Publicznej Ministerstwa Cyfryzacji.

---

### Kod źródłowy aplikacji mObywatel (BIP)
**Źródło:** https://mc.bip.gov.pl/aplikacja-mobywatel/kod-zrodlowy-aplikacji-mobywatel.html

Zgodnie z obowiązkiem ustawowym wynikającym z ustawy z dnia 26 maja 2023 r. o aplikacji mObywatel (Dz. U. z 2023 r. poz. 1234), Minister Cyfryzacji publikuje informację o udostępnieniu kodu źródłowego aplikacji mObywatel.

Minister Cyfryzacji, po uzyskaniu wymaganych ustawowo opinii CSIRT MON, CSIRT ABW oraz CSIRT NASK, udostępnił część kodu źródłowego aplikacji, prezentującą filozofię oraz strukturę kodowania. Części kodu nieudostępnione do publicznego wglądu mogą zawierać funkcje o kluczowym znaczeniu z punktu widzenia bezpieczeństwa aplikacji. Publikowany kod nie zawiera żadnych danych użytkowników.

Dostęp do udostępnionej części kodu źródłowego aplikacji mObywatel jest możliwy po potwierdzeniu tożsamości jedną z wybranych metod. Wymóg ten wynika z rekomendacji zawartych w opinii CSIRT MON, dotyczących zapewnienia kryterium rozliczalności użytkowników.

Kod źródłowy aplikacji mObywatel został udostępniony do publicznego wglądu na stronie internetowej dostępnej pod adresem: https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny

---

### Analizujemy opinię CSIRT MON w sprawie publikacji kodu mObywatela
**Źródło:** https://kontrabanda.net/r/analizujemy-opinie-csirt-mon-w-sprawie-publikacji-kodu-mobywatela/

Artykuł zawiera kopię .pdf oficjalnej opinii CSIRT MON w tej sprawie.
