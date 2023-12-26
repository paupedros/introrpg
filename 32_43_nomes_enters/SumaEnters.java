/*
 * En aquest programa mostrarem el resultat de la suma dels arguments, nomes els enters
 */

public class SumaEnters {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println(0);
            return;
        }
        int quants = quantsEnters(args);
        int[] enters = filtraEnters(args);
        int suma = sumaEnters(enters);
        System.out.println(suma);
    }

    public static int quantsEnters(String[] valors) {
        int quants = 0;
        for (int i = 0; i < valors.length; i++) {
            if (UtilString.esEnter(valors[i])) {
                quants++;
            }
        }
        return quants;
    }

    public static int[] filtraEnters(String[] valors) {
        int quants = quantsEnters(valors);
        int[] enters = new int[quants];
        int j = 0;
        for (int i = 0; i < valors.length; i++) {
            if (UtilString.esEnter(valors[i])) {
                enters[j] = Integer.parseInt(valors[i]);
                j++;
            }
        }
        return enters;
    }

    public static int sumaEnters(int[] enters){
        int suma = 0;
        for (int i = 0; i < enters.length; i++) {
            suma += enters[i];
        }
        return suma;
    }


}
