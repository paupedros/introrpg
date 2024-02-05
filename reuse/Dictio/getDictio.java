/*
 * Programa que ens imprimeix per pantalla
 * un arxiu csv com a una taula d'arrays
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class getDictio {
    public static void main(String[] args) throws IOException {
        String file = "file.csv";
        String[][] dict = convertCSVtoArrays(file);
        printArray(dict);
    }

    /**
     * @param file
     * @return
     * @throws IOException
     * Convert a CSV file to an array of arrays
     */
    private static String[][] convertCSVtoArrays(String file) throws IOException {
        int lines = getLines(file);
        int width = getWidth(file);
        String[][] dict = new String[lines][width];

        // Llegim el fitxer CSV
        FileReader fileReader = new FileReader(file);
        BufferedReader input = new BufferedReader(fileReader);

        int i = 0;
        while(true){
            String line = input.readLine();
            if (line == null) break;
            String[] keyVal = line.split(";"); // [clau, valor]
            dict[i] = keyVal; // Assignem la linea al seu lloc del diccionari
            i++;
        }
        input.close();
        return dict;
    }

    /**
     * @param array
     * Print an array of arrays
     */
    public static void printArray(String[][] array) {
        for (String[] row : array) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    /**
     * @param file
     * @return Number of file lines
     * @throws IOException
     */
    public static int getLines(String file) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (input.readLine() != null) lines++;
        input.close();
        return lines;
    }

    /**
     * @param file
     * @return Width of the array inside the array
     * @throws IOException
     */
    private static int getWidth(String file) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        String line = input.readLine();
        input.close();
        // Assuming the first line contains the headers
        String[] headers = line.split(",");
        return headers.length;
    }
}
