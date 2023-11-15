
/* En aquest programa demanem un text, i l'enseyem del reves separant els caracters amb comes */

public class TextReves{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
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



