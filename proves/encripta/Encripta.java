
/* Programa con una capçalera de una largada moderada */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Encripta {
    public static void main(String[] args) throws IOException {
        boolean encripta = true;
        if (args.length < 3) {
            System.out.println("ERROR: Cal especificar els fitxers d'origen, traducció i destinació");
        } else if (args.length == 4) {
            String encriptaODesencripta = args[3];
            if (encriptaODesencripta.equals("desencripta"))
                encripta = false;
            else if (!encriptaODesencripta.equals("encripta")) {
                System.out.println("Ús: java Encripta <origen> <traducció> <destinació> [encripta|desencripta]");
                return;
            }
        }

        String fitxerOrigen = args[0];
        String fitxerTraduccio = args[1];
        String fitxerDestinacio = args[2];
        tradueix(fitxerOrigen, fitxerTraduccio, fitxerDestinacio, encripta);

    }

    public static void tradueix(String fitxerOrigen, String fitxerTraduccio, String fitxerDestinacio, boolean encripta)
            throws IOException {
        BufferedReader origen = new BufferedReader(new FileReader(fitxerOrigen));
        BufferedWriter destinacio = new BufferedWriter(new FileWriter(fitxerDestinacio));

        // Convertim el fitxer de traduccio a una taula d'arrays
        String[][] taula = convertCSVtoArrays(fitxerTraduccio);

        tradueixArxiu(origen, destinacio, taula, encripta);

        origen.close();
        destinacio.close();
    }

    private static void tradueixArxiu(BufferedReader origen, BufferedWriter destinacio, String[][] taula,
            boolean encripta)
            throws IOException {
        while (true) {
            String linia = origen.readLine();
            if (linia == null)
                break;
            if (linia.isEmpty())
                continue;
            String lineReplaced = linia;
            for (int i = 0; i < taula.length; i++) {
                // [clau, valor]
                if (encripta)
                    lineReplaced = lineReplaced.replace(taula[i][0], taula[i][1]).trim();
                else
                    lineReplaced = lineReplaced.replace(taula[i][1], taula[i][0]).trim();
            }
            destinacio.write(lineReplaced);
            destinacio.newLine();
        }
    }

    public static String[][] convertCSVtoArrays(String file) throws IOException {
        int lines = getLines(file);
        String[][] dict = new String[lines][2];

        // Llegim el fitxer CSV
        FileReader fileReader = new FileReader(file);
        BufferedReader input = new BufferedReader(fileReader);

        int i = 0;
        while (true) {
            String line = input.readLine();
            if (line == null)
                break;
            String[] keyVal = line.split(", "); // [clau, valor]
            dict[i] = keyVal; // Assignem la linea al seu lloc del diccionari
            i++;
        }
        input.close();
        return dict;
    }

    public static int getLines(String file) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (input.readLine() != null)
            lines++;
        input.close();
        return lines;
    }

    
}
