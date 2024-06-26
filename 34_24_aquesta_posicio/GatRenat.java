/*
 * Nova versio que implementa per a la inicialitzacio de la posicio de GatRenat
 * si el constructor rep una posicio no valida la posicio sera estirat
 */

public class GatRenat {
    private int vides;
    private String posicio;

    public GatRenat(int vides, String posicio) {
        this.setVides(vides);
        this.setPosicio(posicio);
    }

    public int getVides() {
        return this.vides;
    }

    public void setVides(int novesVides) {
        if (novesVides >= 0) {
            this.vides = novesVides;
        }
    }

    public String getPosicio(){
        return this.posicio;
    }

    public void setPosicio(String posicio) {
        if (posicio.equals("dret")
                || posicio.equals("estirat")
                || posicio.equals("assegut"))
            this.posicio = posicio;
        else this.posicio = "estirat";
    }

    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }

    public static void main(String[] args) {
        System.out.println(new GatRenat(7, "dret"));
    }
}