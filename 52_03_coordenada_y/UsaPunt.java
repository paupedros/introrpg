/*
 * Classe per a provar el funcionament de la classe punt per pantalla, imprimeix els getters
 */

public class UsaPunt {
    public static void main(String[] args){
        Punt punt = new Punt();
        System.out.printf("punt.getX() -> %d%n", punt.getX());
        System.out.printf("punt.getY() -> %d%n", punt.getY());
    }
}