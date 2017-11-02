#!/bin/bash

#Created by Adrian Rupala 2017

printf "Przygotowania do uruchomienia aplikacji...\n"
printf "Trwa aktualizowanie oraz instalowanie potrzebnych aplikacji...\n\n"
pkill -f 'java -jar'
export DISPLAY=:0
xset s noblank
xset s off
xset -dpms
FILELIST=/tmp/filelist
MONITOR_DIR=example_pictures/

#cd ~/Server_wyswietlania
var1="$(find ~/ -name DisplayMode.sh)"
pathdef=${var1::len-14}
#printf "$pathdef"
cd "$pathdef"

path="$PWD"

cd example_pictures/
printf "Wykryte pliki w folderze: \n"
ls

printf "\nTrwa uruchamianie systemu...\n"
cd "$path"
pwd
ls

[[ -f ${FILELIST} ]] || ls ${MONITOR_DIR} > ${FILELIST}

while : ; do
    cur_files=$(ls ${MONITOR_DIR})
    diff <(cat ${FILELIST}) <(echo $cur_files) || \
         {
           echo "\nZnalazlem zmiany!\n\n" ;
           echo $cur_files > ${FILELIST} ;
           pkill -f 'java -jar'
         }

    if [ ! $(pgrep java) ] ;
    then
      printf "\nTrwa ladowanie danych aplikacji w celu w celu wyswietlania zdjec...\n"
      printf "Aby zamknac system nacisnij ctrl+c\n\n"
      cd "$path"
      java -jar pokaz.jar &
    fi
    sleep 10
done
