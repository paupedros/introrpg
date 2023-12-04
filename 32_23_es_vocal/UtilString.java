
/* Programa que conte moduls per utilitzar amb Strings, comprovar si es una vocal un caracter
	en concret */

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
	
}
