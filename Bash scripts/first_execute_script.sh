#!/bin/bash

#Created by Adrian Rupala
#First run script

if ping -q -c 1 -W 1 8.8.8.8 >/dev/null; then
  screen bash /home/pi/Serwer_wyswietlania/DisplayMode.sh &
else
  sudo java -jar /home/pi/Serwer_wyswietlania/Pierwsze/gui_alfa.jar &
fi
