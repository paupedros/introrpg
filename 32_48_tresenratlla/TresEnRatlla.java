/*
 * Implementacio del tres en ratlla que es pot jugar
 */

public class TresEnRatlla {

    public static void main(String[] args) {

        // declara i inicialitza el taulell
        char[][] taulell = new char[3][3];
        taulell[0][0] = '·';
        taulell[0][1]='·';taulell[0][2]='·';taulell[1][0]='·';taulell[1][1]='·';taulell[1][2]='·';taulell[2][0]='·';taulell[2][1]='·';taulell[2][2]='·';

        System.out.println("Comença el joc");

        // indica quin és el jugador que té el torn
        char jugador = 'X'; // Comenca sempre el jugador X

        while (true) {

            mostraTaulell(taulell);

            // obté el moviment del jugador actual
            System.out.println(jugador + "?");
            String resposta = Entrada.readLine();
            resposta = resposta.toLowerCase();

            // comprova abandonament
            // Si la resposta es igual a 'a' vol dir que el jugador abandona
            if (resposta.equals("a")) {
                System.out.println(jugador + " abandona");
                return;
            }
            boolean valid = false;
            // Mentre la resposta no es valida
            while (!valid) {
                valid = true; // suposem que de moment es valida
                for (int i = 0; i < resposta.length(); i++) {
                    char ch = resposta.charAt(i);
                    int chNum = Character.getNumericValue(ch);

                    // si el caracter no es un nombre o, si el 
                    // caracter es mes petit que 0 o mes gran que 2,
                    // llavors la resposta no es valida
                    if (!Character.isDigit(ch) || (chNum < 0 || chNum > 2)) { 
                        valid = false;
                        break;
                    }
                }
                // Si no es valida donem error i demanem la resposta un altre cop
                if (!valid || resposta.length() != 2) {
                    System.out.println("Error");
                    resposta = Entrada.readLine();
                    resposta = resposta.toLowerCase();
                    continue;
                }

            }
            // La resposta es valida           

            // obté coordenades del moviment
            int fila = Character.getNumericValue(resposta.charAt(0));
            int columna = Character.getNumericValue(resposta.charAt(1));

            //System.out.println(jugador + " ha movimentat la casella " + fila + columna);
            // comprova si la casella està ocupada
            if (casellaOcupada(taulell, fila, columna)){
                System.out.println("Ocupada");
                continue;
            }
            
            // realitza el moviment
            taulell[fila][columna] = jugador;
            
            // comprova jugador guanya
            if(jugadorGuanya(taulell, jugador)){
                mostraTaulell(taulell);
                System.out.println(jugador + " guanya");
                return; 
            }

            // comprova empat
            if(hiHaEmpat(taulell)){ 
                mostraTaulell(taulell);
                System.out.println("Empat");
                return;
            }

            // passa torn a l'altre jugador
            if (jugador == 'X') {
                    jugador = 'O';
            } else {
                    jugador = 'X';
            }

        }
    }

    

    // moduls de suport

    public static void mostraTaulell(char[][] taulell) {
        for (int fila = 0; fila < taulell.length; fila++){
            mostraFila(taulell[fila]);
        }
    }
    public static void mostraFila(char[] fila) {
        for (int col = 0; col < fila.length; col++) {
            System.out.print(fila[col]);
        }
        System.out.println();
    }
    
    public static boolean casellaOcupada(char[][] taulell, int fila, int columna){
        if(taulell[fila][columna] != '·') return true;
        return false;
    }

    public static boolean jugadorGuanya(char[][] taulell, char jugador){
        for (int fila = 0; fila < taulell.length; fila++){
            // Comprovacio horitzonal
            if(taulell[fila][0] == jugador && taulell[fila][1] == jugador && taulell[fila][2] == jugador) return true;
        }
        for (int columna = 0; columna < taulell[0].length; columna++){
            // Comprovacio vertical
            if(taulell[0][columna] == jugador && taulell[1][columna] == jugador && taulell[2][columna] == jugador) return true;
        }
        // Si la primer casella de la primera fila 
        // i la ultima de la tercera i la del mig son el jugador, 
        // llavors ha guanyat
        
        if(taulell[0][0] == jugador && taulell[2][2] == jugador && taulell[1][1] == jugador) return true;
        if(taulell[0][2] == jugador && taulell[2][0] == jugador && taulell[1][1] == jugador) return true;
        return false;
    }

    public static boolean hiHaEmpat(char[][] taulell){
        for (int fila = 0; fila < taulell.length; fila++){
            for (int columna = 0; columna < taulell[0].length; columna++){
                if(taulell[fila][columna] == '·') return false;
            }
        }
        return true;
    }
}