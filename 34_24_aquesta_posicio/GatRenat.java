/*
 * Nova versio que implementa per a la inicialitzacio de la posicio de GatRenat
 * si el constructor rep una posicio no valida la posicio sera estirat
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";

    public GatRenat(int vides, String posicio) {
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

    public String getPosicio(){
        return posicio;
    }

    public void setPosicio(String pos) {
        if (pos.equals("dret")
                || pos.equals("estirat")
                || pos.equals("assegut"))
            posicio = pos;
    }

    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }

    public static void main(String[] args) {
        System.out.println(new GatRenat(7, "dret"));
    }
}