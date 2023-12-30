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
        for (int i = 0; i < origen.length; i++) { // Recorrem les files de la taula
            for (int j = 0; j < origen[i].length; j++) { // Recorrem element per element de la taula
                System.out.print(origen[i][j]);
            }
            System.out.print(" -> ");
            for (int j = 0; j < origen[i].length; j++) { // Recorrem element per element de la taula
                System.out.print(resultat[i][j]);
            }
            System.out.println();
        }
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
        for (int i = 0; i < arg.length(); i++) {
            processaCaracter(arg.charAt(i));
        }
    }

    public static void main(String[] args) {
        // comprova que com a mínim hi hagi un argument
        if(args.length < 1) {
            System.out.println("Introdueix un argument");
            return;
        }
        // processa cada argument
        for (int i = 0; i < args.length; i++) {
            processaArgument(args[i]);
        }
    }
}