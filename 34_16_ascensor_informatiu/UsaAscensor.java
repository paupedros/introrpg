/*
 * Programa que utilitza la classe Ascensor i va informant
 * sobre el estat del ascensor.
 */

public class UsaAscensor {
    // considera si et cal algun mòdul d'ajut
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        System.out.println("Pis inicial: " + ascensor.getPis());
        System.out.println("Moviment inicial: " + ascensor.getMoviment());
        System.out.println("Introdueix nou pis:");
        // llegir el nou pis de stdin i assignar-lo a l'ascensor
        ascensor.setPis(Integer.parseInt(Entrada.readLine()));
        System.out.println("Introdueix nou moviment:");
        // llegir el nou moviment de stdin i assignar-lo a l'ascensor
        ascensor.setMoviment(Entrada.readLine());

        System.out.println("Pis final: " + ascensor.getPis());
        System.out.println("Moviment final: " + ascensor.getMoviment());
        System.out.println("Estat de l'ascensor: " + ascensor.comEsta());
    }
}