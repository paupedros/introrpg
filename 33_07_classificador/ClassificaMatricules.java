/*
 * A partir d'un fitxer 'llegides.txt' classificarem les matricules
 * en italianes i desconegudes, cadascun del tipus en un fitxer:
 * 'italianes.txt' i 'desconegudes.txt'.
 *
 * S'ha reutilitzat i modularitzat el codi de l'exercici 32_21
 * per satisfer les necessitats
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ClassificaMatricules {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("llegides.txt"));
        BufferedWriter italianes = new BufferedWriter(new FileWriter("italianes.txt"));
        BufferedWriter desconegudes = new BufferedWriter(new FileWriter("desconegudes.txt"));
        writePlates(file);

        desconegudes.close();
        italianes.close();
    }


    public static void writePlates(BufferedReader file) throws IOException{


        while (true){

            String plate = file.readLine(); // Llegim la matricula
            if (plate == null) break;
            if (plate.isEmpty()) continue;
            plate = plate.trim();
            boolean italiana = matriculaItalianaValida(plate); // Indiquem si es valida o no

            String path;
            if (italiana){ // Assignem a quin arxiu ha de anar
                path = "italianes.txt";
            }
            else {
                path = "desconegudes.txt";
            }

            // Guardem la matricula al seu corresponent arxiu
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(plate);
            writer.newLine();
            writer.close();
        }
    }



    public static boolean matriculaItalianaValida(String text){
        boolean valid = true;
        char caracter = ' ';
        if (text.length() == 7) {
            for (int i = 0; i < 7; i++) {
                caracter = text.charAt(i);
                // Primeres i ultimes dues lletres
                if (i == 0 || i == 1 || i == 5 || i == 6) {
                    valid = esLletraValidaPerMatriculaItaliana(caracter);
                    if (!valid)
                        break; // Si la lletra no es valida parem de recorrer el text
                }
                // Nombres
                if (i == 2 || i == 3 || i == 4) {
                    valid = numValid(caracter);
                    if (!valid)
                        break;
                }
            }
            if (!valid)
                return false;
            return true;
        }
        return false;
    }

	public static boolean esLletraValidaPerMatriculaItaliana(char caracter) {
		if (!Character.isLetter(caracter))
			return false;
		else if (Character.toUpperCase(caracter) != caracter)
			return false;
		else if (caracter == 'I'
				|| caracter == 'O'
				|| caracter == 'Q'
				|| caracter == 'U')
			return false;
		else if (!(caracter >= 'A' && caracter <= 'Z'))
			return false;
		return true;
	}

	public static boolean numValid(char caracter) {
		if (!Character.isDigit(caracter))
			return false;
		return true;
	}

}
