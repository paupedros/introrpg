/*
 * Programa que representa un estat d'un joc del tres en ratlla utilitzant array d'arrays
 * (un taulell),
 * es demana per a fer un moviment
 * 
 * ·OO
 * ·X·
 * ··X
 * 
 */

public class TresEnRatlla {
    public static void main(String[] args){

        // declaració del taulell
        char[][] taulell = new char[3][3];

        // inicialització de la fila 0
        taulell[0][0] = '·';
        taulell[0][1] = 'O';
        taulell[0][2] = 'O';

        // inicialització de la fila 1
        taulell[1][0] = '·';
        taulell[1][1] = 'X';
        taulell[1][2] = '·';

        // inicialització de la fila 2
        taulell[2][0] = '·';
        taulell[2][1] = 'X';
        taulell[2][2] = 'X';

        // mostra la posició inicial del taulell
        System.out.println("La posició inicial del taulell:");
        mostraFila(taulell[0]);     // mostra la fila 0
        mostraFila(taulell[1]);     // mostra la fila 1
        mostraFila(taulell[2]);     // mostra la fila 2

        // demana coordenades del moviment del jugador X
        System.out.println("Fila del següent moviment?");
        int fila = Integer.parseInt(Entrada.readLine());
        System.out.println("Columna del següent moviment?");
        int columna = Integer.parseInt(Entrada.readLine());

        // marquem el nou moviment
        taulell[fila][columna] = 'X';

        // tornem a mostrar el taulell
        System.out.println("La posició final del taulell:");
        mostraFila(taulell[0]);     // mostra la fila 0
        mostraFila(taulell[1]);     // mostra la fila 1
        mostraFila(taulell[2]);     // mostra la fila 2

    }

    public static void mostraFila(char[] fila) {
        for (int col = 0; col < fila.length; col++) {
            System.out.print(fila[col]);
        }
        System.out.println();
    }

}
