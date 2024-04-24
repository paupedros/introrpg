/*
 * Enum que enumera les diferents possibilitats que pot tenir la propietat
 * d'origen d'un vi.
 */

public enum Origen {
    ALELLA("Alella"),
    CATALUNYA("Catalunya"),
    CONCA_DE_BARBERA("Conca de Barberà"),
    COSTERS_DEL_SEGRE("Costers del Segre"),
    EMPORDA("Empordà"),
    MONTSANT("Montsant"),
    PENEDES("Penedès"),
    PLA_DE_BAGES("Pla de Bages"),
    PRIORAT("Priorat"),
    TARRAGONA("Tarragona"),
    TERRA_ALTA("Terra Alta"),
    ALTRE("altre");

    private final String descr;

    Origen(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return descr;
    }

    /**
     * Si la cadena es null o buida retornem null,
     * si coincideix amb algun valor retornem la coincident,
     * sino coincideix retornem ALTRE
     */
    public static Origen fromString(String string) {
        if (string == null || string.isBlank())
            return null;
        string = UtilString.normalitzaString(string.toLowerCase());
        for (Origen origen : Origen.values()) {
            String desc = origen.descr.toLowerCase();
            if (desc.equalsIgnoreCase(string) || desc.startsWith(string)) {
                return origen;
            }
        }
        return ALTRE;
    }
}
