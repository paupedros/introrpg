/*
 * En aquest programa mostrarem el resultat de la suma dels arguments, nomes els enters
 */

public class SumaEnters {
    public static void main(String[] args) {
        int quants = quantsEnters(args);
        System.out.println(quants);
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
