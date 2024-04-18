
/**
 * Classe Botiga que contindra els vins que hi hauran
 * te metodes per afegir, eliminar i cercar vins
 */
import java.util.List;
import java.util.LinkedList;

public class Botiga {
    private List<Vi> vins;

    Botiga() {
        vins = new LinkedList<Vi>();
    }

    public List<Vi> getVins() {
        return List.copyOf(vins);
    }

    public Vi afegeix(Vi vi) {
        if (vi == null)
            throw new IllegalArgumentException("El vi no pot ser null");
        if (vi.esValid()) {
            // Si no es troba cap vi amb el mateix nom al de afegir
            if (!vins.contains(vi)) {
                vins.add(vi);
                return vi;
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
                for (int i = 0; i < vins.size() - 1; i++) {
                    Vi deletedVi = vins.get(i);
                    if (deletedVi == null)
                        continue;
                    if (refVi.equalsIgnoreCase(deletedVi.getRef())) {
                        vins.remove(i);
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

        for (int i = 0; i < vins.size() - 1; i++) { // Per cada vi de la llista de vins
            Vi vi = vins.get(i);
            if (vi != null && ref.equalsIgnoreCase(vi.getRef()))
                return vi;
        }
        return null;
    }

    public List<Vi> cerca(Vi plantilla) {
        if (plantilla == null)
            throw new IllegalArgumentException("La plantilla no pot ser null");
        List<Vi> result = new LinkedList<>();
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
                    result.add(vi);
                else if (vi.getEstoc() >= plantilla.getEstoc())
                    result.add(vi);
            }
            // Si s'especifica el preu maxim
            else if (vi.getPreu() <= plantilla.getPreu()) {
                if (plantilla.getEstoc() == -1)
                    result.add(vi);
                else if (vi.getEstoc() >= plantilla.getEstoc())
                    result.add(vi);
            }
        }
        return List.copyOf(result);
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