/*
 * En aquest programa mostrem per pantalla els nombres que s'identifiquin en els arguments
 * de l'execucio del programa.
 * A de mes mostrem el nombre fet amb 'X' i amb el seu numero, exemple:
 * ····· -> ·····
 * ·XX·· -> ·11··
 * ··X·· -> ··1··
 * ··X·· -> ··1··
 * ··X·· -> ··1··
 * ·XXX· -> ·111·
 * ····· -> ·····
 */

public class DigitArt {
    public static char[][] construeix1() {
        return new char[][] {
                { '·', '·', '·', '·', '·' },
                { '·', 'X', 'X', '·', '·' },
                { '·', '·', 'X', '·', '·' },
                { '·', '·', 'X', '·', '·' },
                { '·', '·', 'X', '·', '·' },
                { '·', 'X', 'X', 'X', '·' },
                { '·', '·', '·', '·', '·' }
        };
    }

    public static char[][] construeix2() {
        return new char[][] {
                { '·', '·', '·', '·', '·', '·' },
                { '·', 'X', 'X', 'X', 'X', '·' },
                { '·', '·', '·', '·', 'X', '·' },
                { '·', 'X', 'X', 'X', 'X', '·' },
                { '·', 'X', '·', '·', '·', '·' },
                { '·', 'X', 'X', 'X', 'X', '·' },
                { '·', '·', '·', '·', '·', '·' },
        };
    }

    public static char[][] construeix3() {
        return new char[][] {
                { '·', '·', '·', '·', '·', '·' },
                { '·', 'X', 'X', 'X', 'X', '·' },
                { '·', '·', '·', '·', 'X', '·' },
                { '·', 'X', 'X', 'X', 'X', '·' },
                { '·', '·', '·', '·', 'X', '·' },
                { '·', 'X', 'X', 'X', 'X', '·' },
                { '·', '·', '·', '·', '·', '·' },
        };
    }

    public static void mostraResultat(char[][] origen, char[][] resultat) {
        
    }

    public static void processaCaracter(char ch) {
        char[][] origen;
        switch (ch) {
            case '1':
                origen = construeix1();
                break;
            case '2':
                origen = construeix2();
                break;
            case '3':
                origen = construeix3();
                break;
            default:
                return; // no conec aquest caràcter
        }
        char[][] desti = UtilTaula.substitueix(origen, 'X', ch);
        mostraResultat(origen, desti);
        System.out.println();
    }

    public static void processaArgument(String arg) {
        /* XXX crida a processaCaracter() per cada caracter de arg */
    }

    public static void main(String[] args) {
        // comprova que com a mínim hi hagi un argument
        /* XXX */
        // processa cada argument
        /* XXX crida a processaArgument() per cada argument */
    }
}