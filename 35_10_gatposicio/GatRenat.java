/*
 * Classe de GatRenat amb la posicio a partir de enum amb la classe GatPosicio
 */

public class GatRenat {
    private GatPosicio posicio = GatPosicio.ESTIRAT;

    public GatRenat(GatPosicio posicio) {
        this.posicio = posicio;
    }

    public GatRenat(String posicio) {
        this.posicio = GatPosicio.fromString(posicio);
    }

    public GatPosicio getPosicio() {
        return posicio;
    }

    public void setPosicio(GatPosicio posicio) {
        this.posicio = posicio;
    }

    public void setPosicio(String posicio) {
        this.posicio = GatPosicio.fromString(posicio);
    }
}
