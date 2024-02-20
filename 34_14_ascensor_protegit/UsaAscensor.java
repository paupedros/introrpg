/*
 * Programa que utilitza la classe Ascensor amb els getters i setters
 */

public class UsaAscensor {

    /* XXX */

    public static void main(String[] args) {
        if (args.length < 2) return;
        int pisFinal = -1;
        if (UtilString.esEnter(args[0]))
            pisFinal = Integer.parseInt(args[0]);
        String movimentFinal = args[1];

        Ascensor ascensor = new Ascensor();

        System.out.println("Pis inicial: " + ascensor.getPis());

        System.out.println("Moviment inicial: " + ascensor.getMoviment());

        ascensor.setPis(pisFinal);
        ascensor.setMoviment(movimentFinal);

        System.out.println("Pis final: " + ascensor.getPis());

        System.out.println("Moviment final: " + ascensor.getMoviment());

    }

}