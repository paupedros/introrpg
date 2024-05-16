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
    private static final double EUROS_PER_UNITAT_DE_COST = 30;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new ArrayList<Lloguer>();
    }

    public String getNif() {
        return nif;
    }

    public String getNom() {
        return nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public ArrayList<Lloguer> getLloguers() {
        return lloguers;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String informe() {
        return composaCapsalera() + composaDetall() + composaPeu();
    }

    private double importTotal() {
        double total = 0;
        for (Lloguer lloguer : lloguers) {
            total += lloguer.calculaPreuLloguer() * EUROS_PER_UNITAT_DE_COST;
        }
        return total;
    }

    private int bonificacionsTotal() {
        int bonificacions = 0;
        for (Lloguer lloguer : lloguers) {
            bonificacions += lloguer.bonificacions();
        }
        return bonificacions;
    }

    private String composaCapsalera() {
        return "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
    }

    private String composaDetall() {
        String resultat = "";
        for (Lloguer lloguer : lloguers) {
            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +
                    (lloguer.calculaPreuLloguer() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }
        return resultat;
    }

    private String composaPeu() {
        return "Import a pagar: " + importTotal() + "€\n" +
        "Punts guanyats: " + bonificacionsTotal() + "\n";
    }
}
