
/* Programa que conte moduls per utilitzar amb Strings */

public class UtilString{
	
	public static boolean esVocal(char ch){
		String vocals = "aàeèéiíïoóòuúü";
		for (int i=0; i<vocals.length(); i++){
			if (ch == vocals.charAt(i)){
				return true;
			}
		}
		return false;
	}
	
}
