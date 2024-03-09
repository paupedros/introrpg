/*
 * Programa que determina la classe Picarol que se'l hi afegeix
 * a GatRenat, amb un comptador dels cops que ha sonat
 */

public class Picarol {
    private int cops = 0;

    public void sona(){
        System.out.println("clink-clink");
        this.cops++;
    }

    public int vegades(){
        return this.cops;
    }
}