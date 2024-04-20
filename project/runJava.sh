#!/bin/bash

if java -version &> /dev/null ; then
	#compile java code first
	javac Main.java
	#check to debug 
	echo "[!] Enter 0 To Skip Debug ! "
	echo -n "[+] Enter Debug Number : "
	read debugNum
	
	if [ "$debugNum" -gt 0 ]; then
		java Main -d "$debugNum"
	else
		java Main
	fi
else
	echo "Java Not Installed !!"
fi

