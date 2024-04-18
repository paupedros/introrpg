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
        return origen.toString();
    }

    public String getTipus(){
        return tipus.toString();
    }

    public String getCollita(){
        return collita;
    }
}

