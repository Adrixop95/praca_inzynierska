#!/bin/bash

#Created by Adrian Rupala
#First run script

if ping -q -c 1 -W 1 8.8.8.8 >/dev/null; then
  cd /home/pi/Serwer_wyswietlania
  screen ./DisplayMode.sh
else
  echo "IPv4 is down"
  sudo java -jar /home/pi/Serwer_wyswietlania/Pierwsze/gui_alfa.jar
fi
