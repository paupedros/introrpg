
/* En aquest programa introduirem un text i ensenyarem les estadistiques */

public class InformeText{
	public static void main(String[] args){
		String vocals = "aeiouàéèíïóòúüAEIOUÀÉÈÍÏÓÒÚÜ";
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		int maju = 0;
		int minu = 0;
		int vocalMaju = 0;
		int vocalMinu = 0;
		int digits = 0;
		int altre = 0;
		int carac = text.length();
		
		if(text.isBlank()) return;
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			
			// Si és lletra majuscula o minuscula
			if(Character.isLetter(ch)){
				if (Character.isUpperCase(ch)){
					maju++;
				}
				else {
					minu++;
				}
			}
			
			//Si és nombre
			else if (Character.isDigit(ch)){
				digits++;
			}
			// Altres caracters
			else {
				altre++;
			}
			
			// Si és vocal
			for (int n=0; n<vocals.length(); n++){
				if (ch == vocals.charAt(n)){
					// Si és majúscula o minúscula
					if (Character.isUpperCase(ch)){
						vocalMaju++;
					}
					else {
						vocalMinu++;
					}
					break;
				}
			}
			
			
			
		}
		
		
		int lletres = maju+minu;
		int vocalsTotal = vocalMaju + vocalMinu;
		
		System.out.print("Informe\n=======\n");
		System.out.printf("lletres en majúscules: %d (%.2f%%)%n", maju, 100.0 * maju/carac);
		System.out.printf("lletres en minúscules: %d (%.2f%%)%n", minu, 100.0 * minu/carac);
		System.out.printf("total lletres: %d (%.2f%%)%n", lletres, 100.0 * lletres/carac);
		System.out.printf("vocals en majúscules: %d (%.2f%%)%n", vocalMaju, 100.0 * vocalMaju/carac);
		System.out.printf("vocals en minúscules: %d (%.2f%%)%n", vocalMinu, 100.0 * vocalMinu/carac);
		System.out.printf("total vocals: %d (%.2f%%)%n", vocalsTotal, 100.0 * vocalsTotal/carac);
		System.out.printf("digits: %d (%.2f%%)%n", digits, 100.0 * digits/carac);
		System.out.printf("altres caràcters: %d (%.2f%%)%n", altre, 100.0 * altre/carac);
		System.out.printf("total caràcters: %d", carac);
		
		
		
	}
}


