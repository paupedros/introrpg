/*
 * En aquest programa fem servir el concepte de composicio
 * amb UllDeGat per afegir ulls al gat renat
 */

 public class GatRenat {
    private UllDeGat ullDret = new UllDeGat();
    private UllDeGat ullEsquerre = new UllDeGat();
    private int vides = 7;
    private String posicio = "estirat";
    private Picarol picarol;

    public GatRenat() {
        this(7, "estirat");
    }

    public GatRenat(int vides) {
        this(vides, "estirat");
    }

    public GatRenat(String posicio) {
        this(7, posicio);
    }

    public GatRenat(int vides, String posicio) {
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

    public void setPosicio(String posicio) {
        if (posicio.equals("dret")
                || posicio.equals("estirat")
                || posicio.equals("assegut"))
            this.posicio = posicio;
        else
            this.posicio = "estirat";
    }

    public String aixecat(){
        if (!posicio.equals("dret")){
            setPosicio("dret");
            if (picarol != null) picarol.sona();
            return "ja m'aixeco";
        }
        return "passo de fer res";
    }

    public String seu(){
        if (!posicio.equals("assegut")){
            setPosicio("assegut");
            if (picarol != null) picarol.sona();
            return "ja m'assec";
        }
        return "passo de fer res";
    }

    public String estirat(){
        if (!posicio.equals("estirat")){
            setPosicio("estirat");
            if (picarol != null) picarol.sona();
            return "ja m'estiro";
        }
        return "passo de fer res";
    }

    public UllDeGat getUllDret() {
        boolean obert = false;
        if (getPosicio().equals("dret") || getPosicio().equals("assegut")) obert = true;
        UllDeGat instancia = new UllDeGat(obert);
        return instancia;
    }

    public UllDeGat getUllEsquerre() {
        boolean obert = false;
        if (getPosicio().equals("dret")) obert = true;
        UllDeGat instancia = new UllDeGat(obert);
        return instancia;
    }

    public boolean hiHaPicarol() {
        if (this.picarol == null) return false;
        return true;
    }

    public Picarol agafaPicarol(Picarol picarol) {
        if (picarol == null){
            picarol = new Picarol(); // asigna picarol
            return null; // retorna null
        }
        Picarol p = picarol;
        picarol = new Picarol();
        return p;
    }

    public Picarol deixaPicarol(){
        if (picarol == null) return null;
        Picarol p = picarol;
        picarol = null;
        return p;
    }

    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }

    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        UllDeGat ullDret = renat.getUllDret();
        UllDeGat ullEsquerre = renat.getUllEsquerre();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().esObert(),
                renat.getUllEsquerre().esObert());
        renat.seu();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().esObert(),
                renat.getUllEsquerre().esObert());
        renat.aixecat();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().esObert(),
                renat.getUllEsquerre().esObert());
    }
}
