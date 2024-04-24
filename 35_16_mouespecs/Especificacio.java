/* 
 * Classe que farem servir per crear la especificacio d'un vi, no sera un vi complet
 * nomes tindra algunes propietats
 */

public class Especificacio {
    private String nom;
    private Origen origen;
    private Tipus tipus;
    private String collita;

    Especificacio (String nom, Origen origen, Tipus tipus, String collita){
        this.nom = nom;
        this.origen = origen;
        this.tipus = tipus;
        this.collita = collita;
    }

    public String getNom(){
        return nom;
    }

    public String getOrigen(){
        if (origen == null) return null;
        return origen.toString();
    }

    public String getTipus(){
        if (tipus == null) return null;
        return tipus.toString();
    }

    public String getCollita(){
        return collita;
    }

    public boolean esComplet() {
        if (nom != null)
            if (origen != null)
                if (tipus != null)
                    if (collita != null)
                        return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("Nom: %s%n    D.O.: %s%n    Tipus: %s%n    Collita: %s%n", nom, origen, tipus, collita);
    }

    public String[] aArrayString() {
        String[] array = {nom, origen.toString(), tipus.toString(), collita};
        return array;
    }

    public static Especificacio deArrayString(String[] array) {
        return new Especificacio(array[0], Origen.fromString(array[1]), Tipus.fromString(array[2]), array[3]);
    }

    public boolean esPlantillaDe(Vi plantilla) {
        if (Vi.esValid(plantilla.getRef(), plantilla.getPreu(), plantilla.getEstoc(), plantilla.getLloc(), plantilla.getEspec()))
            return true;
        return false;
    }
}

