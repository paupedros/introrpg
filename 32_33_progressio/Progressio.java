public class Progressio {
    public static void main(String[] args) {
        System.out.println("Estricte?");
        boolean estricta = UtilitatsConfirmacio.respostaABoolean(Entrada.readLine());
        
        System.out.println("Intruduïu text. Enter per finalitzar.");
        while (true) {
            String text = Entrada.readLine();
            String textMin = text.toLowerCase();
            if(text.isEmpty()) break;
            else if (UtilString.esCreixent(textMin, estricta)) {
                System.out.println(text + " és creixent");
            }
            else if (UtilString.esDecreixent(textMin, estricta)) {
                System.out.println(text + " és decreixent");
            }
            else if (UtilString.esCreixidecri(textMin, estricta)) {
                System.out.println(text + " és creixidecri");
            }
            else if(UtilString.esDecricreixi(textMin, estricta)) {
                System.out.println(text + " és decricreixi");
            }
            else {
                System.out.println(text + " és normaleta");
            }
        }
        System.out.println("Adéu");
    }

}
