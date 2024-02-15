/*
 * Programa que ens indica el pis en el que es troba l'ascensor. POO
 * Amb el nou procediment que puja pis incrementem la propietat pis
 * de la classe Ascensor.
 */

 public class Ascensor {
    int pis = -1;
    public static void puja(Ascensor ascensor) {
        ascensor.pis = ascensor.pis + 1;
    }
    public static void main(String[] args){
        Ascensor ascensor = new Ascensor();
        System.out.println("L'ascensor inicialment està a la planta " + ascensor.pis);
        puja(ascensor);
        System.out.println("L'ascensor finalment està a la planta " + ascensor.pis);
    }
}