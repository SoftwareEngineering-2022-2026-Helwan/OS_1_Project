#!/bin/bash 

AppName="processControleApp"

# to compile the man page
# pandoc lib/$AppName.1.md -s -t man -o lib/$AppName.1 

sudo rm /usr/share/man/man1/$AppName.1 2&>/dev/null 
sudo cp lib/$AppName.1 /usr/share/man/man1/ 

gcc main.c -o $AppName
