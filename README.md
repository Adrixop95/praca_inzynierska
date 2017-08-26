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
+ Raspberry Pi 3
+ Raspberry Pi Zero W

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

+ Dla Ubuntu GNU/Linux
	- Todo

<br><br> Nikt nie ponosi odpowiedzialności za wszelkie uszkodzenia wynikające z winy użytkownika. <br><br>

### Użyte technologie oraz oprogramowanie
+ [Raspbian GNU/Linux](https://www.raspbian.org)
+ [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
+ [NetBeans](https://netbeans.org)
+ [Apple macOS](https://www.apple.com)

Pełna lista zostanie zaktualizana w przyszłości.

### Źródła

Todo.  


<br><br>
**Stworzone dla UŚ oraz ŚMCEBI z ♥**

``By Adrian Rupala``
