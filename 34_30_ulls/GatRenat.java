/*
 * En aquest programa fem servir el concepte de composicio
 * amb UllDeGat per afegir ulls al gat renat
 */

public class GatRenat {
    private UllDeGat ullDret = new UllDeGat();
    private UllDeGat ullEsquerre = new UllDeGat();
    private int vides = 7;
    private String posicio = "estirat";

    public GatRenat() {
        this(7, "estirat");
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

    public void seu(){
        this.posicio = "assegut";
        ullDret.obret(); // true
        ullEsquerre.tancat(); // false
    }
    public void aixecat(){
        this.posicio = "dret";
        ullEsquerre.obret(); // true
        ullDret.obret(); // true
    }
    public void estirat(){
        this.posicio = "estirat";
        ullEsquerre.tancat(); // false
        ullDret.tancat(); // false
    }

    public UllDeGat getUllDret(){
        UllDeGat instancia = new UllDeGat(ullDret.esObert());
        return instancia;
    }
    public UllDeGat getUllEsquerre(){
        UllDeGat instancia = new UllDeGat(ullEsquerre.esObert());
        return instancia;
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
