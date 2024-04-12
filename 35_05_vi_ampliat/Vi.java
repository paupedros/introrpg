/**
 * Classe del Vi, contindra les diferents propietats, constructors
 * i metodes
 */
public class Vi {
    private String ref = null;
    private String nom = null;
    private int preu = -1;
    private int estoc = -1;
    private String lloc = null;
    private String origen = null;
    private String tipus = null;
    private String collita = null;

    public Vi(String ref, String nom,
            int preu, int estoc,
            String lloc, String origen,
            String tipus, String collita) {
        this.ref = normalitzaString(ref);
        this.nom = normalitzaString(nom);
        this.setPreu(preu);
        this.setEstoc(estoc);
        this.setLloc(lloc);
        this.origen = normalitzaString(origen);
        this.tipus = normalitzaString(tipus);
        this.collita = normalitzaString(collita);
    }

    public String getRef() {
        return ref;
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

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        if (lloc != null || lloc.isBlank()) {
            lloc = normalitzaString(lloc);
            return;
        }
        this.lloc = lloc;
    }

    public String getOrigen() {
        return origen;
    }

    public String getTipus() {
        return tipus;
    }

    public String getCollita() {
        return collita;
    }

    public static String normalitzaString(String text) {
        if (text == null || text.isEmpty())
            return null;
        if (!text.isBlank()) {
            return text.trim().replaceAll("\\s+", " ");
        }
        return null;
    }

    public boolean esValid() {
        if (ref == null || ref.isBlank())
            return false;
        else if (nom == null || nom.isBlank())
            return false;
        else if (preu < 0)
            return false;
        else if (estoc < 0)
            return false;
        else if (lloc == null || lloc.isBlank())
            return false;
        else if (origen == null || origen.isBlank())
            return false;
        else if (tipus == null || tipus.isBlank())
            return false;
        else if (collita == null || collita.isBlank())
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return String.format(
                "%n    Ref: %s%n    Nom: %s%n    Preu: %d%n    Estoc: %d%n    Lloc: %s%n    D.O.: %s%n    Tipus: %s%n    Collita: %s%n",
                ref, nom, preu, estoc, lloc, origen, tipus, collita);
    }

    public String[] aArrayString() {
        // Obtenim els strings del numeros
        String preu = String.valueOf(this.preu);
        String estoc = String.valueOf(this.estoc);
        // Creem l'array amb les dades del vi
        String[] array = { this.ref, this.nom, preu, estoc, this.lloc, this.origen, this.tipus, this.collita };
        return array;
    }

    public static Vi deArrayString(String[] array) {
        // Si l'array es valid per a ser un vi, creem una instancia i si es valida la
        // retornem
        if (arrayValid(array)) {
            String ref = array[0];
            String nom = array[1];
            int preu = Integer.parseInt(array[2]);
            int estoc = Integer.parseInt(array[3]);
            String lloc = array[4];
            String origen = array[5];
            String tipus = array[6];
            String collita = array[7];
            Vi vi = new Vi(ref, nom, preu, estoc, lloc, origen, tipus, collita);
            if (vi.esValid())
                return vi;
        }
        // Si no es valid retornem null
        return null;
    }

    public static boolean arrayValid(String[] array) {
        // Condicions per saber si un array no es valid per construir un vi:
        /**
         * Llargada diferent a 8
         * El preu i el estoc no son enters
         */

        if (array.length != 8) {
            return false;
        }
        if (!UtilString.esEnter(array[2]) || !UtilString.esEnter(array[3])) {
            return false;
        }
        return true;
    }

}