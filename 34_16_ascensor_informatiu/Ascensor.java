/*
 * Declaracio de la classe Ascensor i les seves propietats per a ser utilitzada
 * en UsaAscensor, les propietats son privades
 * Afegim el moviment
 *
 * Creem els setters i getters
 */

public class Ascensor {
    private int pis = -1;
    private String moviment = "aturat";

    public int getPis() {
        return pis;
    }

    public String getMoviment() {
        return moviment;
    }

    public void setPis(int newPis) {
        if (newPis >= -1 && newPis <= 10)
            pis = newPis;
    }

    public void setMoviment(String newMoviment) {
        if (newMoviment.equals("aturat") ||
                newMoviment.equals("pujant") ||
                newMoviment.equals("baixant"))
                moviment = newMoviment;
    }

    public String comEsta(){
        return String.format("%s al pis %d", moviment, pis);
    }

    public boolean esAbaix(){
        return pis == -1;
    }

    public boolean esAdalt(){
        return pis == 10;
    }

    public boolean esAturat(){
        return moviment.equals("aturat");
    }
    public boolean esPujant(){
        return moviment.equals("pujant");
    }
    public boolean esBaixant(){
        return moviment.equals("baixant");
    }

    public boolean esEnMoviment(){
        return moviment.equals("pujant") || moviment.equals("baixant");
    }


}
