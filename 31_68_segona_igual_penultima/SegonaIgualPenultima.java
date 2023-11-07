
/* En aquest programa demanarem textos i direm si la segona lletra es igual a la penultima */

public class SegonaIgualPenultima {
	public static void main(String[] args) {
		
		System.out.println("Ves introduïnt texts (finalitza amb enter sol)");
		String text = Entrada.readLine();
		
		while (!text.isBlank()){
			
			if (text.length() <= 1){
				System.out.println("Segona diferent de penúltima");
			}
			
			
			else {
				char segona = text.charAt(1);
				char penultima = text.charAt(text.length()-2);
				
				
				if (segona == penultima){
					System.out.println("Segona igual a penúltima");
				}
				else {
					System.out.println("Segona diferent de penúltima");
				}
			}
			
			text = Entrada.readLine();
		}
		System.out.println("Adéu");
		
	}
}

