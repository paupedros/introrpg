/**
 * Classe del Vi, contindra les diferents propietats, constructors
 * i metodes
 */
public class Vi {
    private int id = -1;
    private String nom = "NOM NO VÀLID!";
    private int preu = -1;
    private int estoc = -1;

    public Vi(int id, String nom, int preu) {
        if (id < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.id = id;
        this.nom = normalitzaNom(nom);
        this.setPreu(preu);
        this.estoc = 0;
    }

    public Vi(int id, String nom, int preu, int estoc) {
        if (id < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.id = id;   
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
        if (preu >= 0)
            this.preu = preu;
    }

    public int getEstoc() {
        return estoc;
    }

    public void setEstoc(int estoc) {
        if (estoc >= 0)
            this.estoc = estoc;
    }

    public static String normalitzaNom(String nom) {
        if (!nom.isBlank()) {
            return nom.trim().replaceAll("\\s+", " ");
        } else
            return "NOM NO VÀLID!";
    }

    public boolean esValid() {
        if (nom.isBlank())
            return false;
        else if (nom.equals("NOM NO VÀLID!"))
            return false;
        else if (preu < 0)
            return false;
        else if (estoc < 0)
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return String.format("%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", nom, preu, estoc);
    }

    public String[] aArrayString() {
        // Obtenim els strings del numeros
        String preu = String.valueOf(this.preu);
        String estoc = String.valueOf(this.estoc);
        // Creem l'array amb les dades del vi
        String[] array = {this.nom, preu, estoc};
        return array;
    }

}