/**
 * En aquest programa recollim notes d'un alumne i al final en diem quina ha sigut la nota mes alta.
 * a de mes direm quines han sigut totes les notes sense incloure la nota mes alta
 *
 */
public class NotaMesAlta {
    public static void main(String[] args) {
        System.out.println("Introdueix les notes (-1 per finalitzar)");
        int nota = Integer.parseInt(Entrada.readLine());
        String notes = "";
        int notaMesAlta = 0;
        while (nota != -1) {
            notes += nota;
            nota = Integer.parseInt(Entrada.readLine());
            if(nota == 10) notaMesAlta = 10;
        }

        if(notes.length() <= 1){
            System.out.println("Com a mínim calen dues notes");
            return;
        }
        if(notaMesAlta != 10){
            notaMesAlta = getNotaMesAlta(notes);
        }

        notes = comes(transformNotes(notes, notaMesAlta));



        String resta = ". La resta de notes és: " + notes;
        if(notes.length() < 1){
            resta = ". No queda cap altra nota.";
        }

        System.out.println("La nota més alta és " + notaMesAlta + resta);

    }

    public static int getNotaMesAlta (String notes){
        int notaMesAlta = 0;
        for (int i = 0; i < notes.length(); i++) {
            char ch = notes.charAt(i);
            if(Character.getNumericValue(ch) >= notaMesAlta){
                notaMesAlta = Character.getNumericValue(ch);
            }
        }
        return notaMesAlta;
    }

    public static String transformNotes(String text, int notaMesAlta){
        String newText = "";
        boolean first = false;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
            int charInt = ch - '0';
            // treiem la nota mes alta
            if (ch == '1' && text.charAt(i+1) == '0'){
                continue;
            }
            if (ch == '0' && text.charAt(i-1) == '1' && i != 0) continue;

            else if(charInt == notaMesAlta) continue;
            else {
                newText += ch;
            }

		}

		return newText;
    }

    public static String comes(String text){
        String newText = "";

        for (int i = 0; i < text.length(); i++) {
            if(i==0){
                newText += text.charAt(i);
                continue;
            }
            else if(i == text.length() - 1){
                newText += " i " + text.charAt(i);
                continue;
            }
            else {
                newText += ", " + text.charAt(i);
            }
        }
        return newText;

    }

}