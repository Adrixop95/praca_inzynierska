#!/bin/bash

#Created by Adrian Rupala 2017
#Bash script for changing cloud and local storage display.

#Sprawdzenie czy jest połączenie z siecią
if ping -q -c 1 -W 1 8.8.8.8 >/dev/null; then
  #Sprawdzenie czy w folderze /mnt/gdrivefs/display_pictures są pliki, jesli są uruchom DisplayMode_cloud.sh, jeśli nie DisplayMode.sh
  if [ $(ls -A /mnt/gdrivefs/display_pictures | wc -l) -gt 0 ]; then
     bash /home/pi/Serwer_wyswietlania/DisplayMode_cloud.sh &
  else
     bash /home/pi/Serwer_wyswietlania/DisplayMode.sh &
   fi
   #Jeśli nie ma sieci uruchom gui_alfa.jar
else
  sudo java -jar /home/pi/Serwer_wyswietlania/Pierwsze/gui_alfa.jar &
fi
