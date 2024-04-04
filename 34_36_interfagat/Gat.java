/*
 * Classe de Gat, que determina les propietats i getters/setters dels gats
 */

public class Gat implements EsserViu{
    private int vides = 7;
    private String nom = "anònim";

    public Gat(String nom){
        this.nom = nom;
    }

    Gat(String nom, int vides){
        this.nom = nom;
        this.vides = vides;
    }

    public String getNom(){
        return nom;
    }

    public int getVides(){
        return vides;
    }

    public int setVides(int vides){
        if (vides >= 0){
            this.vides = vides;
        }
        return this.vides;
    }

    @Override
    public boolean esViu(){
        if (vides > 0) return true;
        return false;
    }

    @Override
    public String mor(){
        if(vides - 1 == 0){
            vides--;
            return "ja l'he espifiada";
        }
        vides--;
        return "adéu món cruel";
    }

    @Override
    public String reviu(){
        if(esViu()){
            vides++;
            return "encara miolo";
        }
        vides++;
        return "guai!";
    }    
}