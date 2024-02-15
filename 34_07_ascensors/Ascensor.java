/*
 *
 */
public class Ascensor {
    int pis = -1;
    public static Ascensor[] creaAscensorsEnEscala(int quants) {
        Ascensor[] ascensors = new Ascensor[quants];
        for (int i = 0; i<ascensors.length; i++){
            ascensors[i].pis = i;
        }
        return ascensors;
    }

    public static void main(String[] args){
        if (args.length != 1) {
            System.out.println("Cap ascensor");
            return;
        }
        int quants = Integer.parseInt(args[0]);
        Ascensor[] ascensors = creaAscensorsEnEscala(quants);
        for (int i = 0; i < ascensors.length; i++) {
            System.out.printf("Ascensor %d al pis %d%n", i, ascensors[i].pis);
        }
    }
}