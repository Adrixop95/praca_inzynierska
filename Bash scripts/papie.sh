#!/bin/bash
printf "Przygotowania do uruchomienia aplikacji...\n\n"
sudo apt-get update
sudo apt-get install openjdk-8-jre openjdk-8-jdk wget unzip -y
wget https://services.gradle.org/distributions/gradle-3.4.1-bin.zip
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-3.4.1-bin.zip
export PATH=$PATH:/opt/gradle/gradle-3.4.1/bin
gradle -v
export DISPLAY=:0
cd ~/Pictures/pics_test
printf "Wykryte pliki w folderze Obrazy: \n"
ls
printf "\nTrwa uruchamianie aplikacji...\n"
printf "Aby zamknac aplikacje nacisnij ctrl+c\n\n"
cd ~/
java -jar pokaz.jar
