# Praca inżynierska

Temat pracy inżynierskiej:
>System wyświetlania informacji w oparciu o Raspberry Pi

Promotor:
>dr hab. inż. Michał Mierzwa

### Opis projektu
System wyświetlania obrazu w oparciu o mikrokomputer Raspberry Pi.
Oprogramowanie łączy się z kontem Google, synchronizuje pliki z wybranym folderem i z niego wyświetla obrazy.

[Nagranie](https://youtu.be/ydiRBeQj2tc) prezentujące pracę systemu.

### Wymagania sprzętowe
+ Raspberry Pi B+/2/3/Zero/Zero W
+ Karta pamięci min.  8GB (zalecane 16GB)
+ Stałe połączenie z internetem
+ Konto Google

### Platforma testowa
+ Raspberry Pi 3 model B 
+ Raspberry Pi 1 model B+ 

### Instalacja oraz sposób uruchomienia systemu
+ Z zakładki "[Release](https://github.com/Adrixop95/praca_inzynierska/releases)" należy pobrać najnowszą wersję obrazu. Następnie należy podpiąć kartę pamięci o rozmiarze 8GB+ do komputera i za pomocą aplikacji [Etcher](https://etcher.io) odtworzyć obraz na karcie pamięci. Obraz ten zawiera wszystkie potrzebne biblioteki oraz aplikacje wraz ze skompilowaną wersją najnowszych dostepnych aplikacji służących do wyświetlania obrazu oraz kreatora uruchomienia. System po odtworzeniu oraz pierwszym podłączeniu automatycznie rozszerzy swój rozmiar na całą dostępną powierzchnię karty pamięci a następnie zrestartuje się. Po tej procedurze będzie gotowy do pracy.

Domyślne konto użytkownika:
>nazwa użytkownika: pi </br>
>hasło: qaz123wsx

+ Następnie z tej samej zakładki [Release](https://github.com/Adrixop95/praca_inzynierska/releases) należy pobrać najnowszą dostępną paczkę "Release" zawierającą aplikację desktopową służącą do sterowania całością systemu. Wymagana ona do działania zainstalowanych na kompuerze bibliotek [Java SE Runtime Environment 8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html). Po rozpakowaniu paczki należy uruchomić aplikację "Display_app.jar" a następnie postępować za intrukcjami pojawiającymi się na ekranie.

<br><br> Nikt nie ponosi odpowiedzialności za wszelkie uszkodzenia wynikające z winy użytkownika. <br><br>

### Użyte technologie oraz oprogramowanie
+ [Raspbian GNU/Linux](https://www.raspbian.org)
+ [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
+ [NetBeans](https://netbeans.org)
+ [GDriveFS](https://github.com/dsoprea/GDriveFS)
+ [PiShrink](https://github.com/Drewsif/PiShrink)

### Uznanie twórczości
Pełna lista plików testowych zawartych w projecie.

+ [Photo by Jon Tyson on Unsplash](https://unsplash.com/photos/eIhH7RTlTZA?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Benjamin Lambert on Unsplash](https://unsplash.com/photos/Dj7Oje6Cgf0?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Igor Ovsyannykov on Unsplash](https://unsplash.com/photos/7b5R_0S5a-s?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Stéphan Valentin on Unsplash](https://unsplash.com/photos/LbUzPqxPUAs?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Adam Grabek on Unsplash](https://unsplash.com/photos/PPr7LA1I_3U?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)

<br><br>
**Stworzone dla UŚ oraz ŚMCEBI z ♥**

``By Adrian Rupala``
