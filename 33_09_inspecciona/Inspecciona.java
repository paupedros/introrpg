/*
 * Programa que agafa com a arguments posibles camins cap a fitxers.
 * Per cada fitxer:
 *
 * - Comprova si es un cami existent, si no existeis "No trobat"
 *
 * - Indica els permisos per l'usuarien format GNU (rwx)
 *
 * - Indica si es un fitxer o un directori
 *      - directori: Mostra el nom dels fitxers i
 *      directoris que contingui, de manera ordenada
 *      - fitxer: Indica la seva longitud en bytes
 *
 * - Si es pot llegir i la seva extensio sigui coneguda (.java o .txt),
 * mostrara el seu contingut envoltat del caracter '|' per cada linia,
 * per poder distingir espais
 *
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Inspecciona {

    public static void main(String[] args) throws IOException {

        for (String argument : args) {
            File file = new File(argument);
            // Indiquem quin es l'argument que processem
            String missatge = "Processa argument: " + argument;
            System.out.println(missatge);
            for (int i = 0; i < missatge.length(); i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.println();

            if (file.exists()) { // Si el fitxer existeix
                // Indiquem els permisos GNU
                System.out.print(getPermisos(file));

                // Si es un directori:
                if (file.isDirectory()) {
                    System.out.print(" directori");

                    String[] list = file.list();
                    if (list.length < 1)
                        System.out.print(" buida");
                    else {
                        System.out.print(" que conté: ");
                        Arrays.sort(list);
                        for (int i = 0; i < list.length; i++) {
                            if (i == list.length - 1)
                                System.out.print(list[i]);
                            else
                                System.out.print(list[i] + ", ");
                        }
                        System.out.println();
                    }
                }

                // Si es un fitxer:
                if (file.isFile()) {
                    System.out.print(" fitxer");
                    // Indiquem la longitud en bytes
                    long longitud = file.length();
                    if (longitud > 0)
                        System.out.println(" de mida en bytes: " + longitud);
                    else
                        System.out.println(" buit");

                    // Mostrem el contingut del fitxer
                    System.out.println("Amb els continguts:");
                    System.out.println(mostraFitxer(file));

                }

            } else
                System.out.println("No trobat");
        }

    }

    public static String mostraFitxer(File file) throws IOException {
        String contingut = "";

        BufferedReader input = new BufferedReader(new FileReader(file));

        while (true) {
            String line = input.readLine();
            if (line == null)
                break;

            // Afegim el caracter '|' al principi i al final
            contingut += "|" + line + "|" + "\n";
        }

        input.close();
        return contingut;
    }

    public static String getPermisos(File file) {
        char[] permisos = { '-', '-', '-' }; // [r,w,x]

        if (file.canRead())
            permisos[0] = 'r';
        if (file.canWrite())
            permisos[1] = 'w';
        if (file.canExecute())
            permisos[2] = 'x';

        return String.format("%c%c%c", permisos[0], permisos[1], permisos[2]);

    }

}
