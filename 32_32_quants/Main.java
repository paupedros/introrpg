
/* Aquest programa comprova el funcionament de la funció UtilSTring.quants() */

public class Main {
    public static void main(String[] args) {
        System.out.println("Text principal?");
        String principal = Entrada.readLine();
        System.out.println("Subtext?");
        String subtext = Entrada.readLine();
        System.out.println("Extricte?");
        boolean extricte = UtilitatsConfirmacio.respostaABoolean(Entrada.readLine());
        System.out.printf("quants(\"%s\", \"%s\", \"%b\") -> %d%n",
                principal, subtext, extricte,
                UtilString.quants(principal, subtext, extricte));
    }
    

}