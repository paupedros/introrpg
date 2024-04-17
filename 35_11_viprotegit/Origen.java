/*
 * Enum que enumera les diferents possibilitats que pot tenir la propietat
 * d'origen d'un vi.
 */

 public enum Origen {
    PENEDES("Penedès"),
    TERRA_ALTA("Terra Alta"),
    CATALUNYA("Catalunya"),
    TARRAGONA("Tarragona"),
    CONCA_DE_BARBERA("Conca de Barberà"),
    COSTERS_DEL_SEGRE("Costers del Segre"),
    EMPORDA("Empordà"),
    MONTANT("Montsant"),
    PRIORAT("Priorat"),
    ALELLA("Alella"),
    PLA_DE_BAGES("Pla de Bages"),
    ALTRE("altre");

    private final String descr;

    Origen(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return descr;
    }

    /**Si la cadena es null o buida retornem null,
     * si coincideix amb algun valor retornem la coincident,
     * sino coincideix retornem ALTRE
     */
    public static Origen fromString(String string){
        string = string.toUpperCase();
        if(string==null || string.isBlank()) return null;
        for (Origen origen : Origen.values()){
            if (origen.name().startsWith(string)){
                return origen;
            }
        }
        return ALTRE;
    }
}
