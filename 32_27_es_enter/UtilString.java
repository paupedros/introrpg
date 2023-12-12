
/* Programa que conte moduls per utilitzar amb Strings:
	Moduls:
	- esVocal: Comprovar si un caracter en concret es una vocal catalana
	- nomesLletres: Agafa un String i retorna la mateixa amb nomes lletres
	- lletresSeparades: Agafa un String i retorna la mateixa separada per comes	
	- intervalString: Donat un text, valor inicial i valor final, retorna la secció del text entre aquest interval
	- esEnter: donat un nombre ens dira si és enter o no
	
*/

public class UtilString{
	
	public static boolean esVocal(char ch){
		String vocals = "aàeèéiíïoóòuúü";
		char chMin = Character.toLowerCase(ch);
		for (int i=0; i<vocals.length(); i++){
			if (chMin == vocals.charAt(i)){
				return true;
			}
		}
		return false;
	}
	
	public static String nomesLletres(String text){
		String newText = "";
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			if(Character.isAlphabetic(ch)){
				newText += ch;
			}
		}
		return newText;
	}
	
	public static String lletresSeparades(String text){
		String newText = "";
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			if(i==0){
				newText += ch;
				continue;
			}
			newText += ", " + ch;
		}
		return newText;
	}
	
	public static String intervalString(String text, int inici, int numFinal){
		String newText = "";
		
		// Ajustament dels intervals
		if (numFinal >= text.length()){
			numFinal = text.length()-1;
		}
		if (inici >= text.length()) {
			inici = text.length()-1;
		}
		if (inici < 0) {
			inici = 0;
		}
		if (numFinal < 0){
			numFinal = 0;
		}
		
		// Creació de la secció del nou text
		if (inici<=numFinal){
			for (int i=inici; i<=numFinal; i++){
				char ch = text.charAt(i);
				newText+=ch;
			}
		}
		else {
			for (int i=inici; i>=numFinal; i--){
				char ch = text.charAt(i);
				newText+=ch;
			}
		}
		return newText;
	}
	
	public static boolean esEnter(String text){
		if(text.isEmpty()) return false;
		for (int i = 0; i<text.length(); i++){
			char ch = text.charAt(i);
			if ( i == 0 && (ch == '-' || ch == '+')){
				continue;
			}
			else if (!Character.isDigit(ch)){
				return false;
			}
			
		}
		return true;
	}
	
}
