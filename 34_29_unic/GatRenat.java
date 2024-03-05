
/*
 * Programa que implementa una versio de la classe gatrenat
 * on nomes pot haver-hi una instancia
 */
public class GatRenat {
    private static GatRenat instancia;
    private int vides = 7;
    private String posicio = "estirat";

    private GatRenat(int vides, String posicio){
        this.setVides(vides);
        this.setPosicio(posicio);
    }

    public static GatRenat getInstancia(){
        if (instancia == null){
            instancia = new GatRenat(7, "estirat");
        }
        return instancia;
    }
    public static GatRenat getInstancia(int vides){
        if (instancia == null){
            instancia = new GatRenat(vides, "estirat");
        }
        return instancia;
    }
    public static GatRenat getInstancia(String posicio){
        if (instancia == null){
            instancia = new GatRenat(7, posicio);
        }
        return instancia;
    }
    public static GatRenat getInstancia(int vides, String posicio){
        if (instancia == null){
            instancia = new GatRenat(vides, posicio);
        }
        return instancia;
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
        else this.posicio = "estirat";
    }

    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }
}