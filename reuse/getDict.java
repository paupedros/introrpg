import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class getDict {
    public static void main(String[] args) throws IOException {
        String file = "traduccio.csv";

        String[][] dict = getDict(file);
        printArray(dict);
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

    public static void printArray(String[][] array){
        System.out.println(Arrays.deepToString(array));
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
}
