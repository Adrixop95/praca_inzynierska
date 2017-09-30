#!/bin/bash

#Created by Adrian Rupala 2017
#Simple bash script for searching raspberry pi on network with arp and nmap command.

printf '\nTwoje Raspberry PI w sieci: \n\n'
arp -a | grep 'b8:27:eb'
printf '\n'
