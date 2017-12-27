#!/bin/bash

#Created by Adrian Rupala 2017

#Zabij wszystkie procesy java -jar
pkill -f 'java -jar'
#Ustaw główny wyświetlacz na domyślny, wyłącz usypianie
export DISPLAY=:0
xset s noblank
xset s off
xset -dpms
#Ustalenie pliku tymczasowego oraz folderu do monitorowania zmiany plików
FILELIST=/tmp/filelist
MONITOR_DIR=example_pictures/

#Ustaw wartość1 na poszukiwanie folderu z plikiem DisplayMode.sh; dostosuj nazwę folderu; przejdź do niego
var1="$(find ~/ -name DisplayMode.sh)"
pathdef=${var1::len-14}
cd "$pathdef"

path="$PWD"

#przejdź do folderu example_pictures/
cd example_pictures/
ls

#przejdź do folderu ustanowionego przez użytkowania, pokaż jego lokalizację, pokaż jego zawartość
cd "$path"
pwd
ls

#do pliku tymczasowego służącego do monitorowania przekaż zawartość (nazwy plików) z folderu monitorowanego
[[ -f ${FILELIST} ]] || ls ${MONITOR_DIR} > ${FILELIST}

while : ; do
    #Sprawdzaj czy zawartość pliku monitorowanego jest taka sama jak folderu który jest monitorowany
    cur_files=$(ls ${MONITOR_DIR})
    diff <(cat ${FILELIST}) <(echo $cur_files) || \
         #Jeśli zawartość pliku i folderu jest inna wypisz zamianę plików oraz zabij procesy java -jar
         {
           echo $cur_files > ${FILELIST} ;
           pkill -f 'java -jar'
         }

    #Jeśli nie ma aktywnego procesu java przejdź do folderu Serwer_wyswietlania i uruchom proces pokaz_cloud.jar
    if [ ! $(pgrep java) ] ;
    then
      cd "$path"
      java -jar pokaz.jar &
    #Uśpij sprawdzanie na 10 sekund
    fi
    sleep 10
done
