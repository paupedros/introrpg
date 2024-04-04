
public class GatRenat extends Gat implements AnimalDeCompanyia, Ensinistrable {
    private String posicio = "estirat";

    GatRenat() {
        super("Renat");
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

    @Override
    public boolean esDret() {
        return getPosicio().equals("dret");
    }

    @Override
    public boolean esAssegut() {
        return getPosicio().equals("assegut");
    }

    @Override
    public boolean esEstirat() {
        return getPosicio().equals("estirat");
    }

    @Override
    public String aixecat() {
        if (!getPosicio().equals("dret")) {
            setPosicio("dret");
            return "ja m'aixeco";
        }
        return "passo de fer res";
    }

    @Override
    public String seu() {
        if (!getPosicio().equals("assegut")) {
            setPosicio("assegut");
            return "ja m'assec";
        }
        return "passo de fer res";
    }

    @Override
    public String estirat() {
        if (!getPosicio().equals("estirat")) {
            setPosicio("estirat");
            return "ja m'estiro";
        }
        return "passo de fer res";
    }

    @Override
    public String deixatEstimar() {
        return "em deixo estimar";
    }
}
