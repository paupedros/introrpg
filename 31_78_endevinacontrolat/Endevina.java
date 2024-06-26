
/* En aquest programa s'ha d'endevinar el nombre 42, l'usuari l'ha d'endevinar amb pistes de si és
	més gran o més petit */

public class Endevina {
	public static void main(String[] args){
		int numPensat = 42;
		boolean enter = false;
		
		while (true){
			System.out.println("Nombre?");
			String num = Entrada.readLine();
			if (num.isBlank()) break;
			
			num = num.strip();
			
			// Mentre que no sigui enter
			while (!enter){
				for (int i=0; i<num.length(); i++){
					char ch = num.charAt(i);
					if (i == 0 && (ch == '-' || ch == '+')) continue;
					if (!Character.isDigit(ch)){ // Si el caracter no és un nombre
						System.out.println("Només nombres");
						enter = false;
						break;
					}
					enter = true;
				}
				if (!enter){ 	// Si no és enter tornem a demanar un nombre
					System.out.println("Nombre?");
					num = Entrada.readLine();
					num = num.strip();
					continue;
				}
				break;
				
			}
			enter = false; // Reiniciem si és enter per el seguent nombre
			
			
			
			int numUser = Integer.parseInt(num);
			
			if (numPensat == numUser){
				System.out.println("Encertat!");
				return;
			}
			if (numUser > 100){
				System.out.println("Fora de rang");
			}
			else if (numUser < 1){
				System.out.println("Fora de rang");
			}
			else if (numUser > numPensat){
				System.out.println("Massa gran");
				
			}
			else if (numUser < numPensat) {
				System.out.println("Massa petit");
			}
			continue;

		}
		
		System.out.println("Cancel·lat!");
		
		
		
		
	}
}


