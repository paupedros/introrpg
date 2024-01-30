/*
 * Programa que a partir d'un fitxer mostra el
 * texts que comencen o acaben en vocal (linia a linia).
 * Es fa servir esVocal del UtilString
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FitxerVocalIniciFi {
    public static void main(String[] args) throws IOException {
        String path = "frases.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader input = new BufferedReader(fileReader);
        while (true) {
            String linia = input.readLine();
            if (null == linia)
                break;
            if(UtilString.esVocal(linia.charAt(0))
            || UtilString.esVocal(linia.charAt(linia.length() - 1)))
                System.out.println(linia);
        }
        input.close();
    }
}
