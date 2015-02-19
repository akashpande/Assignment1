#!/bin/bash



#Question no 3
#Extend above bash script to rename the all files whose name starts with letter "x" inside your assignment directory and list them on console

#Question no 4
#After renaming all the files store the output of listing of files inside the directory to some assignment.log file with date and time inside the log all re-naming of files happens.


( rename -v 's/\.txt$/1\.txt/' *.txt && rename -v 's//z/' x* && date) | tee -a assignment.log