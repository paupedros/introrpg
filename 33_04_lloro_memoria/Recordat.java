/*
 * Programa que funciona com un lloro; ens va preguntant paraules fins que es trobi
 * text en blanc, el text el va registrant a un fitxer 'records.txt'.
 * Al final indicara els textos que ha recordat
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Recordat {
    public static void main(String[] args) throws IOException {
        String path = "records.txt";
        processaEntrada(path);
        System.out.println("D'acord");
        mostraRecords(path);
        System.out.println("Adéu");

    }

    /*
     * Demana frases per entrada estàndard i les guarda a un fitxer
     *
     * @param nomFitxer: nom del fitxer
     */
    public static void processaEntrada(final String nomFitxer) throws IOException {
        FileWriter fileWriter = new FileWriter(nomFitxer);
        BufferedWriter sortida = new BufferedWriter(fileWriter);

        System.out.println("El lloro pregunta paraula:");
        String paraula = Entrada.readLine();
        while (!paraula.isEmpty()) {
            paraula = paraula.strip();
            System.out.println("El lloro registra: " + paraula);
            sortida.write(paraula);
            sortida.newLine();
            System.out.println("El lloro pregunta paraula:");
            paraula = Entrada.readLine();
        }
        sortida.close();
    }

    /*
     * Mostra el contingut del fitxer amb nom nomFitxer
     *
     * @param nomFitxer: el nom del fitxer del que es mostrarà el contingut
     */
    public static void mostraRecords(final String nomFitxer) throws IOException {
        FileReader fileReader = new FileReader(nomFitxer);
        BufferedReader input = new BufferedReader(fileReader);

        int i = 0;
        while (true) {
            String linia = input.readLine();
            if (linia == null && i == 0) {
                System.out.println("El lloro no recorda res");
                i++;
            }
            if (linia == null)
                break;
            System.out.println("El lloro recorda: " + linia);
        }

        input.close();
    }
}
