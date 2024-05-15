#!/bin/bash

# Compilamos los archivos java, si da error acaba el programa
if ! javac *.java; then
	exit 1
fi

if [ "$#" -eq 0 ]; then
	printf "No has introduït cap argument\n"
	exit 1
fi

# Executem la comanda amb el primer argument
java org.junit.platform.console.ConsoleLauncher -c "$*"

