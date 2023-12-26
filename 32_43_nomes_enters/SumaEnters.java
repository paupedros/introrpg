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
        int[] enters = filtraEnters(args, quants);
        System.out.println(enters.toString());
    }

    public static int quantsEnters(String[] valors) {
        int quants = 0;
        for (int i = 0; i < valors.length; i++) {
            if (esEnter(valors[i])) {
                quants++;
            }
        }
        return quants;
    }

    public static int[] filtraEnters(String[] valors, int quants) {
        int[] enters = new int[quants];
        int j = 0;
        for (int i = 0; i < valors.length; i++) {
            if (esEnter(valors[i])) {
                enters[j] = Integer.parseInt(valors[i]);
                j++;
            }
        }
        return enters;
    }

    public static boolean esEnter(String text) {
		if (text.isEmpty())
			return false;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (i == 0 && (ch == '-' || ch == '+')) {
				continue;
			} else if (!Character.isDigit(ch)) {
				return false;
			}

		}
		return true;
	}

}
