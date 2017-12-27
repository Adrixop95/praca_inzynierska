#!/bin/bash

#Created by Adrian Rupala 2017
#Simple bash script for adding GNU/Linux User.

#sprawdzenie czy skrypt jest wykonywany w trybie super-user (id 0)
if [ $(id -u) -eq 0 ]; then
	#komenda egrep sprawdza czy podana przez użytkownika nazwa jest w /passwd a następnie przekazuje zawartość do /dev/null
	egrep "^$username" /etc/passwd >/dev/null
	#jeśli komenda jest wykonana poprawnie zakończ
	if [ $? -eq 0 ]; then
		exit 1
	#jeśli komenda jest wykonana z wynikiem false; dodaj użytkownika z podanymi wcześniej hasłem oraz username; dodaj użytkownika do grupy superuser
	else
		pass=$(perl -e 'print crypt($ARGV[0], "password")' $password)
		useradd -m -p $pass $username
		[ $? -eq 0 ] && echo "Uzytkownik zostal dodany!" || echo "Blad!"
		sudo adduser $username sudo
	fi
#jeśli skrypt nie jest wykonywane jako super-user zakończ go z błędem 2 (tutaj brak uprawnień)
else
	exit 2
fi
