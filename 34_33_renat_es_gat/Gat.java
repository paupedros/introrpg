/*
 * En aquest programa farem tota l'estructura de la super classe
 * Gat, que contindra els getters i setters, tant com les propietats
 * vides i posicio
 */

public class Gat {
    private int vides = 7;
    private String posicio = "estirat";

    public Gat(int vides, String posicio) {
        setVides(vides);
        setPosicio(posicio);
    }

    public int getVides() {
        return vides;
    }

    public void setVides(int novesVides) {
        if (novesVides >= 0) {
            vides = novesVides;
        }
    }

    public String getPosicio() {
        return posicio;
    }

    public void setPosicio(String posicio) {
        if (posicio.equals("dret")
                || posicio.equals("estirat")
                || posicio.equals("assegut"))
            this.posicio = posicio;
        else
            this.posicio = "estirat";
    }
}