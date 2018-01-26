#!/bin/bash

#Created by Adrian Rupala
#Simple script to show available wireless network

SUBSTRING=$(cat /proc/net/wireless | grep : | cut -d' ' -f 2)
net="${SUBSTRING::-1}"
prefix=": "
cd /sbin/ && ./iwlist $net scan | grep ESSID | cut -d':' -f 2 | tr -d '"' | sed 's/.*/: &/'
