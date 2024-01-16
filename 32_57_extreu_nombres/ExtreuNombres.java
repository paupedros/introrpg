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
        String nombres = "";
        // cas base
        if(text.isEmpty()) return text;

        // tracta pas actual
        char primer = text.charAt(0);
        if(!Character.isDigit(primer)){
            nombres += primer;
        }

        // tracta pas recursiu
        String rest = text.substring(1);
        extreuNombres(rest);

        // composa resultat
        String newText = nombres + rest;
        return newText;
    }
}