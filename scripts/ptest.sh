#!/bin/bash

# Programa per a utilitzar el prgtest sense haver d'estar a la carpeta de l'exercici,
# funcionara aixi: ptest [nombre exercici]
# 	ptest 32_24
#
# També pot fer-se servir amb varis exercicis a la vegada:
#	ptest 32_24 31_15
#

# Colors a utilitzar amb el echo
BLUE="\033[38;2;89;139;255m"
RED="\033[38;2;255;89;89m"
GREEN="\033[38;2;66;245;141m"
YELLOW="\033[38;2;197;204;61m"
BOLD="\033[1m" # Negreta
NC='\033[0m' # No Color


# Verificar si els arguments son exercicis
for user in "$@"; do

	# Obtenim l'adreça del directori de l'exercici
	directoriVeri=$(ls -d ~/introrpg/"$user"* 2>/dev/null)
	
	# Verifiquem el codi d'error del ls
	if [ $? -ne 0 ]; then
		printf "${BOLD}${YELLOW}Error: no s'ha trobat l'exercici ${user}\n${NC}"
		exit 1 # Sortim del script amb un codi d'error
	fi
	
done


for user in "$@"; do

	# Obtenim l'adreça del directori de l'exercici
	directori=$(ls -d ~/introrpg/"$user"* 2>/dev/null)
	
	# Imprimeix la informació per a la depuració
	printf "${BOLD}${BLUE}Exercici: ${user}${NC}\n"
	printf "${BOLD}${RED}Directori: ${directori}${NC}\n"
	
	# Ens anem al directori del exercici per executar el prgtest, si no existeix sortim
	cd $directori || exit
	
	# Compilem per si de cas no estava compilat
	javac *.java
	
	# Afegim a staged els arxius que no hi siguin
	git add --all >/dev/null
	
	# Fem un commit amb comentari
	git commit -am "prgtest $user" >/dev/null
	
	# Executem el prgtest
	prgtest
	
done

printf "${BOLD}${GREEN}Vols fer un PUSH (y/n)? ${NC}"
read -r resposta

if [ "$resposta" = "y" ]; then
	git push;
else
	exit;

fi


