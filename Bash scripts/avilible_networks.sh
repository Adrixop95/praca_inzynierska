#!/bin/bash

#Created by Adrian Rupala
#Simple script to show available wireless network

#Wykonanie komendy iw odpowiadającej za połączenia bezprzewodowe oraz przesortowanie po nazwie SSID
sudo iw dev wlan0 scan | grep SSID
