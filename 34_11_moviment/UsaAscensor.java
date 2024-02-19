/*
 * Programa que utilitza la classe Ascensor i ens indica en quin
 * pis esta l'ascensor creat des de fora
 */
public class UsaAscensor {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        System.out.println("Pis inicial: " + ascensor.pis);
        System.out.println("Moviment inicial: " + ascensor.moviment);
        ascensor.moviment = "pujant";
        System.out.println("Moviment final: " + ascensor.moviment);
    }
}
