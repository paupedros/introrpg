/* Aquest programa comprova si les matricules apuntades en un txt son vàlides o no. Segons la resposta les escriu en un txt o en un altre. A més aquesta versió millorada. comprova si la matricula es repetida i en cas de ser aixi la ignora. */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ClassificaMatricules {

    private static String rutaLectura = "llegides.txt";
    private static String rutaValides = "italianes.txt";
    private static String rutaInvalides = "desconegudes.txt";

    public static void main(String[] args) throws IOException {
        separadorMatricules();
    }

    public static void separadorMatricules() throws IOException {
        //Obrir el fitxer 'llegides' en lectura
        BufferedReader input = new BufferedReader(new FileReader(rutaLectura));

        //Obrir el fitxer 'italianes.txt' en escriptura
        BufferedWriter sortidaValides = new BufferedWriter(new FileWriter(rutaValides));
        //Obrir el fitxer 'desconegudes.txt' en escriptura
        BufferedWriter sortidaInvalides = new BufferedWriter(new FileWriter(rutaInvalides));

        String linia = input.readLine();    //agafa la primera linia del document
        while (linia != null) {
            linia = linia.trim();
            if (matriculaItalianaValida(linia) && !esMatriculaRepetida(linia, rutaValides)) {
                sortidaValides.write(linia);
                sortidaValides.newLine();
            }
            if (linia.isEmpty()) {
                linia = input.readLine();
                continue;
            }
            if (!matriculaItalianaValida(linia) && !esMatriculaRepetida(linia, rutaInvalides)) {
                sortidaInvalides.write(linia);
                sortidaInvalides.newLine();
            }
            linia = input.readLine();
        }
        //Tanquem els filers jeje
        input.close();
        sortidaValides.close();
        sortidaInvalides.close();
    }

    public static boolean esMatriculaRepetida(String matricula, String rutaFitxer) throws IOException {
        // Obrir en lectura el fitxer desitjat
        BufferedReader input = new BufferedReader(new FileReader(rutaFitxer));
        matricula = matricula.strip();

        while (true) {
            String linia = input.readLine();
            if (linia == null) break;
            linia = linia.strip();
            if (linia.equals(matricula)) {
                input.close();
                return true;
            }
        }
        input.close();
        return false;
    }

    public static boolean matriculaItalianaValida(String matricula) {

        if (matricula.length()==7 &&
        esLletraValidaPerMatriculaItaliana(matricula.charAt(0)) &&
        esLletraValidaPerMatriculaItaliana(matricula.charAt(1)) &&
        esLletraValidaPerMatriculaItaliana(matricula.charAt(5)) &&
        esLletraValidaPerMatriculaItaliana(matricula.charAt(6)) &&
        Character.isDigit(matricula.charAt(2)) &&
        Character.isDigit(matricula.charAt(3)) &&
        Character.isDigit(matricula.charAt(4))   ) {
            return true;
        }
        return false;
    }
    public static boolean esLletraValidaPerMatriculaItaliana(char ch) {

        boolean esLletraValida = false;
        //Si la lletra es alguna d'aquestas, tampoc val'
        String filtre = "IOUQ";
        boolean passaFiltre = true;
        for (int j=0; j<filtre.length(); j++) {
            if (ch == filtre.charAt(j) ) {
                passaFiltre=false;
                break;
            }
        }

        if (ch>='A' && ch<='Z' && passaFiltre) {
            esLletraValida = true;
        }
        return esLletraValida;
    }

 }

