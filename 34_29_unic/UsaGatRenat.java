public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = GatRenat.getInstancia();
        System.out.println("Inicialment Renat està " + renat.getPosicio());
        for (String posicio: args) {
            canviaPosicio(posicio);
            System.out.println("Ara està " + renat.getPosicio());
        }
    }
    private static void canviaPosicio(String novaPosicio) {
        // Tradueix novaPosicio: 1 -> estirat, 2 -> assegut, 3 -> dret,
        // altrament es queda com estava
        if (novaPosicio.equals("1")) novaPosicio = "estirat";
        else if (novaPosicio.equals("2")) novaPosicio = "assegut";
        else if (novaPosicio.equals("3")) novaPosicio = "dret";
        GatRenat.getInstancia(novaPosicio);
    }
}