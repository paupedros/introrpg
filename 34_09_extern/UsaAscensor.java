/*
 * Programa que utilitza la classe Ascensor i ens indica en quin
 * pis esta l'ascensor creat des de fora
 */
public class UsaAscensor {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        System.out.println("L'ascensor creat des de fora està al pis " + ascensor.pis);
    }
}
