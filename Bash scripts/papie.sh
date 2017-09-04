#!/bin/bash

printf "Przygotowania do uruchomienia aplikacji...\n\n"
#sudo apt-get update
#sudo apt-get install openjdk-8-jre openjdk-8-jdk wget unzip -y
pkill -f 'java -jar'
export DISPLAY=:0
xset s noblank
xset s off
xset -dpms

cd ~/Pictures/
printf "Wykryte pliki w folderze Obrazy: \n"
ls

printf "\nTrwa uruchamianie aplikacji...\n"
printf "Aby zamknac aplikacje nacisnij ctrl+c\n\n"

cd ~/

FILELIST=/tmp/filelist
MONITOR_DIR=~/Pictures

[[ -f ${FILELIST} ]] || ls ${MONITOR_DIR} > ${FILELIST}

while : ; do
    cur_files=$(ls ${MONITOR_DIR})
    diff <(cat ${FILELIST}) <(echo $cur_files) || \
         { echo "Znalazłem zmiany: " ;
           echo $cur_files > ${FILELIST} ;
           pkill -f 'java -jar'
         }

    echo "Sprawdzanie zmian..."
    if [ ! $(pgrep java) ] ;
    then
      cd ~/
      java -jar pokaz.jar &
    fi
    sleep 15
done
