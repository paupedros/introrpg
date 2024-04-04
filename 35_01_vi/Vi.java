/**
 * Classe del Vi, contindra les diferents propietats, constructors
 * i metodes
 */
public class Vi {
    private String nom = "NOM NO VÀLID!";
    private int preu = -1;
    private int estoc = -1;

    public Vi(String nom, int preu) {
        this.nom = normalitzaNom(nom);
        this.setPreu(preu);
        this.estoc = 0;
    }

    public Vi(String nom, int preu, int estoc) {
        this.nom = normalitzaNom(nom);
        this.setPreu(preu);
        this.setEstoc(estoc);
    }

    public String getNom() {
        return nom;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        if (preu >= 0) this.preu = preu;
    }

    public int getEstoc() {
        return estoc;
    }

    public void setEstoc(int estoc) {
        if (estoc >= 0) this.estoc = estoc;
    }

    public static String normalitzaNom(String nom){
        if (!nom.isBlank()){
            return nom.strip().replaceAll("\\s+"," ");
        }
        return "NOM NO VÀLID!";
    }

    public boolean esValid() {
        if (nom.isBlank()) return false;
        if (preu < 0) return false;
        if (estoc < 0) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%n    Vi: %s%n    Preu: %d%n    Estoc: %d", nom, preu, estoc);
    }
    
}