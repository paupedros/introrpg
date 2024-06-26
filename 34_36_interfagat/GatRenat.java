/*
 * Implementacio de la classe GatRenat que es un gat i implementa les caracteristiques
 * dels animals de companyia i els ensinistrables
 */

public class GatRenat extends Gat implements AnimalDeCompanyia, Ensinistrable {
    private String posicio = "estirat";

    GatRenat() {
        super("Renat");
    }
    GatRenat(String posicio){
        super("Renat");
        if (posicio.equals("dret")
                || posicio.equals("estirat")
                || posicio.equals("assegut"))
            this.posicio = posicio;
        else
            this.posicio = "estirat";
    }

    public String getPosicio() {
        return posicio;
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
            posicio = "dret";
            return "ja m'aixeco";
        }
        return "passo de fer res";
    }

    @Override
    public String seu() {
        if (!getPosicio().equals("assegut")) {
            posicio = "assegut";
            return "ja m'assec";
        }
        return "passo de fer res";
    }

    @Override
    public String estirat() {
        if (!getPosicio().equals("estirat")) {
            posicio = "estirat";
            return "ja m'estiro";
        }
        return "passo de fer res";
    }

    @Override
    public String deixatEstimar() {
        return "em deixo estimar";
    }
}
