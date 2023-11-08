
/* En aquest programa introduim un text i el retornem amb els caracters entre parentesisi */

public class Parentitza{
	public static void main(String[] args){
		
		System.out.println("Text?");
		String text = Entrada.readLine();
		char caracter = ' ';
		String textNou = "";
		for (int i=0; i<text.length(); i++){
			caracter = text.charAt(i);
			if (Character.isAlphabetic(caracter)){
				textNou = textNou.concat("(" + caracter + ")");
			}
			else {
				textNou = textNou.concat("" + caracter);
			}
		}
		
		System.out.println(textNou);
		
	}
}

