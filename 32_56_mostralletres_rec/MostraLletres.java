/*
 * Demanem un text i retornem el mateix pero nomes amb les lletres
 */

public class MostraLletres {
    public static void main(String[] args) {
        System.out.println("Text?");
        String text = Entrada.readLine();
        mostraLletres(text);
        System.out.println(); // un salt de línia final
    }

    // mostra només les lletres de text
    public static void mostraLletres(String text) {
        if (text.isEmpty()) {      // cas base
            return;
        }

        // hi ha al menys un caràcter. Comptem quantes lletres hi queden
        // considerem el primer caràcter
        char primer = text.charAt(0);
        if (Character.isLetter(primer)) {
            System.out.print(primer);
        }

        // considerem les lletres que conté la resta del text
        String restaText = text.substring(1);  // resta del text
        mostraLletres(restaText);      // crida recursiva
    }
}
