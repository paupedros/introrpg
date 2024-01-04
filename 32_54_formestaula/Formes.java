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
            if(!args[i].contains("x")){
                System.out.println(args[i]);
                System.out.println("Especificació no vàlida");
                continue;
            }
            // Passem per exemple de: 3x4/ a ["3","4", "/"] -> [fila, columna, valor]
            String[] espe = formatEspe(args[i]);
            for (int j = 0; j < espe.length -1; j++) {
                if(espe[j].isEmpty()){ // error espe
                    System.out.println(args[i]);
                    System.out.println("Especificació no vàlida");
                    continue;
                }
            }
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
                System.out.println(fila + "x" + columna);
                boolean[][] taula = new boolean[fila][columna];
                switch (valor) {
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

                    case "/":
                        taula = UtilTaula.inicialitzaSegonaDiagonal(taula);
                        break;

                    case "x":
                        taula = UtilTaula.inicialitzaCreu(taula);
                        break;

                    case "=":
                        taula = UtilTaula.inicialitzaPasVianants(taula);
                        break;

                    case "||":
                        taula = UtilTaula.inicialitzaZebra(taula);
                        break;

                    case "++":
                        taula = UtilTaula.inicialitzaEscacs(taula);
                        break;

                    default:
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
                espe[1] += ch;
            }
            if (!Character.isDigit(ch) && trobaX) {
                espe[2] += ch;
            }
        }
        return espe;
    }

    public static boolean espeCorrecte(String[] espe) {

        for (int i = 0; i < espe.length - 2; i++) { // recorrem els elements menys l'ultim
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
