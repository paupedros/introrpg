
/* Programa que conte moduls per utilitzar amb Strings:
	Moduls:
	- esVocal: Comprovar si un caracter en concret es una vocal catalana
	- nomesLletres: Agafa un String i retorna la mateixa amb nomes lletres
	- lletresSeparades: Agafa un String i retorna la mateixa separada per comes	
	
	
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
	
}
