
/* Programa que conte moduls per utilitzar amb Strings:
	Moduls i funcions:
	- esVocal: Comprovar si un caracter en concret es una vocal catalana
	- nomesLletres: Agafa un String i retorna la mateixa amb nomes lletres
	- lletresSeparades: Agafa un String i retorna la mateixa separada per comes	
	- intervalString: Donat un text, valor inicial i valor final, retorna la secció del 
	text entre aquest interval
	- esEnter: donat un nombre ens dira si és enter o no
	- esEnter(estricte): donat un nombre ens dira si és enter o no, accepta 
	texts amb espais a l'inici i al final
	- aEnter: donat un text s'intenta passar a un nombre aquest text
	- cadenaContinua: donat un text i un nombre de longitud, s'allarga la 
	cadena fins a que sigui igual a la longitud desitjada
	- esSubstring (no estricte): Si no es estricte ignora les majusucles i minuscules, a demes dels
	caracter catalans
	- esSubstring (estricte): Fara el mateix que String.contains(), retornara true si un string 
	esta dins d'un altre
	
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
	
	public static boolean esEnter(String text, boolean estricte){
		if(estricte){
			return esEnter(text);
		}
		text = text.strip();
		return esEnter(text);
	}
	
	public static int aEnter(String text, boolean estricte){
		int num;
		if(estricte){
			num = Integer.parseInt(text);
		}
		else {
			text = text.strip();
			num = Integer.parseInt(text);
		}
		return num;
	}
	
	public static String cadenaContinua(String text, int num){
		String newText = "";
		int i=0;
		while(newText.length()<=num-1){
			if (i>=text.length()){
				i=0;
			}
			newText+=text.charAt(i);
			i++;
		}
		return newText;
	}
	
	public static boolean esSubstring(String text, String subtext){
		return esSubstring(text, subtext, true);
	}
	
	public static boolean esSubstring(String text, String subtext, boolean extricte){
		if(subtext.isBlank()) return true;
		if(!extricte){
			text = text.toUpperCase();
			subtext = subtext.toUpperCase();
		}

		// Iniciem variable de recorregut de la cadena
		int i = 0;
		while (i<text.length()){ // Recorrem tota la cadena
			char ch = text.charAt(i);
			
			if(ch == subtext.charAt(0)){ // Trobem un caracter que es igual al primer del subtext
				if(conte(text, subtext, i, extricte)) return true;			
			}
			
			i++;
		}
		return false;
		
	}
	
	public static boolean conte(String text, String subtext, int i, boolean extricte){
		// Comprovem si els seguents caracters coincideixen tambe amb els del subtext
		int j = 0; // Variable de recorregut del subtext
		while(j<subtext.length()){ // Recorrem tota la cadena del subtext
			char ch = text.charAt(i); // Caracter actual del text
			
			// Si el caracter actual no es igual al caracter del subtext
			if (ch != subtext.charAt(j)){
				if(!extricte){
					if(lletraCatalana(ch)){
						i++;
						j++;
						continue;
					}
				}
				return false;
			}
			i++;
			j++;
		}
		return true;
	}
	
	public static boolean lletraCatalana(char ch){
		String lletres = "aàeèéiíïoóòuúüç";
		ch = Character.toLowerCase(ch);
		
		// Si el caracter és una 'ç' retornem true ja que es pot escriure com una c també
		if (ch == 'c' || ch == 'ç') return true;
		
		for (int i=0; i<lletres.length(); i++){
			
			if(lletres.indexOf(ch) != -1) return true;
		}
		return false;
	}
	
	// retorna cert quan text comença amb prefix, considerant si ha de ser o no extricte
	public static boolean esPrefix(String text, String prefix, boolean extricte){
		if(prefix.isBlank()) return true;
		if(!extricte){
			text = text.toUpperCase();
			prefix = prefix.toUpperCase();
		}

		// Iniciem variable de recorregut de la cadena
		int i = 0;
		while (i<text.length()){ // Recorrem tota la cadena
			char ch = text.charAt(i);
			char primeraLletra = text.charAt(0);

			if(primeraLletra == prefix.charAt(0)){ // Trobem un caracter que es igual al primer del prefix
				if(conte(text, prefix, i, extricte)) return true;
			}

			i++;
		}
		return false;

	}
	
	// equival a esPrefix(text, prefix, true)
	public static boolean esPrefix(String text, String prefix){
		return esPrefix(text, prefix, true);
	}

	// retorna cert quan text finalitza amb sufix, considerant si ha de ser o no extricte
	public static boolean esSufix(String text, String sufix, boolean extricte){
		if(sufix.isBlank()) return true;
		if(!extricte){
			text = text.toUpperCase();
			sufix = sufix.toUpperCase();
		}

		// Iniciem variable de recorregut de la cadena
		int i = 0;
		while (i<text.length()){ // Recorrem tota la cadena
			char ch = text.charAt(i);

			if(ch == sufix.charAt(0)){ // Trobem un caracter que es igual al primer del prefix
				if(conte(text, sufix, i, extricte)){
					if(text.charAt(text.length()-1) == sufix.charAt(sufix.length()-1)){
						return true;
					}
				}

			}

			i++;
		}
		return false;
	}

	// equival a esSufix(text, sufix, true)
	public static boolean esSufix(String text, String sufix){
		return esSufix(text, sufix, true);
	}
	
	
	
	
	
	
	
	









}
