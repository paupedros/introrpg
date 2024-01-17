/*
 * Donat un text mostrarem totes les subcadenes posibles d'aquest text, nomes les lletres
 */

public class Subcadenes {
    public static void main(String[] args) {
        System.out.println("Text?");
        String text = cleanText(Entrada.readLine());
        subcadenes(text);
    }

    public static void subcadenes(String text) {
        if (text.length() <= 1) { // si es menor o igual a 1 es mostra i s'acaba
            System.out.printf("%4d: %s%n", text.length(), text);
            return;
        }


        // Mostrem per pantalla la subcadena
        System.out.printf("%4d: %s%n", text.length(), text);

    }

    // Netejem el text per quedarnos nomes amb les lletres
    public static String cleanText(String text){
        String lletra = "";
        // cas base
        if(text.isEmpty()) return text;

        // tracta pas actual
        char primer = text.charAt(0);
        if(Character.isLetter(primer)){ // si el caracter es una lletra l'afegim
            lletra = Character.toString(primer);
        }

        // tracta pas recursiu
        String rest = text.substring(1); // guardem la resta del text
        String restaText = cleanText(rest); // tractem la resta del text per quedar-nos amb les lletres

        // composa resultat
        String newText = lletra + restaText; // la lletra d'ara mes les altres
        return newText;
    }

    public static String makeSubc(String text){
        //cas base
        if(text.isEmpty()){
            return text;
        }

        // pas actual - tenim una cadena, l'hem de dividir entre dues subcadenes, pel mig
        String subc1 = text.substring(0, text.length()/2); // Primera meitat
        String subc2 = text.substring(text.length()/2, text.length()); // Segona meitat

        // pas recursiu
        

        return text;
    }
}
