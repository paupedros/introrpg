/*
 * En aquest programa mostrarem el resultat de la suma dels arguments, nomes els enters
 */

public class SumaEnters {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 0; i < args.length; i++) {
            suma += Integer.parseInt(args[i]);
        }
        System.out.println(suma);
    }
}
