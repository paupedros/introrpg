/*
 * En aquest programa a partir d'un fitxer csv, indicarem la nota
 * mitja dels alumnes
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NotaMitja {
    public static void main(String[] args) throws IOException {
        String path = "notes.csv"; // Indiquem el fitxer a treballar
        FileReader fileReader = new FileReader(path); // Obrim el fitxer
        BufferedReader input = new BufferedReader(fileReader); // Fem un buffer per al fitxer

        int count = 0;
        while (true) {
            String line = input.readLine(); // Llegim la linia
            count++;
            if (count == 1) continue;
            if (count == 2 && line == null) // Si no hi ha ninguna nota
                System.out.println("Cap entrada");

            if (line == null)
                break; // Si arribem al final del fitxer sortim

            String[] linia = line.split(","); // ["nom","4","3","5","2","NP"]

            float mitja = getMitja(linia);

            System.out.printf("%s (%.2f)%n", linia[0], mitja);

        }
        input.close(); // Tanquem el fitxer
    }

    public static float getMitja(String[] notes) {
        int count = 0;
        int suma = 0;
        for (int i = 1; i < notes.length; i++) { // Comptem quantes notes tenim
            String pos = notes[i];
            if (UtilString.esEnter(pos)){ // Si el element es un enter
                //System.out.println(pos);
                suma += UtilString.aEnter(pos, false);
            }
            count++;
        }
        //System.out.println("suma: " + suma);
        float mitja = (float) suma/count;
        return mitja;
    }

    public static void printArray(String[] array){
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
}
