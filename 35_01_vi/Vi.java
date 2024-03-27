/**
 * Classe del Vi, contindra les diferents propietats, constructors
 * i metodes
 */
public class Vi {
    private String nom;
    private int preu;
    private int estoc;

    public Vi(String nom, int preu) {
        this.nom = normalitzaNom(nom);
        this.preu = preu;
    }

    public Vi(String nom, int preu, int estoc) {
        this.nom = normalitzaNom(nom);
        this.preu = preu;
        this.estoc = estoc;
    }


    public static String normalitzaNom(String nom){
        if (esValid(nom)){
            return nom.strip().replaceAll("\\s+"," ");
        }
        return "NOM NO VÀLID!";
    }

    public boolean esValid() {
        if (nom.isBlank()) return false;
    }

    @Override
    public String toString() {
        return String.format("%nVi: %s%nPreu: %d%nEstoc: %d", nom, preu, estoc);
    }
    
}