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
            Vi cercaVi = cerca(vi.getRef());
            // System.out.println(cercaVi);
            if (cercaVi == null) {
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
        } else
            return null;
    }

    public Vi elimina(String refVi) {
        refVi = Vi.normalitzaString(refVi);
        Vi vi = cerca(refVi);
        if (vi != null) {
            // Si te estoc...
            if (vi.getEstoc() > 0) {
                return null;
            } else {
                for (int i = 0; i < vins.length; i++) {
                    Vi deletedVi = vins[i];
                    if (refVi.equalsIgnoreCase(vins[i].getRef())) {
                        vins[i] = null;
                        return deletedVi;
                    }
                }
            }
        }
        return vi;
    }

    public Vi cerca(String ref) {
        ref = Vi.normalitzaString(ref);
        for (int i = 0; i < vins.length; i++) { // Per cada vi de la llista de vins
            Vi vi = vins[i];
            if (vi != null && ref.equalsIgnoreCase(vi.getRef()))
                return vi;
        }
        return null;
    }

    public Vi cerca(Vi plantilla) {

        for (Vi vi : vins) {
            if (vi == null)
                continue;
            // STRINGS
            // -------------
            // Si la referencia no esta buida...
            if (plantilla.getRef() != null)
                // Si les referencies no coincideixen...
                if (!plantilla.getRef().equalsIgnoreCase(vi.getRef()))
                    continue;
            if (plantilla.getNom() != null)
                if (!plantilla.getNom().equalsIgnoreCase(vi.getNom()))
                    continue;
            if (plantilla.getLloc() != null)
                if (!plantilla.getLloc().equalsIgnoreCase(vi.getLloc()))
                    continue;
            if (plantilla.getOrigen() != null)
                if (!plantilla.getOrigen().equalsIgnoreCase(vi.getOrigen()))
                    continue;
            if (plantilla.getTipus() != null)
                if (!plantilla.getTipus().equalsIgnoreCase(vi.getTipus()))
                    continue;
            if (plantilla.getCollita() != null)
                if (!plantilla.getCollita().equalsIgnoreCase(vi.getCollita()))
                    continue;

            // ENTERS
            // -----------

            if (plantilla.getPreu() == -1) {
                if (plantilla.getEstoc() == -1)
                    return vi;
                else if (vi.getEstoc() > plantilla.getEstoc())
                    return vi;
            }
            // Si s'especifica el preu maxim
            else if (vi.getPreu() <= plantilla.getPreu()) {
                if (plantilla.getEstoc() == -1)
                    return vi;
                else if (vi.getEstoc() > plantilla.getEstoc())
                    return vi;
            }

            if (plantilla.getEstoc() == -1) {
                if (plantilla.getPreu() == -1)
                    return vi;
                else if (vi.getPreu() <= plantilla.getPreu())
                    return vi;
            }
            else if (vi.getEstoc() > plantilla.getEstoc()) {
                if (plantilla.getPreu() == -1)
                    return vi;
                else if (vi.getPreu() <= plantilla.getPreu())
                    return vi;
            }


        }
        return null;
    }

    public void iniciaRecorregut() {
        index = 0;
    }

    public Vi getSeguent() {
        // Mentre que no ens passem del rang i el vi actual sigui null
        while (index < vins.length && vins[index] == null) {
            index++;
        }

        // Si no ens hem passat del rang
        if (index < vins.length) {
            Vi vi = vins[index];
            index++;
            return vi;
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (Vi vi : vins) {
            if (vi == null) {
                result += "null\n";
                continue;
            }
            result += vi.getNom();
            result += "\n";
        }
        return result;
    }
}