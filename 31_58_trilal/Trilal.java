
/* En aquest programa dibuixarem triangles a partir dels 10 primers nombres naturals,
	segons quants ens indiqui l'usuari */

public class Trilal{
	public static void main(String[] args){
		
		// PRIMER TRIANGLE
		for (int linia=9; linia>=0; linia--){
			System.out.print(".".repeat(9));
			for (int punts=1; punts<=linia; punts++){
				System.out.print(".");
			}
			System.out.print(".");
				
			for (int i=linia; i<=9; i++){			
				System.out.print(i);
			}
				
			
			for (int i=8; i>=linia; i--){			
				System.out.print(i);
			}
			
			for (int punts=1; punts<=linia; punts++){
				System.out.print(".");
			}
			System.out.print(".");
			System.out.print(".".repeat(9));
		System.out.println();
		}
		
		// SEGON I TERCER TRIANGLE
		for (int linia=9; linia>=0; linia--){
			
			for (int punts=1; punts<=linia; punts++){
				System.out.print(".");
			}
			//System.out.print(".");
				
			for (int i=linia; i<=9; i++){			
				System.out.print(i);
			}
				
			
			for (int i=8; i>=linia; i--){			
				System.out.print(i);
			}
			
			for (int punts=1; punts<=linia; punts++){
				System.out.print(".");
			}
			
			
			for (int punts=1; punts<=linia; punts++){
				System.out.print(".");
			}
			System.out.print(".");
				
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

