#!/bin/bash

#Created by Adrian Rupala 2017

case "$(uname -s)" in

  Darwin)
    printf 'Twoj system to Apple macOS\n'
    #printf 'Instalowanie brew...\n\n'

    #brew --version
    #if [ $? -eq 0 ]; then
    #  printf '\nHomebrew jest już zainstalowany\n'
    #else
    #  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
    #fi

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

    ;;

  Linux)
    printf 'Twoj system to GNU/Linux'
    printf 'Instalowanie nmap...\n\n'

    sudo apt-get update -y
    sudo apt-get install nmap -y

    {
      nmap -sP 192.168.1.1/24
    } &> /dev/null

    printf '\n\nTwoje Raspberry PI w sieci: \n'
    arp -a | grep 'b8:27:eb'

    ;;

  *)
    echo 'Nie znam twojego systemu!'
    ;;

esac
