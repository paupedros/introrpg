/*
 * Programa que ens indica el pis en el que es troba l'ascensor. POO
 */

public class Ascensor {
    int pis = -1;

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();

        System.out.printf("L'ascensor està a la planta %d%n", ascensor.pis);
    }

}