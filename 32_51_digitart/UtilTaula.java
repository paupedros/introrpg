/*
 * Biblioteca que farem servir per a manipular arrays
 *
 * Moduls:
 * - substitueix(char[][] taula, char inici, char fi)
 *
 */

public class UtilTaula {

    public static char[][] substitueix(char[][] taula, char inici, char fi) {
        char[][] newArray = new char[taula.length][taula[0].length]; // Creem un nou array
        for (int i = 0; i < taula.length; i++) { // Recorrem les files de la taula
            for (int j = 0; j < taula[i].length; j++) { // Recorrem element per element de la taula
                char ch = taula[i][j];
                if (ch == inici){
                    newArray[i][j] = fi;
                }
                else {
                    newArray[i][j] = ch;
                }

            }
        }
        return newArray;
    }

}