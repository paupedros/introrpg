#!/bin/bash

########################################################################
# Script per utilitzar el prgtest de forma simplificada
#
# Autor: Pau Pedrós Ribas
# Data de Creació: 4 de novembre de 2023
#
# Ús del script:
# - ptest [nom_exercici]: Executa el prgtest per a l'exercici específic.
#   Exemple: ptest 32_24
#
# - ptest [nom_exercici1] [nom_exercici2] ...:
#   Executa el prgtest per a múltiples exercicis simultàniament.
#   Exemple: ptest 32_24 31_15
#
# - ptest (sense paràmetres): Executa el prgtest al directori actual.
#
# Requisits:
# - Els exercicis han de ser directoris amb noms que comencin pel nombre de l'exercici.
#   Exemple: 32_24_nomes_lletres
#		el nombre es 32_24
#
# Notes addicionals:
# - Si no es troben arxius java no es procedirà amb la correcció
# - Si el prgtest detecta errors, el script no procedirà amb el push.
# - Abans de fer el push es borraràn els arxius amb extensió dins la 
#	llista a la variable constant EXTENSION_LIST
#
# Colors utilitzats:
# BLUE, RED, GREEN, YELLOW, ORANGE, BOLD, NC (No Color)
#
# Aquest script permet simplificar les proves amb el prgtest i afegir commits
# ràpids als exercicis. Desenvolupat per a facilitar el procés de correcció.
########################################################################


# Colors a utilitzar amb el echo
BLUE="\033[38;2;89;139;255m"
RED="\033[38;2;255;89;89m"
GREEN="\033[38;2;66;245;141m"
YELLOW="\033[38;2;197;204;61m"
ORANGE="\033[38;5;214m"
BOLD="\033[1m" # Negreta
NC='\033[0m'   # No Color

# Array dels exercicis aptes per a les proves
exercicisValids=()

# Funcio per executar les proves
executar_proves() {
	# Ens anem al directori del exercici per executar el prgtest
	cd $directori
	# Verifiquem si hi han arxius java al directori
	if ls *.java 1>/dev/null 2>&1; then
		# Compilem per si de cas no estava compilat
		javac *.java
		if [ "$?" -ne 0 ]; then
			exit 1
		fi
	else
		printf "${BOLD}${YELLOW}⚠️  Error: No s'han trobat arxius Java al directori.${NC}\n"
		exit 1
	fi
	num_ejercicio=$(basename "$(pwd)" | cut -d'_' -f1,2)
	# Imprimeix la informació per a la depuració
	printf "${BOLD}${BLUE}Exercici: ${num_ejercicio}${NC}\n"
	printf "${BOLD}${RED}Directori: ${directori}${NC}\n"
	# Afegim a staged els arxius que no hi siguin
	git add --all >/dev/null
	data=$(date +"%Y-%m-%d %H:%M:%S")
	# Fem un commit amb comentari
	git commit -am "prgtest $num_ejercicio" -m "Hora: ${data}" >/dev/null
	# Executem el prgtest
	prgtest
	# Si el prgtest dona error sortim del codi
	if [ $? -ne 0 ]; then
		if [ "${#exercicisValids[@]}" -lt 2 ]; then
			exit 1
		fi
	else
	# Indiquem que hem passat les proves i fem un commit indicant-ho també
		printf "${BOLD}${GREEN}✅ Ha passat les proves!${NC}\n"
		#git commit --amend -m "prgtest OK $num_ejercicio" >/dev/null
	fi
}

# Verificar si els arguments son exercicis
if [ "$#" -eq 0 ]; then
    # No hi ha arguments, utilitzar el directori actual
    directori=("$(pwd)")
	executar_proves
else
	for user in "$@"; do

		# Obtenim l'adreça del directori de l'exercici
		directoriVeri=$(ls -d ~/introrpg/"$user"* 2>/dev/null)

		# Verifiquem el codi d'error del ls
		if [ $? -ne 0 ]; then
			printf "${BOLD}${YELLOW}⚠️  Error: no s'ha trobat l'exercici ${user}\n${NC}"
			continue # Sortim del script amb un codi d'error
		else
			# Anem afegint els directoris que si son exercicis
			exercicisValids+=("$user")
		fi

	done
fi

for user in "${exercicisValids[@]}"; do
	# Obtenim l'adreça del directori de l'exercici
	directori=$(ls -d ~/introrpg/"$user"* 2>/dev/null)
	executar_proves
done

printf "${BOLD}${ORANGE}Vols fer un PUSH (y/n)? ${NC}"
read -r resposta

if [ "$resposta" = "y" ]; then
	# Delete all .class files
	find . -name "*.class" -type f -delete
	git push
fi
exit 0
