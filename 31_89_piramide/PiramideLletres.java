
/* En aquest programa demanem un text i amb aquest fem una piramide */

public class PiramideLletres{
	public static void main(String[] args){
		
		System.out.println("Text?");
		String text = Entrada.readLine();
		String textNou = "";
		int textLen = text.length();
		int numPunts = 0;
		String textFinal = "";
		
		if(text.isBlank()){
			return;
		}
		
		// Creacio de la paraula completa separada per punts
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			if(i==text.length()-1){
				textNou = textNou + ch;
				break;
			}
			textNou = textNou + ch + ".";
		}
		
		int textNouLen = textNou.length();
		numPunts = textLen + textNouLen%textLen-1;
		for (int punts=0; punts<numPunts; punts++){
				textFinal += ".";
		}
		textNou = "";
		
		for (int linia=0; linia<text.length(); linia++){
			
			for (int columna=0; columna<=linia; columna++){
				char ch = text.charAt(columna);
				
				if(columna==linia){ // al ultim caracter del text de la columna no posa el punt
					textNou = textNou.concat("" + ch);
					break;
				}
				textNou = textNou.concat("" + ch + ".");
			}
			if (linia==text.length()-1){ // 
				//System.out.print(textNou);
				//System.out.println("-");
			}
			else if(linia!=0){// Si la linea no es la primera
				textNouLen = textNou.length();
				numPunts -= 2;
				for (int punts=0; punts<numPunts; punts++){
					textFinal += ".";
				}
			}
			textFinal += textNou;
			textNou = "";
			System.out.print(textFinal);
			System.out.print("-");
			
			// Text del reves
			for (int i=textFinal.length()-1; i>=0; i--){
				char ch = textFinal.charAt(i);
				System.out.print(ch);
			}	
			// Print textFinal al reves
			
			System.out.println();
			textFinal = "";
			
			
			
		}
		
	}
}



