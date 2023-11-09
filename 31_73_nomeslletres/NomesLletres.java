
/* En aquest programa introduim un text i el retornem amb les lletres separades per comes */

public class NomesLletres{
	public static void main(String[] args){
		
		System.out.println("Text?");
		String text = Entrada.readLine();
		char caracter = ' ';
		String textNou = "";
		boolean primer = false;
		for (int i=0; i<text.length(); i++){
			caracter = text.charAt(i);
			
			if (Character.isAlphabetic(caracter)){
				if (primer==false){
					textNou = textNou.concat("" + caracter);
					primer=true;
				}
				else {
					textNou = textNou.concat(", " + caracter);
				}
				
			}
		}
		
		System.out.println(textNou);
		
	}
}

