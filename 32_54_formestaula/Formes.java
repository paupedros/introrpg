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
 */

public class Formes {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) { // recorrem els arguments
            // Passem per exemple de: 3x4/ a ["3","4", "/"] -> [fila, columna, valor]
            String[] espe = formatEspe(args[i]);
            boolean hihaValor = false;
            if (espe.length > 2)
                hihaValor = true;
            String valor = "No hi ha valor";
            if (espeCorrecte(espe)) { // si l'especificació és correcta
                if (hihaValor) {
                    valor = espe[2]; // obtenim el valor de l'argument
                }
                int fila = Integer.parseInt(espe[0]);
                int columna = Integer.parseInt(espe[1]);
                System.out.println(fila + "x" + columna);
                boolean[][] taula = new boolean[fila][columna];
                switch(valor) {
                    case "\\":
                        taula = UtilTaula.inicialitzaPrimeraDiagonal(taula);
                        break;

                    case "|":
                        taula = UtilTaula.inicialitzaVerticalMig(taula);
                        break;

                    case "-":
                        taula = UtilTaula.inicialitzaHoritzontalMig(taula);
                        break;

                    case "+":
                        taula = UtilTaula.inicialitzaQuarts(taula);
                        break;
/*
                    case "/":
                        taula = UtilTaula.inicialitzaSegonaDiagonal(taula);
                        break;

                    case "x":
                        taula = UtilTaula.inicialitzaCreu(taula);
                        break;

                    case "=" :
                        taula = UtilTaula.inicialitzaPasDeVianants(taula);
                        break;

                    case "||" :
                        taula = UtilTaula.inicialitzaZebra(taula);
                        break;

                    case "++" :
                        taula = UtilTaula.inicialitzaEscacs(taula);
                        break;
                    */
                    default:
                        break;
                }


                String resultat = UtilTaula.taulaToString(taula, 'X', '·');
                System.out.println(resultat);
            }

        }
    }

    public static String[] formatEspe(String especificacio) {
        /*
         * Aquesta funció passem per exemple de: 3x4/ a ["3","4", "/"]
         * si no hi ha valor retornara [fila, columna]
         * sino [filla, columna, valor]
         */
        if (especificacio.length() > 3) {
            String espe = especificacio.substring(0, 3); // espe = "3x4"
            String valor = especificacio.substring(3, especificacio.length()); // valor = "/";
            String[] espeNums = espe.split("x"); // espeNums = ["3","4"]
            String espeFinal[] = new String[3];
            espeFinal[0] = espeNums[0];
            espeFinal[1] = espeNums[1];
            espeFinal[2] = valor;
            return espeFinal; // [fila, columna, valor]
        }
        String[] espe = especificacio.split("x");
        return espe; // [fila, columna]
    }

    public static boolean espeCorrecte(String[] espe) {
        if (espe.length > 2) {
            for (int i = 0; i < espe.length - 1; i++) { // recorrem els elements menys l'ultim
                if (!UtilString.esEnter(espe[i]))
                    return false;
                int valor = Integer.parseInt(espe[i]);
                if (valor < 0 || valor > 99)
                    return false;
            }
        } else {
            for (int i = 0; i < espe.length; i++) {
                if (!UtilString.esEnter(espe[i]))
                    return false;
                int valor = Integer.parseInt(espe[i]);
                if (valor < 0 || valor > 99)
                    return false;
            }
        }
        return true;
    }

}
