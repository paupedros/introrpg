/*
 * En aquest programa a partir d'uns arguments mostrem una taula amb formes dibuixades
 * exemples d'execucio: '5x6\' '0x6\' 4x3 '2x3?'
 * L'especificació de forma consisteix en un text amb un dels següents valors:

    \: primera diagonal
    |: vertical al mig
    -: horitzontal al mig
    +: quarts
    /: segona diagonal
    x: creu
    =: pas de vianants
    ||: zebra
    ++: taulell d'escacs
    '*\: primera diagonal amb primer triangle ple
    \*: primera diagonal amb segon triangle ple
    '*'/ segona diagonal amb primer triangle ple
    /*: segona diagonal amb segon triangle ple
    '*|: vertical al mig amb primer costat ple
    |*: vertical al mig amb segon costat ple
    '*-: horitzontal al mig amb primer costat ple
    -*: horitzontal al mig amb segon costat ple
    '*+: quarts amb quadrant nord-oest ple
    **+: quarts amb quadrant sud-oest ple
    +*: quarts amb quadrant nord-est ple
    +**: quarts amb quadrant sud-est ple
    '*+**: quarts amb quadrant nord-oest i sud-est plens
    **+*: quarts amb quadrant sud-oest i nord-est plens
    '*x: creu amb quadrant nord ple
    **x: creu amb quadrant oest ple
    x*: creu amb quadrant est ple
    x**: creu amb quadrant est ple
    '*x*: creu amb quadrants nord i sud plens
    **x**: creu amb quadrants oest i est plens
 */

public class Formes {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) { // recorrem els arguments
            if(!args[i].contains("x")){
                System.out.println(args[i]);
                System.out.println("Especificació no vàlida");
                continue;
            }
            // Passem per exemple de: 3x4/ a ["3","4", "/"] -> [fila, columna, valor]
            String[] espe = formatEspe(args[i]);
            boolean valida = true;
            for (int j = 0; j < espe.length -1; j++) { // mirem si fila i columna estan buides
                if(espe[j].isEmpty()){ // error espe
                    System.out.println(args[i]);
                    System.out.println("Especificació no vàlida");
                    valida = false;
                    break;
                }
            }
            if(!valida) continue; // si estan buides passem al seguent argument
            boolean hihaValor = false;
            if (espe.length > 2)
                hihaValor = true;
            String valor = "";
            if (espeCorrecte(espe)) { // si l'especificació és correcta
                if (hihaValor) {
                    valor = espe[2]; // obtenim el valor de l'argument
                }
                int fila = Integer.parseInt(espe[0]);
                int columna = Integer.parseInt(espe[1]);
                System.out.println(fila + "x" + columna + valor);
                boolean[][] taula = new boolean[fila][columna];
                for (int k = 0; k < taula.length; k++){
                    for(int j = 0; j < taula[k].length; j++){
                        taula[k][j] = true;
                    }
                }
                switch (valor) {
                    case "\\":
                        UtilTaula.inicialitzaPrimeraDiagonal(taula);
                        break;

                    case "|":
                        UtilTaula.inicialitzaVerticalMig(taula);
                        break;

                    case "-":
                        UtilTaula.inicialitzaHoritzontalMig(taula);
                        break;

                    case "+":
                        UtilTaula.inicialitzaQuarts(taula);
                        break;

                    case "/":
                        UtilTaula.inicialitzaSegonaDiagonal(taula);
                        break;

                    case "x":
                        UtilTaula.inicialitzaCreu(taula);
                        break;

                    case "=":
                        UtilTaula.inicialitzaPasVianants(taula);
                        break;

                    case "||":
                        UtilTaula.inicialitzaZebra(taula);
                        break;

                    case "++":
                        UtilTaula.inicialitzaEscacs(taula);
                        break;

                    case "*\\":
                        UtilTaula.inicialitzaPrimeraDiagonalPrimerPle(taula);
                        break;

                    case "\\*":
                        UtilTaula.inicialitzaPrimeraDiagonalSegonPle(taula);
                        break;

//                    case "*/":
//                       UtilTaula.inicialitzaSegonaDiagonalPrimerPle(taula);
//                        break;
/*
                    case "/*":
                        UtilTaula.inicialitzaSegonaDiagonalSegonPle(taula);
                        break;

                    case "*|":
                        UtilTaula.inicialitzaVerticalMigPrimerPle(taula);
                        break;

                    case "|*":
                        UtilTaula.inicialitzaVerticalMigSegonPle(taula);
                        break;

                    case "*-":
                        UtilTaula.inicialitzaHoritzontalMigPrimerPle(taula);
                        break;

                    case "-*":
                        UtilTaula.inicialitzaHoritzontalMigSegonPle(taula);
                        break;

                    case "*+":
                        UtilTaula.inicialitzaQuartsNOPle(taula);
                        break;

                    case "**+":
                        UtilTaula.inicialitzaQuartsSOPle(taula);
                        break;

                    case "+*":
                        UtilTaula.inicialitzaQuartsNEPle(taula);
                        break;

                    case "+**":
                        UtilTaula.inicialitzaQuartsSEPle(taula);
                        break;

                    case "*+**":
                        UtilTaula.inicialitzaQuartsNOSEPlens(taula);
                        break;

                    case "**+*":
                        UtilTaula.inicialitzaQuartsSONEPlens(taula);
                        break;

                    case "*x":
                        UtilTaula.inicialitzaCreuNPle(taula);
                        break;

                    case "**x":
                        UtilTaula.inicialitzaCreuOPle(taula);
                        break;

                    case "x*":
                        UtilTaula.inicialitzaCreuSPle(taula);
                        break;

                    case "x**":
                        UtilTaula.inicialitzaCreuEPle(taula);
                        break;

                    case "*x*":
                        UtilTaula.inicialitzaCreuNSPlens(taula);
                        break;

                    case "**x**":
                        UtilTaula.inicialitzaCreuOEPlens(taula);
                        break;
*/
                    default:
                        UtilTaula.inicialitzaBuida(taula);
                        break;
                }

                String resultat = UtilTaula.taulaToString(taula, 'X', '·');
                System.out.println(resultat);
            }
            else {
                System.out.println(args[i]);
                System.out.println("Especificació no vàlida");
            }

        }
    }

    public static String[] formatEspe(String especificacio) {
        /*
         * Aquesta funció passem per exemple de: 3x4/ a ["3","4", "/"]
         * si no hi ha valor retornara [fila, columna]
         * sino [fila, columna, valor]
         */
        boolean trobaX = false;
        String[] espe = new String[3]; // [fila, columna, valor]
        for (int i = 0; i < espe.length; i++) {
            espe[i] = "";
        }
        for (int i = 0; i < especificacio.length(); i++) {
            char ch = especificacio.charAt(i);

            if (ch == 'x' && !trobaX) { // si trobem una x i no haviem trobat la de la espe
                trobaX = true;
                continue;
            }
            // si no hem trobat la x i trobem un numero l'afegim a la espe com a fila
            if (Character.isDigit(ch) && !trobaX) {
                espe[0] += ch;
            }
            // si haviem trobat la x i trobem un numero l'afegim a la espe com a columna
            if (Character.isDigit(ch) && trobaX) {
                if(espe[1].length() != 2) { // Si la llargada de la columna encara no es 2 ho afegim al valor
                    espe[1] += ch;
                }
                else{
                    espe[2] += ch;
                }
            }
            if (!Character.isDigit(ch) && trobaX) {
                espe[2] += ch;
            }
        }
        return espe;
    }

    public static boolean espeCorrecte(String[] espe) {

        for (int i = 0; i < espe.length - 1; i++) { // recorrem els elements menys l'ultim
            if (espe[i] == null || espe[i].isEmpty() || !UtilString.esEnter(espe[i])) {
                return false;
            }
            int valor = Integer.parseInt(espe[i]);
            if (valor < 0 || valor > 99)
                return false;
        }

        return true;
    }

}
