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
        String preu = String.valueOf(this.preu);
        String estoc = String.valueOf(this.estoc);
        String[] array = {this.nom, preu, estoc};
        return array;
    }

    public static Vi deArrayString(String[] array) {
        if (array.length != 3) return null;
        if (UtilString.esEnter(array[1]) && UtilString.esEnter(array[2])) {
            Vi vi = new Vi(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]));
            if (vi.esValid()) return vi;
            return null;
        }
        return null;
    }

}