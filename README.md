# mObywatel mobilny
**🇬🇧English version [HERE](README-en.md)**

Dnia 29.12.2025 zostało hucznie ogłoszone opublikowanie kodu źródłowego mObywatela

Co dokładnie dostaliśmy? Zgodnie z obowiązkiem ustawowym wynikającym z ustawy z dnia 26 maja 2023 r. o aplikacji mObywatel (Dz. U. z 2023 r. poz. 1234):

- [stronę z kodem](https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny), do której należy się zalogować mObywatelem/profilem zaufanym/bankiem/eID,
- galerię do przeglądania części assetów oraz samego kodu (na [licencji MIT](LICENSE.md)) dotyczącego designu systemu aplikacji mObywatel, tj. komponenty UI, użyte kolory, style, piktogramy,
  - zablokowany prawy przycisk myszy, który odblokować można dodatkiem takim jak na przykład [Allow Right Click](https://webextension.org/listing/allow-right-click.html)

Oznacza to, że nie zostały opublikowane takie rzeczy jak:
- logika biznesowa, w żadnym zakresie
- API, komunikacja z innymi komponentami
- moduł uwierzytelnia
- dokumentacja

Wyobraźmy sobie, że mObywatel jest wielkim kompleksem budowli, mieliśmy poznać sekrety tego kompleksu - zamiast tego dowiedzieliśmy się, jaka farba została użyta do pomalowania fasady obiektu...

## Jak ściągnąć kod samemu

| Skrypt                                                       | Działanie |
|--------------------------------------------------------------|-----------|
| [mobywatel-downloader.user.js](mobywatel-downloader.user.js) | Ściąganie pojedynczych/wielu plików za pomocą dodatku [Greasemonkey](https://addons.mozilla.org/pl/firefox/addon/greasemonkey/) |
| [organize_files.py](organize_files.py)                       | Umieszczony w tym samym katalogu co pliki ze skryptu powyżej tworzy drzewo katalogów |
| [clean_line_numbers.py](clean_line_numbers.py)               | Sprzątanie numerów linii z kodu                                                      |


## Publikacje medialne
### Wypowiedź CEO COI ws. licencji MIT
(...) Publikacja kodu odbywa się na podstawie opinii CSIRTów, stąd takie rozwiązanie i zakres kodu (może nie aż tak obszerny). Publikując kod raczej powinniśmy nałożyć licencję opensource i została wybrana MIT jako najbardziej odpowiednia. Ukraina też opublikowała na licencji, tylko wybrała EUPL 1.2.

~ Radosław Maćkiewicz
Źródło: Dyskusja na [LinkedIn](https://www.linkedin.com/feed/update/urn:li:activity:7411457386525220866?commentUrn=urn%3Ali%3Acomment%3A%28activity%3A7411457386525220866%2C7411458791025676288%29&replyUrn=urn%3Ali%3Acomment%3A%28activity%3A7411457386525220866%2C7411470169593794560%29&dashCommentUrn=urn%3Ali%3Afsd_comment%3A%287411458791025676288%2Curn%3Ali%3Aactivity%3A7411457386525220866%29&dashReplyUrn=urn%3Ali%3Afsd_comment%3A%287411470169593794560%2Curn%3Ali%3Aactivity%3A7411457386525220866%29) pod postem Pana posła [Michała Gramatyki](https://pl.wikipedia.org/wiki/Micha%C5%82_Gramatyka)
### Ministerstwo Cyfryzacji opublikowało kod źródłowy mObywatela
Źródło: https://www.gov.pl/web/cyfryzacja/ministerstwo-cyfryzacji-opublikowalo-kod-zrodlowy-mobywatela

Zgodnie z przepisami resort cyfryzacji udostępnił kod źródłowy aplikacji mObywatel - dzięki temu każdy może lepiej poznać rządową aplikację, z której korzysta już blisko 11 milionów Polek i Polaków.

Publikacja informacji dotyczącej kodu źródłowego wynika z ustawy z dnia 26 maja 2023 r. o aplikacji mObywatel. Aby proces ten był bezpieczny, opinie eksperckie w tej sprawie przedstawiły kluczowe instytucje krajowego systemu cyberbezpieczeństwa – CSIRT GOV, CSIRT MON i CSIRT NASK.

Link do kodu aplikacji mObywatel został zamieszczony w Biuletynie Informacji Publicznej Ministerstwa Cyfryzacji.

---
### Kod źródłowy aplikacji mObywatel
Źródło: https://mc.bip.gov.pl/aplikacja-mobywatel/kod-zrodlowy-aplikacji-mobywatel.html

Zgodnie z obowiązkiem ustawowym wynikającym z ustawy z dnia 26 maja 2023 r. o aplikacji mObywatel (Dz. U. z 2023 r. poz. 1234), Minister Cyfryzacji publikuje informację o udostępnieniu kodu źródłowego aplikacji mObywatel.

Minister Cyfryzacji, po uzyskaniu wymaganych ustawowo opinii CSIRT MON, CSIRT ABW oraz CSIRT NASK, udostępnił część kodu źródłowego aplikacji, prezentującą filozofię oraz strukturę kodowania. Części kodu nieudostępnione do publicznego wglądu mogą zawierać funkcje o kluczowym znaczeniu z punktu widzenia bezpieczeństwa aplikacji. Publikowany kod nie zawiera żadnych danych użytkowników.

Dostęp do udostępnionej części kodu źródłowego aplikacji mObywatel jest możliwy po potwierdzeniu tożsamości jedną z wybranych metod. Wymóg ten wynika z rekomendacji zawartych w opinii CSIRT MON, dotyczących zapewnienia kryterium rozliczalności użytkowników.

Kod źródłowy aplikacji mObywatel został udostępniony do publicznego wglądu na stronie internetowej dostępnej pod adresem: https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny

---
### Analizujemy opinię CSIRT MON w sprawie publikacji kodu mObywatela
Źródło: https://kontrabanda.net/r/analizujemy-opinie-csirt-mon-w-sprawie-publikacji-kodu-mobywatela/

Artykuł zawiera kopię .pdf opinii CSIRT MON w tej sprawie.
