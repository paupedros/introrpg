/*
 * Programa que englobara la classe global Gat d'on dependran
 * tots els nostres gats del programa, aquests gat tindran nom
 */

public class Gat {
    private String nom;
    private int vides = 7;
    private String posicio = "estirat";

    public Gat(String nom) {
        this(nom, 7, "estirat");
    }

    public Gat(String nom, int vides) {
        this(nom, vides, "estirat");

    }

    public Gat(String nom, String posicio) {
        this(nom, 7, posicio);
    }

    public Gat(String nom, int vides, String posicio) {
        this.nom = strictNom(nom);
        this.vides = vides;
        this.posicio = posicio;
    }

    private String strictNom(String nom){
        if (nom == null || nom.isBlank()) return "anònim";
        return nom;
    }

    public String getNom() {
        return nom;
    }

    public int getVides() {
        return vides;
    }

    public String getPosicio() {
        return posicio;
    }

    public void setVides(int novesVides) {
        if (novesVides >= 0) {
            vides = novesVides;
        }
    }

    public void setPosicio(String posicio) {
        if (posicio.equals("dret")
                || posicio.equals("estirat")
                || posicio.equals("assegut"))
            this.posicio = posicio;
        else
            this.posicio = "estirat";
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

    public boolean esViu() {
        return getVides() > 0;
    }

    public boolean esDret() {
        return getPosicio().equals("dret");
    }

    public boolean esAssegut() {
        return getPosicio().equals("assegut");
    }

    public boolean esEstirat() {
        return getPosicio().equals("estirat");
    }

}