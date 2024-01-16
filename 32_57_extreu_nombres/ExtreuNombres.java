/*
 * Demana un text i extreu els nombres
 */
public class ExtreuNombres {
    public static void main(String[] args){
        System.out.println("Text?");
        String text = Entrada.readLine();
        String nombres = extreuNombres(text);
        System.out.println(nombres);
    }
    // extreu els nombres i els retorna concatenats
    public static String extreuNombres(String text) {
        String nombre = "";
        // cas base
        if(text.isEmpty()) return text;

        // tracta pas actual
        char primer = text.charAt(0);
        if(Character.isDigit(primer)){ // si es un nombre li donem a la string el valor del caracter
            nombre = Character.toString(primer);
        }

        // tracta pas recursiu
        String rest = text.substring(1); // guardem la resta del text
        String restaText = extreuNombres(rest); // tractem la resta del text per quedar-nos amb els nombres

        // composa resultat
        String newText = nombre + restaText; // el nombre d'ara mes els demes
        return newText;
    }
}