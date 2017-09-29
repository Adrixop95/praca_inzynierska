#!/bin/bash

#Created by Adrian Rupala 2017
#Simple bash script for searching raspberry pi on network with arp and nmap command.

{
brew --version
if [ $? -eq 0 ]; then
  printf '\nHomebrew jest już zainstalowany\n'
else
  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
fi
brew update
brew upgrade
brew install nmap
nmap -sP 192.168.1.1/24
} &> /dev/null

printf '\nTwoje Raspberry PI w sieci: \n\n'
arp -a | grep 'b8:27:eb'
printf '\n'
