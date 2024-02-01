/*
 * Biblioteca per a realitzar metodes per tenir un log
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static int seq = 0;

    public static String printError(String text) throws IOException {
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));

        String lineWrite = String.format("[%d] ERROR: %s", seq, text);

        sortida.write(lineWrite);
        sortida.newLine();
        sortida.close();
        return lineWrite;
    }

    public static String printDebug(String text) throws IOException {
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));
        String lineWrite = String.format("[%d] DEBUG: %s", seq, text);
        sortida.write(lineWrite);
        sortida.newLine();
        sortida.close();
        return lineWrite;
    }

    public static String printWarning(String text) throws IOException{
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));
        String lineWrite = String.format("[%d] WARNING: %s", seq, text);
        sortida.write(lineWrite);
        sortida.newLine();
        sortida.close();
        return lineWrite;
    }

    public static String printInfo(String text) throws IOException{
        seq++;

        // Obrim el fitxer 'log.txt' en escriptura per afegir
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));
        String lineWrite = String.format("[%d] INFO: %s", seq, text);
        sortida.write(lineWrite);
        sortida.newLine();
        sortida.close();
        return lineWrite;
    }

    public static void reset() throws IOException{
        // Reiniciem la variable sequencial
        seq = 0;
    }
}
