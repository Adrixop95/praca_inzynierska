#!/bin/bash

#Created by Adrian Rupala
#Simple script to show available wireless network

#Pobranie z pliku /cat/net/wireless oraz odpowiednie przesortowanie wyniku informacji o kartcie sieciowej
SUBSTRING=$(cat /proc/net/wireless | grep : | cut -d' ' -f 2)
net="${SUBSTRING::-1}"
#Przjście do folderu z aplikacjami oraz uruchomienie aplikacji iwlist odpowiedzialnej
# między innymi za wyszukiwanie dostępnej sieci wifi a następnie przesortowanie wyniku w celu odpowiedniego dopasowania go do aplikacji
cd /sbin/ && ./iwlist $net scan | grep ESSID | cut -d':' -f 2 | tr -d '"' | sed 's/.*/: &/'
