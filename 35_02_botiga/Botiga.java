/**
 * Classe Botiga que contindra els vins que hi hauran
 * te metodes per afegir, eliminar i cercar vins
 */

public class Botiga {
    private int DEFAULT_MAX_VINS = 10;
    private Vi[] vins;

    Botiga() {
        vins = new Vi[DEFAULT_MAX_VINS];
    }

    Botiga(int maxVins) {
        vins = new Vi[maxVins];
    }

    public Vi afegeix(Vi vi) {
        boolean placed = false;
        if (vi.esValid()) {
            // Si no es troba cap vi amb el mateix nom al de afegir
            if (cerca(vi.getNom()) == null) {
                // Busca un espai null a la llista
                for (Vi findPlace : vins){
                    if (findPlace == null){
                        // Afegeix el nou vi
                        findPlace = vi;
                        // Marquem com que s'ha trobat un lloc
                        placed = true;
                        return vi;
                    }
                }
            }return null;
        }

        return vi;
    }

    public Vi elimina(String nomVi) {
        Vi vi = cerca(nomVi);
        if (vi != null) {
            if (vi.getEstoc() > 0) {
                return null;
            }
            // Si te estoc...
            else {
                for (int i = 0; i < vins.length; i++) {
                    if (nomVi.equals(vins[i].getNom())) {
                        vins[i] = null;
                        return vins[i];
                    }
                }
            }
        }
        return vi;
    }

    public Vi cerca(String nom) {
        nom = Vi.normalitzaNom(nom);
        for (Vi vi : vins) { // Per cada vi de la llista de vins
            if (nom == null) continue;
            if (nom.equals(vi.getNom()))
                return new Vi(nom, vi.getPreu(), vi.getEstoc());
        }
        return null;
    }
}