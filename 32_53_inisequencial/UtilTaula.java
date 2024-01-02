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
                if (ch == inici) {
                    newArray[i][j] = fi;
                } else {
                    newArray[i][j] = ch;
                }

            }
        }
        return newArray;
    }

    public static void inicialitzaTaula(int[][] taula, int valor) {
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element de la taula
                taula[i][j] = valor; // canviem el valor de l'element al valor asignat
            }
        }
    }

    public static String taulaToString(int[][] taula) {
        String resultat = "";
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element de la taula
                resultat += String.format("%8d", taula[i][j]); // afegim l'element al string resultat mes un espai
            }
            resultat += "\n"; // al acabar la fila de la taula fem un salt de línea
        }
        return resultat;
    }

    public static void inicialitzaSequencial(int[][] taula, int valorInicial) {
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element de la taula
                if (taula[i][j] == 0) { // si estem al primer element li donem com a valor el valorInicial
                    taula[i][j] = valorInicial;
                    continue;
                }
                valorInicial += 1; // incrementem el valor
                taula[i][j] = valorInicial; // asignem el valor
            }
        }
    }

}