#!/bin/bash

#Created by Adrian Rupala
#Simple script to add network to wpa_supplicant

#Przesłanie tekstu podanego przez użytkownika do pliku wpa_supplicant.conf; odpowiada za połączenie z wybraną siecią wifi
echo 'network={
    ssid="'$name'"
    psk="'$password'"
}'>> /etc/wpa_supplicant/wpa_supplicant.conf
