
/* En aquest programa dibuixarem triangles a partir dels 10 primers nombres naturals,
	segons quants ens indiqui l'usuari */

public class Triangle{
	public static void main(String[] args){
		System.out.println("quants?");
		int valor = Integer.parseInt(Entrada.readLine());
		
		for (int triangle=1; triangle<=valor; triangle++){ // num triangle
			for (int linia=1; linia<=9; linia++){	// num linia (triangle en si)
				
					
				for (int punts=1; punts<=linia; punts++){
					System.out.print(".");
				}
					
				for (int i=linia; i<=9; i++){			
					System.out.print(i);
				}
					
				
				for (int i=8; i>=linia; i--){			
					System.out.print(i);
				}
				
				for (int punts=1; punts<=linia; punts++){
					System.out.print(".");
				}
				
			System.out.println();
			}
		
		}

	}
}

