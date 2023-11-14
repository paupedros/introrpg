
/* En aquest programa introduim un text i capitalitzarem cada paraula que estigui entre caracters que no siguin lletres */

public class MajusculitzaInicials{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		text = text.toUpperCase();
		String textNou = "";
		boolean paraula = false;
		
		// Recorrem el text
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			if(!paraula){ // Si no estem en una paraula
				if(Character.isLetter(ch)){ // Si el caracter es una lletra
					ch = Character.toUpperCase(ch);
					paraula = true; // Estem en una paraula
				}
			}
			else { // Si estem en una paraula
				if(Character.isLetter(ch)){ // Si el caracter es una lletra
					ch = Character.toLowerCase(ch);
				}
			}
			if(!Character.isLetter(ch)) { // Si no és una lletra
				paraula = false;
			}
			
			
			
			textNou+= ch;
			
		}
		System.out.println(textNou);
		
		
		
	}
}




