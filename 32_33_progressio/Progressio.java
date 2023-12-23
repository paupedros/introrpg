public class Progressio {
    public static void main(String[] args) {
        System.out.println("Intruduïu text. Enter per finalitzar.");
        System.out.println("Estricte?");
        boolean estricta = UtilitatsConfirmacio.respostaABoolean(Entrada.readLine());
        while (true) {
            String text = Entrada.readLine();
            if(text.isEmpty()) break;
            else if (UtilString.esCreixent(text, estricta)) {
                System.out.println(text + " és creixent");
            }
            else if (UtilString.esDecreixent(text, estricta)) {
                System.out.println(text + " és decreixent");
            }

            else {
                System.out.println(text + " és normaleta");
            }
        }
        System.out.println("Adéu");
    }

}
