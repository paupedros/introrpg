
/* En aquest programa demanem un text al usuari, amb aquest text posem les vocals catalanes en 
	minuscules, les lletres no vocals en majuscules, els nombres en parentesis i la resta excepte 
	els blancs desapareixen */

public class TransformaText{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		text = text.toLowerCase();
		boolean nombre = false;
		String textNou = "";
		String vocals = "aeiouàéèíïóòúü";
		
		// Recorrem el text
		while (!text.isBlank()){
		
			for (int i=0; i<text.length(); i++){
				char ch = text.charAt(i);
				boolean vocal = false;
				if(!nombre){ // Si no estem en un nombre
					if(Character.isDigit(ch)){
						textNou+="(";
						nombre = true;
					}
				}
				if (nombre){ // si estem en un nombre
					if(!Character.isDigit(ch)){ // si no es un digit
						textNou+=")";
						nombre = false;
					}
					else{ // si es un digit
						textNou+=ch;
					}
				}
				
				if(Character.isLetter(ch)){
					// Comprovar si el caracter es una vocal (el passarem a minuscula)
					vocal = false;
					for (int n=0; n<vocals.length(); n++){
						if (ch == vocals.charAt(n)){
							vocal = true;
							break;
						}
					}
					if(!vocal){
						ch = Character.toUpperCase(ch);
					}
					
				}
				else if(!Character.isWhitespace(ch)){ // Si el caracter es blanc
					continue;
				}
				textNou+=ch;
				vocal = false;
				
			}
			if(Character.isDigit(textNou.charAt(textNou.length()-1))){
				textNou+=")";
			}
			
			System.out.println(textNou);
		
		}
		
		
	}
}


