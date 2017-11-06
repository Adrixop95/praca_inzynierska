# Praca inżynierska

Temat pracy inżynierskiej:
>System wyświetlania informacji w oparciu o Raspberry Pi

Promotor:
>dr hab. inż. Michał Mierzwa

### Opis projektu
System wyświetlania obrazu w oparciu o mikrokomputer Raspberry Pi.
Oprogramowanie łączy się z kontem Google, synchronizuje pliki z wybranym folderem i z niego wyświetla obrazy.

### Wymagania sprzętowe
+ Raspberry Pi B+/2/3/Zero/Zero W
+ Karta pamięci min. 16GB
+ Stałe połączenie z internetem
+  Konto Google

### Platforma testowa
+ Raspberry Pi 3 model B + karta pamięci SanDisk Ultra microSDHC 16GB

### Instalacja

+ Dla macOS:
	- Za pomocą aplikacji "Narzędzia dyskowe" sformatować kartę pamięci jako MS-DOS (FAT) ze schematem partycji "Główny rekord rozruchowy"
	- Uruchomić aplikację "Terminal" a następnie wpisać komendy:
		+ `cd ~/Downloads/` <== przechodzi do folderu Pobrane (misejsce znajdowania się pobranego domyślnie obrazu)
		+ `diskutil list` <== pokazuje listę dysków oraz ich partycji
		+ `sudo diskutil unmountDisk /dev/diskX` <== odmontowuje wybrany przez nas dysk "X"
		+ `sudo dd bs=1m if=obraz.img of=/dev/disk1` <== odtwarza obraz "obraz.img" na dysk "/dev/disk1". 		<br><br>Hint: za pomocą skrótu ctrl+t można sprawdzić ile bajtów zostało przetransferowane na kartę pamięci.  
		(nie mylić tutaj z klawiszem command/cmd!).
	- Odmontuj kartę pamięci aby bezpiecznie ją wyciągnąć z komputera.
		
<br><br>Procedura otwarzania może potrwać nawet parę godzin w zależności od zastosowanej karty pamięci, komputera, systemu operacyjnego oraz innych czynników zewnętrznych, poczekaj cierpliwie i nie odłączaj karty. <br> <br>

+ Dla Microsoft Windows
	- Todo

+ Dla GNU/Linux
	- Todo

<br><br> Nikt nie ponosi odpowiedzialności za wszelkie uszkodzenia wynikające z winy użytkownika. <br><br>

### Zalecany sposób uruchomienia aplikacji
Uruchom aplikację GUI_ssh.jar aby uruchomić, zrestartować albo wyłączyć system.

### Ręczny sposób uruchomienia systemu
Przejdź do pobranego folderu z systemem oraz wpisz komendy
> chmod +x ./DisplayMode.sh <br>
> screen ./DisplayMode.sh

### Użyte technologie oraz oprogramowanie
+ [Raspbian GNU/Linux](https://www.raspbian.org)
+ [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
+ [NetBeans](https://netbeans.org)
+ [Apple macOS](https://www.apple.com)
+ [Microsoft Windows](https://www.microsoft.com/pl-pl/windows/)
+ [OPENICONIC](https://useiconic.com/open)
+ [GDriveFS](https://github.com/dsoprea/GDriveFS)

Pełna lista zostanie zaktualizana w przyszłości.

### Uznanie twórczości
Pełna lista plików testowych zawartych w projecie.

+ [Photo by Jon Tyson on Unsplash](https://unsplash.com/photos/eIhH7RTlTZA?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Benjamin Lambert on Unsplash](https://unsplash.com/photos/Dj7Oje6Cgf0?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Igor Ovsyannykov on Unsplash](https://unsplash.com/photos/7b5R_0S5a-s?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Stéphan Valentin on Unsplash](https://unsplash.com/photos/LbUzPqxPUAs?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)
+ [Photo by Adam Grabek on Unsplash](https://unsplash.com/photos/PPr7LA1I_3U?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)

### Zainstalowane na obrazie (aplikacje)
+ openbox (menadżer okien dla interface graficznego X Window Server)
+ xorg (implementacja podsystemu grafiki X Window System)
+ lightdm (menadżer logowania)
+ openjdk-8-jre, openjdk-8-jdk (wolnodostępna i otwarta implementacja języka Java)
+ screen (uruchamianie aplikacji w tle)
+ xscreensaver (standardowy zestaw wygaszaczy ekranu)
+ unclutter (aplikacja służąca do ukrycia kursora)
+ find (znajdowanie plików na dysku)
+ GDriveFS (synchrinizacja z Google Drive)

### Komendy wykonane na obrazie od pierwszego uruchomienia
+ sudo raspi-config (w celu uruchomienia połączenia ssh)
+ sudo nano /etc/wpa_supplicant/wpa_supplicant.conf
	- network={
	- 	ssid="nazwa_sieci"
	-  	psk="haslo"
	-   }
+ sudo apt-get update && sudo apt-get upgrade
+ sudo apt-get install openbox xorg lightdm htop nano vim openjdk-8-jre openjdk-8-jdk screen xscreensaver unclutter python-pip build-essential python-dev libfuse-dev
+ echo "exec openbox-session" > ~/.xinitrc 
+ sudo raspi-config (w celu ustawienia automatycznego logowania i bootowania do DE)
+ sudo nano /etc/lightdm/lightdm.conf
	- Dodanie polecenia `xserver-command=X -s 0 dpms` w celu wyłączenia sleepu
+ sudo nano /boot/cmdline.txt
	- consoleblank=0
+  xscreensaver-demo w celu wyłączenia wygaszania ekranu
+  sudo nano ./xinitrc i dodanie polecenia `@unclutter -display :0 -noevents -grab` oraz poleceń `xset s noblank 
`,`xset s off `,`xset -dpms`
+ export XAUTHORITY=~/.Xauthority w celu umożliwienia sudo użycia export display
+ sudo pip install gdrivefs w celu synchronizacji z Google Drive
+ zmodyfikowanie skryptu /etc/rc.local z dodaniem komendy `gdfs -o allow_other /home/pi/gdfs.creds /mnt/gdrivefs` dodającej autouruchamianie synchronizacji z google drive 
+ dodanie do /etc/xdg/openbox/autostart kodu
`export DISPLAY=:0
xset s noblank
xset s off
xset -dpms
if ping -q -c 1 -W 1 8.8.8.8 >/dev/null; then
  bash /home/pi/Serwer_wyswietlania/DisplayMode.sh &
else
  sudo java -jar /home/pi/Serwer_wyswietlania/Pierwsze/gui_alfa.jar &
fi` w celu autostartu skryptów zgodnie ze statusem sieci

<br><br>
**Stworzone dla UŚ oraz ŚMCEBI z ♥**

``By Adrian Rupala``
