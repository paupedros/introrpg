/*
 * Programa per a fer la demo de l'exemple d'herencia amb subclasses
 * de Felí
 */

public class DemoCrides {
    public static void main(String[] args) {
        Feli feli = new Feli();
        Gat gat = new Gat();
        GatRenat gatRenat = new GatRenat();
        feli.netejaUrpes();
        gat.netejaUrpes();
        gatRenat.netejaUrpes();
        gat.miola();
        gatRenat.miola();
        Menjar bacalla = new Menjar("bacallà");
        gatRenat.menja(bacalla);
    }
}