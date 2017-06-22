#!/bin/bash 

gnuplot --persist<<EOF
plot "./1.txt"  with linespoints,\
"./2.txt"  with linespoints,\
"./3.txt"  with linespoints,\
"./4.txt"  with linespoints,\
"./5.txt"  with linespoints,\
"./6.txt"  with linespoints,\
"./7.txt"  with linespoints,\
"./8.txt"  with linespoints,\
"./9.txt"  with linespoints,\
"./10.txt"  with linespoints,\
"./11.txt"  with linespoints
EOF
