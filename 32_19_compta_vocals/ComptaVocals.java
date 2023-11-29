/* En aquest programa demanem un text i comptem les vocals catalanes que té el text i ho indiquem */

public class ComptaVocals {
    public static void main(String[] args) {
    	System.out.println("Introdueix un text");
    	String text = Entrada.readLine();
    	
        String vocals = "aàeèéiíïoóòuúü";
        for (int j=0; j<vocals.length(); j++){
        	char lletra = vocals.charAt(j);
        	int quantes = quantesOcurrencies(text, lletra);
        	mostraOcurrencies(lletra, quantes);
        }
    }
    public static void mostraOcurrencies(char lletra, int quantes) {
        System.out.println("Nombre de '" + lletra + "'s: " + quantes);
    }
    public static int quantesOcurrencies(String text, char lletra) {
        int comptador = 0;
        for (int i=0; i < text.length(); i++) {
            if (text.charAt(i) == lletra) {
                comptador += 1;
            }
        }
        return comptador;
    }
}
