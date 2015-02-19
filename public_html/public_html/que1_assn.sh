#!/bin/bash

#Question No.1

#. The Hostname of System you are on: 
( echo "The Hostname of System you are on is:"
 hostname && date )  > assignment.log

#The type and version of the operating system the machine is running?
( echo "The type and version of the operating system the machine is running is:" 
 uname -o && uname --version && date ) >> assignment.log


#The full path to your home directory
( echo "the full path of ur home directory is"
 pwd && date ) >> assignment.log

#which other users are logged in
( echo "users logged in are:"
 who && date ) >> assignment.log

#What groups you belong to
( echo "the groups to which i belong is"
 groups && date ) >> assignment.log

#What files (excluding directories) which are located in my home directory and all its subdirectories
(echo "files (excluding directories) which are located in my home directory and all its subdirectories"
 find $HOME -type f && date ) >> assignment.log
