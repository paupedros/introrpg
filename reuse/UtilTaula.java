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
        int valor = valorInicial;
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element de la taula
                taula[i][j] = valor; // canviem el valor de l'element al valor
                valor += 1; // incrementem el valor
            }
        }
    }

    public static String taulaToString(boolean[][] taula, char caracterTrue, char caracterFalse) {
        String resultat = "";
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element de la taula
                if (taula[i][j] == true) {
                    resultat += caracterTrue;
                    continue;
                }
                resultat += caracterFalse;
            }
            // if (i!= taula.length - 1) {
            resultat += "\n"; // al acabar la fila de la taula fem un salt de línea
            // }
        }
        return resultat;
    }

    public static void inicialitzaBuida(boolean[][] taula) {
        for (int k = 0; k < taula.length; k++) {
            for (int j = 0; j < taula[k].length; j++) {
                taula[k][j] = false;
            }
        }
    }

    public static void inicialitzaPrimeraDiagonal(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element de la taula
                if (i == j) {
                    taula[i][j] = true;
                } else {
                    taula[i][j] = false;
                }
            }
        }
    }

    public static void inicialitzaVerticalMig(boolean[][] taula) {
        int mig;
        if (taula[0].length % 2 == 0) {
            mig = taula[0].length / 2 - 1;
        } else {
            mig = taula[0].length / 2;
        }

        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element
                if (j == mig) {
                    taula[i][j] = true;
                    continue;
                }
                taula[i][j] = false;
            }
        }
    }

    public static void inicialitzaHoritzontalMig(boolean[][] taula) {
        int mig;
        if (taula.length % 2 == 0) {
            mig = taula.length / 2 - 1;
        } else {
            mig = taula.length / 2;
        }

        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element
                if (i == mig) {
                    taula[i][j] = true;
                    continue;
                }
                taula[i][j] = false;
            }
        }
    }

    public static void inicialitzaQuarts(boolean[][] taula) {
        int migVertical;
        int migHorizontal;
        if (taula[0].length % 2 == 0) {
            migVertical = taula[0].length / 2 - 1;
        } else {
            migVertical = taula[0].length / 2;
        }
        if (taula.length % 2 == 0) {
            migHorizontal = taula.length / 2 - 1;
        } else {
            migHorizontal = taula.length / 2;
        }
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element
                if (i == migHorizontal) {
                    taula[i][j] = true;
                    continue;
                }
                if (j == migVertical) {
                    taula[i][j] = true;
                    continue;
                }
                taula[i][j] = false;

            }
        }
    }

    public static int getCenterVertical(boolean[][] taula) {
        if (taula[0].length % 2 == 0) {
            return taula[0].length / 2 - 1;
        }
        return taula[0].length / 2;
    }

    public static int getCenterHori(boolean[][] taula) {
        if (taula.length % 2 == 0) {
            return taula.length / 2 - 1;
        }
        return taula.length / 2;
    }

    public static int[] getCenter(boolean[][] taula) {
        int[] center = new int[2]; // [vertical, horitzontal]

        // Calcul vertical
        if (taula[0].length % 2 == 0) {
            center[0] = taula[0].length / 2 - 1;
        } else {
            center[0] = taula[0].length / 2;
        }

        // Calcul horitzontal
        if (taula.length % 2 == 0) {
            center[1] = taula.length / 2 - 1;
        } else {
            center[1] = taula.length / 2;
        }

        return center;
    }

    public static void inicialitzaSegonaDiagonal(boolean[][] taula) {
        inicialitzaBuida(taula);
        int pos = taula[0].length - 1;
        for (int i = 0; i < taula.length; i++) {
            if (pos - i >= 0) {
                taula[i][pos - i] = true;
            }
        }
    }

    public static void inicialitzaCreu(boolean[][] taula) {
        inicialitzaBuida(taula);
        // primera diagonal
        int pos = taula[0].length - 1;
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element de la taula
                if (i == j) {
                    taula[i][j] = true;
                }
            }
            // segona diagonal
            if (pos - i >= 0) {
                taula[i][pos - i] = true;
            }
        }
    }

    public static void inicialitzaPasVianants(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            if (i % 2 != 0) { // si la linea es senar
                for (int j = 0; j < taula[i].length; j++) { // recorrem element per element
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaZebra(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            for (int j = 0; j < taula[i].length; j++) { // recorrem element per element
                if (j % 2 != 0)
                    taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaEscacs(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) { // recorrem la taula
            if (i % 2 != 0) { // si la linea es senar
                for (int j = 0; j < taula[i].length; j++) { // recorrem element per element
                    if (j % 2 == 0) {
                        taula[i][j] = true;
                    }
                }
            } else {
                for (int j = 0; j < taula[i].length; j++) { // recorrem element per element
                    if (j % 2 != 0)
                        taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaPrimeraDiagonalPrimerPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) { // recorrem la taula filaxfila
            // recorrem els elements de la fila fins que estiguem al
            // element amb posicio coincident al valor de i
            for (int j = 0; j <= i; j++) {
                taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaPrimeraDiagonalSegonPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) { // recorrem la taula filaxfila
            // recorrem els elements de la fila, si estem en
            // un element que la seva posicio es superior o
            // igual al valor de i el posem a true
            for (int j = 0; j < taula[i].length; j++) {
                if (j >= i) {
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaSegonaDiagonalPrimerPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) {
            // recorrem element per element
            for (int j = 0; j < taula[i].length - i; j++) {
                taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaSegonaDiagonalSegonPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        for (int i = 0; i < taula.length; i++) {
            // recorrem element per element
            // mentre que la posicio del element sigui mes gran o igual a
            // l'ultima posicio de la fila menys la fila actual
            for (int j = taula[i].length - 1; j >= (taula[i].length - 1) - i; j--) {
                taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaVerticalMigPrimerPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "*|"
        int mig = getCenterVertical(taula);
        for (int i = 0; i < taula.length; i++) {
            for (int j = 0; j <= mig; j++) {
                taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaVerticalMigSegonPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "|*"
        int mig = getCenterVertical(taula);
        for (int i = 0; i < taula.length; i++) {
            for (int j = 0; j < taula[i].length; j++) {
                if (j >= mig)
                    taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaHoritzontalMigPrimerPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "*-"
        int mig = getCenterHori(taula);
        for (int i = 0; i <= mig; i++) {
            for (int j = 0; j < taula[i].length; j++) {
                taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaHoritzontalMigSegonPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "-*"
        int mig = getCenterHori(taula);
        for (int i = taula.length - 1; i >= mig; i--) {
            for (int j = 0; j < taula[i].length; j++) {
                taula[i][j] = true;
            }
        }
    }

    public static void inicialitzaQuartsNOPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "*+"
        int[] center = getCenter(taula); // [hori, vertical]
        inicialitzaQuarts(taula); // fem la forma de creu
        for (int i = 0; i < taula.length; i++) {
            if (i <= center[0]) { // si no hem arribat al mig horitzontal
                for (int j = 0; j < center[1]; j++) { // fins el centre vertical
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaQuartsSOPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "**+"
        int[] center = getCenter(taula); // [vertical, hori]
        inicialitzaQuarts(taula); // fem la forma de creu
        for (int i = 0; i < taula.length; i++) {
            if (i > center[0]) { // si ja em passat el mig horitzontal
                for (int j = 0; j <= center[1]; j++) { // fins el centre vertical
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaQuartsNEPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "+*"
        int[] center = getCenter(taula); // [vertical, hori]
        inicialitzaQuarts(taula); // fem la forma de creu
        for (int i = 0; i < taula.length; i++) {
            if (i < center[0]) { // si no hem arribat al centre hortitzontal
                for (int j = 0; j < taula[i].length; j++) {
                    if (j > center[1])
                        taula[i][j] = true; // Si hem passat el centre vertical
                }
            }
        }

    }

    public static void inicialitzaQuartsSEPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "+**"
        int[] center = getCenter(taula); // [vertical, hori]
        inicialitzaQuarts(taula); // fem la forma de creu
        for (int i = 0; i < taula.length; i++) {
            if (i > center[0]) { // si ja hem arribat al centre hortitzontal
                for (int j = 0; j < taula[i].length; j++) {
                    if (j > center[1])
                        taula[i][j] = true; // Si hem passat el centre vertical
                }
            }
        }
    }

    public static void inicialitzaQuartsNOSEPlens(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "*+**"
        inicialitzaQuartsNOPle(taula);
        int[] center = getCenter(taula); // [vertical, hori]
        for (int i = 0; i < taula.length; i++) {
            if (i > center[0]) { // si ja hem arribat al centre hortitzontal
                for (int j = 0; j < taula[i].length; j++) {
                    if (j > center[1])
                        taula[i][j] = true; // Si hem passat el centre vertical
                }
            }
        }

    }

    public static void inicialitzaQuartsSONEPlens(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "**+*"
        inicialitzaQuartsSOPle(taula);
        int[] center = getCenter(taula); // [vertical, hori]
        for (int i = 0; i < taula.length; i++) {
            if (i < center[0]) { // si no hem arribat al centre hortitzontal
                for (int j = 0; j < taula[i].length; j++) {
                    if (j > center[1])
                        taula[i][j] = true; // Si hem passat el centre vertical
                }
            }
        }
    }

    public static void inicialitzaCreuNPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "*x"
        inicialitzaCreu(taula);
        int[] center = getCenter(taula); // [vertical, hori]
        for (int i = 0; i < taula.length; i++) {
            if (i < center[0]) { // si no hem arribat al centre horitzontal
                for (int j = i; j < taula[i].length - 1 - i; j++) {
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaCreuOPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "**x"
        inicialitzaCreu(taula);
        int[] center = getCenter(taula); // [vertical, hori]
        for (int i = 0; i < taula.length; i++) {
            if (i <= center[0]) { // si no hem arribat al centre horitzontal
                for (int j = 0; j < i; j++) {
                    taula[i][j] = true;
                }
            } else {
                for (int j = 0; j < taula[i].length - 1 - i; j++) {
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaCreuSPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "x*"
        inicialitzaCreu(taula);
        int[] center = getCenter(taula); // [vertical, hori]
        for (int i = taula.length - 1; i > 0; i--) {
            if (i > center[0]) { // si ja hem arribat al centre horitzontal
                for (int j = taula[i].length - i; j < taula[i].length - (taula[i].length - i); j++) {
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaCreuEPle(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "x**"
        inicialitzaCreu(taula);
        int[] center = getCenter(taula); // [vertical, hori]
        for (int i = 0; i < taula.length; i++) {
            if (i <= center[0]) { // si no hem arribat al centre horitzontal
                for (int j = taula[i].length - 1; j > taula[i].length - 1 - i; j--) {
                    taula[i][j] = true;
                }
            } else {
                for (int j = taula[i].length - 1; j > taula[i].length - (taula[i].length - i); j--) {
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaCreuNSPlens(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "*x*"
        int[] center = getCenter(taula); // [vertical, hori]
        inicialitzaCreuNPle(taula);
        for (int i = taula.length - 1; i > 0; i--) {
            if (i > center[0]) { // si ja hem arribat al centre horitzontal
                for (int j = taula[i].length - i; j < taula[i].length - (taula[i].length - i); j++) {
                    taula[i][j] = true;
                }
            }
        }
    }

    public static void inicialitzaCreuOEPlens(boolean[][] taula) {
        inicialitzaBuida(taula);
        // Implementa la lògica addicional per a "**x**"
        int[] center = getCenter(taula); // [vertical, hori]
        inicialitzaCreuOPle(taula);
        for (int i = 0; i < taula.length; i++) {
            if (i < center[0]) { // si no hem arribat al centre horitzontal
                for (int j = taula[i].length - 1; j > taula[i].length - 1 - i; j--) {
                    taula[i][j] = true;
                }
            } else {
                for (int j = taula[i].length - 1; j > taula[i].length - (taula[i].length - i); j--) {
                    taula[i][j] = true;
                }
            }
        }
    }

}