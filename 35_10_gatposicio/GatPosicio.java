/*
 * Classe que implementa els enum en la posicio d'un gat
 */

public enum GatPosicio {
    DRET, ASSEGUT, ESTIRAT;

    public static GatPosicio fromString(String posicio) throws IllegalArgumentException {
        for (GatPosicio pos : GatPosicio.values()){
            if (posicio.equalsIgnoreCase(pos.name())){
                return pos;
            }
        }
        throw new IllegalArgumentException(String.format("Valor \"%s\" no suportat per GatPosicio", posicio));
    }
}