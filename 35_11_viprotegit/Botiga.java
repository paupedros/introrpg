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
        if (maxVins < 1)
            throw new IllegalArgumentException("No es pot crear una botiga amb menys d'un vi");
        vins = new Vi[maxVins];
    }

    public Vi afegeix(Vi vi) throws BotigaException {
        if (vi == null)
            throw new IllegalArgumentException("El vi no pot ser null");
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
                throw new BotigaException();
            } else
                throw new IllegalArgumentException("Referència de vi repetida");
        } else
            throw new IllegalArgumentException("El vi ha de ser vàlid");
    }

    public Vi elimina(String refVi) {
        if (refVi == null)
            throw new IllegalArgumentException("La referència no pot ser null");
        refVi = UtilString.normalitzaString(refVi);
        Vi vi = cerca(refVi);
        if (vi != null) {
            // Si te estoc...
            if (vi.getEstoc() > 0) {
                throw new IllegalArgumentException("El vi a eliminar no pot tenir estoc");
            } else {
                for (int i = 0; i < vins.length; i++) {
                    Vi deletedVi = vins[i];
                    if (deletedVi == null)
                        continue;
                    if (refVi.equalsIgnoreCase(vins[i].getRef())) {
                        vins[i] = null;
                        return deletedVi;
                    }
                }
            }
        }
        throw new IllegalArgumentException("La instància a eliminar ha d'estar present");
    }

    public Vi cerca(String ref) {
        if (ref == null)
            throw new IllegalArgumentException("La referència no pot ser null");
        ref = UtilString.normalitzaString(ref);
        for (int i = 0; i < vins.length; i++) { // Per cada vi de la llista de vins
            Vi vi = vins[i];
            if (vi != null && ref.equalsIgnoreCase(vi.getRef()))
                return vi;
        }
        return null;
    }

    public Vi cerca(Vi plantilla) {
        if (plantilla == null)
            throw new IllegalArgumentException("La plantilla no pot ser null");
        for (Vi vi : vins) {
            if (vi == null)
                continue;
            // System.out.println(vi);
            // STRINGS
            // -------------
            // Si la referencia no esta buida...
            if (plantilla.getRef() != null)
                // Si les referencies no coincideixen...
                if (!UtilString.esPlantillaDeText(plantilla.getRef(), vi.getRef()))
                    continue;
            if (plantilla.getNom() != null)
                if (!UtilString.esPlantillaDeText(plantilla.getNom(), vi.getNom()))
                    continue;
            if (plantilla.getLloc() != null)
                if (!UtilString.esPlantillaDeText(plantilla.getLloc(), vi.getLloc()))
                    continue;
            if (plantilla.getOrigen() != null)
                if (!UtilString.esPlantillaDeText(plantilla.getOrigen(), vi.getOrigen()))
                    continue;
            if (plantilla.getTipus() != null)
                if (!UtilString.esPlantillaDeText(plantilla.getTipus(), vi.getTipus()))
                    continue;
            if (plantilla.getCollita() != null)
                if (!UtilString.esPlantillaDeText(plantilla.getCollita(), vi.getCollita()))
                    continue;

            // ENTERS
            // -----------

            if (plantilla.getPreu() == -1) {
                if (plantilla.getEstoc() == -1)
                    return vi;
                else if (vi.getEstoc() >= plantilla.getEstoc())
                    return vi;
            }
            // Si s'especifica el preu maxim
            else if (vi.getPreu() <= plantilla.getPreu()) {
                if (plantilla.getEstoc() == -1)
                    return vi;
                else if (vi.getEstoc() >= plantilla.getEstoc())
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
        while (index < vins.length) {
            Vi newVi = vins[index];
            index++;
            if (newVi == null) {
                continue;
            }
            return newVi;
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