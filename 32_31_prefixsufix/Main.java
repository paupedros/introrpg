/* Aquest programa comprova el funcionament de les funció UtilSTring.esPrefix() i esSufix() */
public class Main {
    public static void main(String[] args) {
        System.out.println("Text principal?");
        String principal = Entrada.readLine();
        System.out.println("Subtext?");
        String subtext = Entrada.readLine();
        System.out.println("Extricte?");
        boolean extricte = UtilitatsConfirmacio.respostaABoolean(Entrada.readLine());
        System.out.printf("esPrefix(\"%s\", \"%s\", %b) -> %b%n",
                principal, subtext, extricte,
                UtilString.esPrefix(principal, subtext, extricte));
        System.out.printf("esSufix(\"%s\", \"%s\", %b) -> %b%n",
                principal, subtext, extricte,
                UtilString.esSufix(principal, subtext, extricte));
    }
}
