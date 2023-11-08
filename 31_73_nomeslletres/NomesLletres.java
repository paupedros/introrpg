
/* En aquest programa introduim un text i el retornem amb les lletres separades per comes */

public class NomesLletres{
	public static void main(String[] args){
		
		System.out.println("Text?");
		String text = Entrada.readLine();
		char caracter = ' ';
		String textNou = "";
		for (int i=0; i<text.length(); i++){
			caracter = text.charAt(i);
			if (Character.isAlphabetic(caracter)){
				if (i==0){
					textNou = textNou.concat("" + caracter);
				}
				else {
					textNou = textNou.concat(", " + caracter);
				}
				
			}
		}
		
		System.out.println(textNou);
		
	}
}

