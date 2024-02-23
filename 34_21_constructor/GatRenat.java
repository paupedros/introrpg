/*
 * En aquest programa reutilitzem la classe GatRenat,
 * pero en aquest cas utilitzem un constructor per
 * asignar els valors per defecte de les propietats.
 */

public class GatRenat {
    private int vides;
    private String posicio;
    public GatRenat() {
        vides = 7;
        posicio = "estirat";
    }
    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }
    public int getVides() { return vides; }
    public String getPosicio() { return posicio; }

    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        System.out.println(renat);
    }
}