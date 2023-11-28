
/* En aquest programa demanem un text, i l'enseyem del reves separant els caracters amb comes.
	Les dades entrada farem servir nomes el main que cridara a un modul parametritzat per fer que el
	text es vegi del reves */

public class TextReves{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		mostraReves(text);
		
	}
	
	public static void mostraReves(String text){
		for (int i=text.length()-1; i>=0; i--){
			char ch = text.charAt(i);
			if (i == 0){
				System.out.print(ch);
			}
			else {
				System.out.print(ch + ", ");
			}
			
			
		}
		
		System.out.println();
	}
}



