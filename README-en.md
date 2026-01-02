# mObywatel Mobile
On December 29, 2025, the publication of mObywatel's source code was announced.

What exactly did we get? In accordance with the legal obligation arising from the Act of May 26, 2023 on the mObywatel application (Journal of Laws of 2023, item 1234):

- [The code page](https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny), which requires logging in with mObywatel/a [trusted profile](https://pl.wikipedia.org/wiki/Profil_zaufany)/a Polish bank account/eID
- A gallery for browsing some of the assets and the code itself, licensed under the ([MIT license](LICENSE.md)), limited to code concerning the design system of the mObywatel application, i.e. UI components, colours, styles, icons
- The ability to right-click is blocked, you need to use an add-on such as [Allow Right Click](https://webextension.org/listing/allow-right-click.html)

This means that things like these were not published:
- business logic, in any scope
- API, communication with other components
- authentication module
- documentation

Imagine that mObywatel is a large building complex. We were supposed to learn the secrets of this complex, and instead, we have found out what kind of paint was used to paint the facade of the building...

## How to download the code yourself

| Script | Action |
|--------|--------|
| [mobywatel-downloader.user.js](mobywatel-downloader.user.js) | Downloading single/multiple files using the [Greasemonkey](https://addons.mozilla.org/pl/firefox/addon/greasemonkey/) add-on |
| [organize_files.py](organize_files.py) | Ran in the same directory as the files from the script above, it creates a directory tree |
| [clean_line_numbers.py](clean_line_numbers.py) | Cleaning line numbers from the code |


## Media publications
### Statement from the COI CEO regarding the MIT license
(...) The publication of the code is based on the opinions of CSIRTs, hence this solution and the scope of the code (perhaps not so extensive). When publishing code, we should rather apply an open-source license, and MIT was chosen as the most appropriate. Ukraine also published under a license, only they chose EUPL 1.2.

~ Radosław Maćkiewicz
Source: Discussion on [LinkedIn](https://www.linkedin.com/feed/update/urn:li:activity:7411457386525220866?commentUrn=urn%3Ali%3Acomment%3A%28activity%3A7411457386525220866%2C7411458791025676288%29&replyUrn=urn%3Ali%3Acomment%3A%28activity%3A7411457386525220866%2C7411470169593794560%29&dashCommentUrn=urn%3Ali%3Afsd_comment%3A%287411458791025676288%2Curn%3Ali%3Aactivity%3A7411457386525220866%29&dashReplyUrn=urn%3Ali%3Afsd_comment%3A%287411470169593794560%2Curn%3Ali%3Aactivity%3A7411457386525220866%29) under the post by MP [Michał Gramatyka](https://pl.wikipedia.org/wiki/Micha%C5%82_Gramatyka)
### Ministry of Digital Affairs published mObywatel's source code [pl]
Source: https://www.gov.pl/web/cyfryzacja/ministerstwo-cyfryzacji-opublikowalo-kod-zrodlowy-mobywatela

In accordance with the regulations, the Ministry of Digital Affairs made the source code of the mObywatel application available - thanks to this, everyone can better understand the government application that is already used by nearly 11 million Polish women and men.

The publication of information regarding the source code results from the Act of May 26, 2023 on the mObywatel application. To make this process safe, expert opinions on this matter were presented by key institutions of the national cybersecurity system – CSIRT GOV, CSIRT MON and CSIRT NASK.

The link to the mObywatel application code was posted in the Bulletin of Public Information of the Ministry of Digital Affairs.

---
### Source code of the mObywatel application [pl]
Source: https://mc.bip.gov.pl/aplikacja-mobywatel/kod-zrodlowy-aplikacji-mobywatel.html

In accordance with the legal obligation arising from the Act of May 26, 2023 on the mObywatel application (Journal of Laws of 2023, item 1234), the Ministry of Digital Affairs publishes information on the disclosure of the source code of the mObywatel application.

The Ministry of Digital Affairs, after obtaining the legally required opinions of CSIRT MON, CSIRT ABW and CSIRT NASK, made available part of the source code of the application, presenting the philosophy and coding structure. Parts of the code not disclosed to the public may contain functions of key importance to the security of the application. The published code does not contain any user data.

Access to the disclosed part of the source code of the mObywatel application is possible after confirming identity using one of the selected methods. This requirement results from the recommendations contained in the CSIRT MON opinion, regarding ensuring the criterion of user accountability.

The source code of the mObywatel application has been made available for public viewing on the website available at: https://www.mobywatel.gov.pl/kod-zrodlowy-mobywatel-mobilny

---
### We analyze the opinion of CSIRT MON on the publication of the mObywatel code [pl]
Source: https://kontrabanda.net/r/analizujemy-opinie-csirt-mon-w-sprawie-publikacji-kodu-mobywatela/

The article contains a PDF copy of the CSIRT MON opinion on the subject matter.
