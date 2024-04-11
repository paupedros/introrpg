/**
 * Classe Botiga que contindra els vins que hi hauran
 * te metodes per afegir, eliminar i cercar vins
 */

public class Botiga {
    private int DEFAULT_MAX_VINS = 10;
    private Vi[] vins;
    private int index = 0;

    Botiga() {
        vins = new Vi[DEFAULT_MAX_VINS];
    }

    Botiga(int maxVins) {
        vins = new Vi[maxVins];
    }

    public Vi afegeix(Vi vi) {
        if (vi.esValid()) {
            // Si no es troba cap vi amb el mateix nom al de afegir
            if (cerca(vi.getNom()) == null) {
                // Busca un espai null a la llista
                for (int i = 0; i < vins.length; i++) {
                    if (vins[i] == null) {
                        vins[i] = vi;
                        return vi;
                    }
                }
                return null;
            } else
                return null;
        }
        else return null;
    }

    public Vi elimina(String nomVi) {
        nomVi = Vi.normalitzaNom(nomVi);
        Vi vi = cerca(nomVi);
        if (vi != null) {
            // Si te estoc...
            if (vi.getEstoc() > 0) {
                return null;
            }
            else {
                for (int i = 0; i < vins.length; i++) {
                    Vi deletedVi = vins[i];
                    if (nomVi.equals(vins[i].getNom())) {
                        vins[i] = null;
                        return deletedVi;
                    }
                }
            }
        }
        return vi;
    }

    public Vi cerca(String nom) {
        nom = Vi.normalitzaNom(nom);
        for (int i = 0; i < vins.length; i++) { // Per cada vi de la llista de vins
            Vi vi = vins[i];
            if (vi != null && nom.equalsIgnoreCase(vi.getNom()))
                return vi;
        }
        return null;
    }

    public void iniciaRecorregut() {
        index = 0;
    }

    public Vi getSeguent() {
        if (vins[index] == null) index++;
        return vins[index];
    }
}