
/* En aquest programa introduim un text i el retornem amb les lletres separades per comes.
	Les dades d'entrada es faran al main, el tractament 
	de les dades es fara a un modul parametritzat */

public class NomesLletres{
	public static void main(String[] args){
		
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		filtraLletres(text);
		
		
		
	}
	
	public static void filtraLletres(String text){
		String textNou = "";
		boolean primer = false;
		for (int i=0; i<text.length(); i++){
			char caracter = text.charAt(i);
			
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

