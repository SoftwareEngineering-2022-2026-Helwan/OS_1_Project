#!/bin/bash 

AppName="procctl"

# to compile the man page
pandoc manPage/$AppName.md -s -t man -o manPage/$AppName.1 

sudo rm /usr/share/man/man1/$AppName.1 2&>/dev/null 
sudo cp manPage/$AppName.1 /usr/share/man/man1/ 

gcc main.c -o $AppName
