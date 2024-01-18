/*
 * Donat un text mostrarem totes les subcadenes posibles d'aquest text, nomes les lletres
 */

public class Subcadenes {
    public static void main(String[] args) {
        System.out.println("Text?");
        String text = cleanText(Entrada.readLine());
        mostraNode(text, 0, text.length());
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

    public static void mostraNode(String text, int posInici, int posFinal){
        String subc1 = "";
        String subc2 = "";

        // cas base
        if(text.length() > 1){ // Si el len del node es mes gran a 1
            // pas actual - tenim una cadena, l'hem de dividir entre dues subcadenes, pel mig
            subc1 = text.substring(0, text.length()/2); // Primera meitat
            subc2 = text.substring(text.length()/2, text.length()); // Segona meitat

            // pas recursiu
            mostraNode(subc1, 0, text.length()/2); // mostrem el fill esquerre
            System.out.printf("%4d: %s%n", text.length(), text); // mostrem el node actual

            mostraNode(subc2, text.length()/2+1, subc2.length()); // mostrem el fill dret
        }
        if (text.length() == 1 ) // si el node te len 1 el mostrem
        System.out.printf("%4d: %s%n", text.length(), text);

    }
}
