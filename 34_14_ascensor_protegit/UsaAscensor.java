/*
 * Programa que utilitza la classe Ascensor amb els getters i setters
 */

public class UsaAscensor {

    /* XXX */

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        
        int pisFinal = ascensor.getPis();
        String movimentFinal = ascensor.getMoviment();
        if (UtilString.esEnter(args[0]))
            pisFinal = Integer.parseInt(args[0]);
        if (args.length >= 2)
            movimentFinal = args[1];

        System.out.println("Pis inicial: " + ascensor.getPis());

        System.out.println("Moviment inicial: " + ascensor.getMoviment());

        ascensor.setPis(pisFinal);
        ascensor.setMoviment(movimentFinal);

        System.out.println("Pis final: " + ascensor.getPis());

        System.out.println("Moviment final: " + ascensor.getMoviment());

    }

}