/*
 * Demanem un text, i anem sumant els digits recursivament
 */
public class SumaDigits {
    public static void main(String[] args){
        System.out.println("Text?");
        String text = Entrada.readLine();
        int nombres = sumaDigits(text);
        System.out.println(nombres);
    }
    // Anem sumant els digits recursivament
    public static int sumaDigits(String text) {
        // cas base
        if (text.isEmpty()) return 0;
        int num = 0;

        // tracta pas actual
        char ch = text.charAt(0);
        if (Character.isDigit(ch)) {
            num = Integer.parseInt(Character.toString(ch));
            // Si el caracter es un nombre, el pasem a string i el convertim a enter
        }
        // tracta pas recursiu
        String rest = text.substring(1);
        int restaText = sumaDigits(rest);

        // composa resultat
        int result = restaText + num;
        return result;
    }
}
