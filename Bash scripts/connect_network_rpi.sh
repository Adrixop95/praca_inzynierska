#!/bin/bash

#Created by Adrian Rupala
#Simple script to add network to wpa_supplicant

echo 'network={
    ssid="'$name'"
    psk="'$password'"
}'>> /etc/wpa_supplicant/wpa_supplicant.conf
