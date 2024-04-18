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
    private Origen origen = null;
    private Tipus tipus = null;
    private String collita = null;

    public Vi(String ref, String nom,
            int preu, int estoc,
            String lloc, Origen origen,
            Tipus tipus, String collita) {
        if (!esValid(ref, nom, preu, estoc, lloc, origen, tipus, collita)){
            throw new IllegalArgumentException();
        }
        this.ref = UtilString.normalitzaString(ref);
        this.nom = UtilString.normalitzaString(nom);
        this.setPreu(preu);
        this.setEstoc(estoc);
        this.setLloc(lloc);
        this.origen = origen;
        this.tipus = tipus;
        this.collita = UtilString.normalitzaString(collita);
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
        // Si el lloc es null o esta vuit no fem res
        if (lloc == null || lloc.isBlank())
            return;
        this.lloc = UtilString.normalitzaString(lloc);
    }

    public String getOrigen() {
        if (origen == null)
            return null;
        return origen.toString();
    }

    public String getTipus() {
        if (tipus == null)
            return null;
        return tipus.toString();
    }

    public String getCollita() {
        return collita;
    }

    public static boolean esValid(String ref, String nom, int preu, int estoc, String lloc, Origen origen, Tipus tipus, String collita) {
        if (ref == null || ref.isBlank()) {
            return false;
        }
        if (nom == null || nom.isBlank()) {
            return false;
        }
        if (preu < 0) {
            return false;
        }
        if (estoc < 0) {
            return false;
        }
        if (lloc == null || lloc.isBlank()) {
            return false;
        }
        if (origen == null || origen.toString().isBlank()) {
            return false;
        }
        if (tipus == null || tipus.toString().isBlank()) {
            return false;
        }
        if (collita == null || collita.isBlank()) {
            return false;
        }
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
        String[] array = { this.ref, this.nom, preu, estoc, this.lloc, this.origen.toString(), this.tipus.toString(),
                this.collita };
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
            Origen origen = Origen.fromString(array[5]);
            Tipus tipus = Tipus.fromString(array[6]);
            String collita = array[7];
            if (!esValid(ref, nom, preu, estoc, lloc, origen, tipus, collita)){
                throw new IllegalArgumentException();
            }
            Vi vi = new Vi(ref, nom, preu, estoc, lloc, origen, tipus, collita);
            return vi;
        }
        // Si no es valid retornem null
        return null;
    }

    private static boolean arrayValid(String[] array) {
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