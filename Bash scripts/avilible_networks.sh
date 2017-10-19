#!/bin/bash

#Created by Adrian Rupala
#Simple script to show available wireless network

sudo iw dev wlan0 scan | grep SSID
