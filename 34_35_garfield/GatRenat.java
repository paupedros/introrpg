/*
 * Porgrama que conte els constructors de la classe
 * GatRenat, dins d'aquests tindrem el vincle amb els constructors
 * de la super classe Gat
 */

public class GatRenat extends Gat {
    public GatRenat() {
        this(7, "etirat");
    }

    public GatRenat(int vides) {
        this(vides, "estirat");
    }

    public GatRenat(int vides, String posicio){
        super("Renat", vides, posicio);
    }
    
}