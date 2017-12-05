#!/bin/bash

#Created by Adrian Rupala 2017
#Simple bash script for adding GNU/Linux User.

if [ $(id -u) -eq 0 ]; then
	egrep "^$username" /etc/passwd >/dev/null
	if [ $? -eq 0 ]; then
		echo "$username exists!"
		exit 1
	else
		pass=$(perl -e 'print crypt($ARGV[0], "password")' $password)
		useradd -m -p $pass $username
		[ $? -eq 0 ] && echo "User has been added to system!" || echo "Failed to add a user!"
		sudo adduser $username sudo
	fi
else
	echo "Only root may add a user to the system"
	exit 2
fi
