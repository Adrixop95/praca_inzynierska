#!/bin/bash

#Created by Adrian Rupala 2017

case "$(uname -s)" in

  Darwin)


      brew --version
      if [ $? -eq 0 ]; then
        /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
      else
        printf '\nHomebrew jest już zainstalowany\n'
      fi
      brew update
      brew upgrade
      brew install nmap
      /usr/local/Cellar/nmap/7.60/bin/nmap -sP 192.168.1.1/24

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
