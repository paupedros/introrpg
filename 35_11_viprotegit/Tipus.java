/*
 * Enum que enumera les diferents possibilitats que pot tenir la propietat
 * tipus d'un vi.
 */

public enum Tipus {
    BLANC("blanc"),
    NEGRE("negre"),
    ROSAT("rosat"),
    ALTRE("altre");

    private final String descr;

    Tipus(String descr) {
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
    public static Tipus fromString(String string){
        if(string==null || string.isBlank()) return null;
        string = string.toUpperCase();
        for (Tipus tipus : Tipus.values()){
            // Si el tipus comença amb la string demanada retornem el tipus
            if (tipus.name().startsWith(string)){
                return tipus;
            }
        }
        return ALTRE;
    }
}