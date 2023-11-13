
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
			
			// Si és enter
			while (enter == false){
				for (int i=0; i<num.length(); i++){
					char ch = num.charAt(i);
					if (i == 0 && (ch == '-' || ch == '+')) continue;
					if (!Character.isDigit(ch)){
						System.out.println("Només nombres");
						break;
					}
					enter = true;
				}
				if (enter == true) continue;
				System.out.println("Nombre?");
				num = Entrada.readLine();
				
			}
			
			
			
			
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
			

		}
		
		System.out.println("Cancel·lat!");
		
		
		
		
	}
}


