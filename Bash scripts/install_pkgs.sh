#!/bin/bash

#Created by Adrian Rupala 2017
#Bash script for preparing all nessessery pkgs.
sudo su
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install openbox xorg lightdm htop nano vim openjdk-8-jre openjdk-8-jdk screen xscreensaver unclutter
echo "exec openbox-session" >> ~/.xinitrc
echo "@unclutter -display :0 -noevents -grab" >> ~/.xinitrc
echo "xset s noblank" >> ~/.xinitrc
echo "xset s off" >> ~/.xinitrc
echo "xset -dpms" >> ~/.xinitrc
echo "xserver-command=X -s 0 dpms" >> /etc/lightdm/lightdm.conf
echo "alias temp='vcgencmd measure_temp'" >> ~/.bash_aliases 
