/*
 * En aquest programa fem servir el overload amb els constructors,
 * tenim un general i d'aquest en els altres el cridem amb this()
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";

    public GatRenat() {
        this(7,"estirat");
    }

    public GatRenat(int vides) {
        this(vides, "estirat");
    }

    public GatRenat(String posicio){
        this(7,posicio);
    }

    public GatRenat(int vides, String posicio){
        this.setVides(vides);
        this.setPosicio(posicio);
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

    public void setPosicio(String pos) {
        if (pos.equals("dret")
                || pos.equals("estirat")
                || pos.equals("assegut"))
            this.posicio = pos;
        else this.posicio = "estirat";
    }

    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }

    public static void main(String[] args) {
        GatRenat[] renats = {
                new GatRenat(), // tot per defecte
                new GatRenat(8), // 8 vides i posició per defecte
                new GatRenat("dret"), // posició dret i vides per defecte
                new GatRenat(8, "dret") // 8 vides i posició dret

        };
        for (GatRenat renat : renats) {
            System.out.println(renat);
        }
    }
}
