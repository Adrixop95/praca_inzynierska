#! /usr/bin/env bash

FILELIST=/tmp/filelist
MONITOR_DIR=/Users/adrix/Pictures/pics_test

[[ -f ${FILELIST} ]] || ls ${MONITOR_DIR} > ${FILELIST}

while : ; do
    cur_files=$(ls ${MONITOR_DIR})
    diff <(cat ${FILELIST}) <(echo $cur_files) || \
         { echo "Alert: ${MONITOR_DIR} changed" ;
           echo $cur_files > ${FILELIST} ;
         }

    echo "Waiting for changes."
    pkill -f 'java -jar'
    sleep $(expr 1)
done
