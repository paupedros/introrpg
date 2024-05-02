/*
 * Classe Client: representa un client del sistema de gestió de vehicles. Té un identificador
 * (nif), un nom, un telèfon i una llista de lloguers (Lloguer) que ha fet en el sistema.
 * A més a més té els metodes per obtenir i modificar aquests camps.
 * Té un metode que ens permet generar un informe de tots els lloguers fets pel client.
 */

import java.util.ArrayList;
public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private ArrayList<Lloguer> lloguers;
    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new ArrayList<Lloguer>();
    }

    public String getNif()     { return nif; }
    public String getNom()     { return nom; }
    public String getTelefon() { return telefon; }
    public ArrayList<Lloguer> getLloguers() { return lloguers; }
    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String informe() {
        // De moment buit
        return null;
    }
}
