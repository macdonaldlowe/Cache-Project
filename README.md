
# Project 1: Cache-Project

* Author: MacDonald Lowe
* Class: CS321 Section 1
* Semester: Fall 2021

## Overview

This program builds out a double cache system and parses given text
files. It giving metrics on the accessing and retrieval within the
caches.


## Reflection

For the most part I enjoyed this project. I used a kind of waterfall
method of implementation where I set up the files with guiding text
and outlined in rough psuedocode what each method would do and how 
the code would flow. This method proved useful and tends to speed up 
my progress with smaller projects. It allows me to front end the
logical and conceptual thinking and then just focus on the pure coding
of the project. Without having to domain switch between those two 
things it quickens the pace I can get project done.

I had two real struggles in this project. The first was just 
familiarizing myself with java again. For the past four months I've 
been working with other languages like c++ and python so coming back
to java was a bit jarring. The other struggle was fixing a logical
error that I made. I failed to recognize that if a cache hit you have
to remove that item and add it to the top. I was just adding the same 
item to the top, essentially creating a duplicate.


## Compiling and Using

Compile command : 
    javac CacheTest.java

To run the code once you have compiled you have two options. First to
build a 1 cache system with this command format :
    java CacheTest 1 <cache size> <textfile name>

The second option is to build a 2 cache system with this format: 
    java CacheTest 2 <1st-level cache size> <2nd-level cache size> <textfilename>

## Results 

The result is a two cache system that mimicks many of the processes
of real world caches. It shows how the large cache with the linked list
will be fairly slow.

## Sources used

Used this link as a reference for decimal format :
https://stackoverflow.com/questions/8819842/best-way-to-format-a-double-value-to-

Used this link to reference linked list methods : 
https://www.javatpoint.com/java-linkedlist