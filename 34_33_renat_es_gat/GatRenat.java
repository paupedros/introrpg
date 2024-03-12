/*
 * En aquest programa farem que GatRenat sigui subclasse de Gat,
 * passant els getters i setters cap a la superclasse Gat, junt
 * amb les propietats vides i posicio
 */

public class GatRenat extends Gat {

    public GatRenat() {
        super(7, "estirat");
    }

    public GatRenat(int vides) {
        super(vides, "estirat");
    }

    public GatRenat(String posicio) {
        super(7, posicio);
    }

    public GatRenat(int vides, String posicio) {
        super(vides, posicio);
    }

    public String aixecat() {
        if (!getPosicio().equals("dret")) {
            setPosicio("dret");
            return "ja m'aixeco";
        }
        return "passo de fer res";
    }

    public String seu() {
        if (!getPosicio().equals("assegut")) {
            setPosicio("assegut");
            return "ja m'assec";
        }
        return "passo de fer res";
    }

    public String estirat() {
        if (!getPosicio().equals("estirat")) {
            setPosicio("estirat");
            return "ja m'estiro";
        }
        return "passo de fer res";
    }

    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", getVides(), getPosicio());
    }
}
