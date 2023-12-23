/**
 * En aquest programa recollim notes d'un alumne i al final en diem quina ha sigut la nota mes alta
 */
public class NotaMesAlta {
    public static void main(String[] args) {
        System.out.println("Introdueix les notes (-1 per finalitzar)");
        int nota = Integer.parseInt(Entrada.readLine());
        String notes = "";
        while (nota != -1) {
            notes += nota;
            nota = Integer.parseInt(Entrada.readLine());
        }

        if(notes.length() <= 1){
            System.out.println("Com a mínim calen dues notes");
            return;
        }

        int notaMesAlta = 0;
        for (int i = 0; i < notes.length(); i++) {
            char ch = notes.charAt(i);
            if(Character.getNumericValue(ch) >= notaMesAlta){
                notaMesAlta = Character.getNumericValue(ch);
            }
        }
        System.out.println("La nota més alta és " + notaMesAlta);
        
    }
    
}