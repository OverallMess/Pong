@echo off
del .\output\*.class
mkdir output
javac *.java
move *.class ./output
cd output
cls
java Main