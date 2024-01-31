/*
 * Programa que a partir d'un arxiu qualsevol i l'arxiu csv amb les paraules a traduir
 * crea un arxiu amb el text traduit. Els fitxers s'indiquen en linea de comanda
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.lang.String;
import java.util.Arrays;

public class Traduccio {
    public static void main(String[] args) throws IOException {
        // args = [origen, traduccio, desti]

        // Comprovem que la crida tingui 3 arguments
        if (args.length != 3) {
            System.out.println("ERROR: Cal especificar els fitxers origen, traduccio i destinació");
            return;
        }
        tradueix(args[0], args[1], args[2]);

    }

    public static void tradueix(String fitxerOrigen, String fitxerTraduccio, String fitxerDestinacio) throws IOException{
        // Obrim en lectura el fitxer d'origen
        FileReader fileReader = new FileReader(fitxerOrigen);
        BufferedReader input = new BufferedReader(fileReader);

        // Obrim en escriptura el fitxer de desti
        FileWriter fileWriter = new FileWriter(fitxerDestinacio);
        BufferedWriter sortida = new BufferedWriter(fileWriter);

        while(true){
            String line = input.readLine(); // Llegim la linia
            if (line == null) break; // Si esta buida sortim
            String linia = tradueixLinia(line, fitxerTraduccio); // Traduim la linia
            sortida.write(linia); // Escrivim la linea al fitxer de desti
            sortida.newLine();
        }

        input.close();
        sortida.close();
    }

    public static String tradueixLinia(String linia, String fitxerTraduccio) throws IOException{

        // Format del diccionari
        String[][] dict = getDict(fitxerTraduccio);
        //printArray(dict);

        String line = linia;
        for (int i = 0; i<dict.length; i++){ // Recorrem el diccionari linia a linia
            for (int j = 0; j<dict[i].length; j++){
                line = linia.replace(dict[i][0], dict[i][1]); // Fem el replace de la linia
            }
        }

        return line;
    }

    private static String[][] getDict(String fitxerTraduccio) throws IOException {
        int lines = getLines(fitxerTraduccio);
        String[][] dict = new String[lines][2];

        // Llegim el fitxer de traduccio
        FileReader fileReader = new FileReader(fitxerTraduccio);
        BufferedReader input = new BufferedReader(fileReader);

        int i = 0;
        while(true){
            String line = input.readLine();
            if (line == null) break;
            String[] keyVal = line.split(","); // [clau, valor]
            dict[i] = keyVal; // Assignem la linea al seu lloc del diccionari
            i++;
        }
        input.close();
        return dict;
    }

    public static int getLines(String fitxerTraduccio) throws IOException {
        FileReader fileReader = new FileReader(fitxerTraduccio);
        BufferedReader input = new BufferedReader(fileReader);
        int k = 0;
        while (true){
            String line = input.readLine();
            if (line == null) break;
            k++; // Incrementem el comptador de linies
        }
        input.close();
        return k;
    }

    public static void printArray(String[][] array){
        System.out.println(Arrays.deepToString(array));
    }
}
