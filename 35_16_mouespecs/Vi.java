/**
 * Classe del Vi, contindra les diferents propietats, constructors
 * i metodes
 */
public class Vi {
    private String ref = null;
    private int preu = -1;
    private int estoc = -1;
    private String lloc = null;
    private Especificacio espec = null;

    public Vi(String ref, int preu, int estoc,
            String lloc, Especificacio espec) {
        if (!esValid(ref, preu, estoc, lloc, espec)) {
            throw new IllegalArgumentException();
        }
        this.ref = UtilString.normalitzaString(ref);
        this.setPreu(preu);
        this.setEstoc(estoc);
        this.setLloc(lloc);
        this.espec = espec;
    }

    public String getRef() {
        return ref;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        if (preu >= 0)
            this.preu = preu;
        else
            throw new IllegalArgumentException();
    }

    public int getEstoc() {
        return estoc;
    }

    public void setEstoc(int estoc) {
        if (estoc >= 0)
            this.estoc = estoc;
        else
            throw new IllegalArgumentException();
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        // Si el lloc es null o esta vuit no fem res
        if (lloc == null || lloc.isBlank())
            throw new IllegalArgumentException();
        this.lloc = UtilString.normalitzaString(lloc);
    }

    public Especificacio getEspec() {
        return espec;
    }

    public static boolean esValid(String ref, int preu, int estoc, String lloc, Especificacio espec) {
        if (ref == null || ref.isBlank()) {
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
        if (!espec.esComplet())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "%n    Ref: %s%n    Preu: %d%n    Estoc: %d%n    Lloc: %s%n    %s",
                ref, preu, estoc, lloc, espec);
    }

    public String[] aArrayString() {
        // Obtenim els strings del numeros
        String preu = String.valueOf(this.preu);
        String estoc = String.valueOf(this.estoc);
        // Obtenim l'array de la especifiacio
        String[] espe = espec.aArrayString();
        // Creem l'array amb les dades del vi
        String[] array = { this.ref, espe[0], preu, estoc, this.lloc, espe[1], espe[2], espe[3] };
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
            String[] espe = {nom, array[5], array[6], array[7]};
            Especificacio espec = Especificacio.deArrayString(espe);
            if (!esValid(ref, preu, estoc, lloc, espec)) {
                return null;
            }
            Vi vi = new Vi(ref, preu, estoc, lloc, espec);
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