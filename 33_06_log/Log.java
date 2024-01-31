/*
 * Biblioteca per a realitzar metodes per tenir un log
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static int seq = 0;

    public static void printError(String text) throws IOException {
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));

        sortida.write(String.format("[%d] ERROR: %s", seq, text));
        sortida.newLine();
        sortida.close();
    }

    public static void printDebug(String text) throws IOException {
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));

        sortida.write(String.format("[%d] DEBUG: %s", seq, text));
        sortida.newLine();
        sortida.close();
    }

    public static void printWarning(String text) throws IOException{
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));

        sortida.write(String.format("[%d] WARNING: %s", seq, text));
        sortida.newLine();
        sortida.close();
    }

    public static void printInfo(String text) throws IOException{
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));

        sortida.write(String.format("[%d] INFO: %s", seq, text));
        sortida.newLine();
        sortida.close();
    }

    public static void reset() throws IOException{
        // Reiniciem la variable sequencial
        seq = 0;
    }
}
