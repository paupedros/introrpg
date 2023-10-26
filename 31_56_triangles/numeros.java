public class numeros{
	public static void main(String[] args){
		
		int valor=2;		
		
		for (int triangle=1)		
				
		for (int linia=9; linia>=0; linia--){
			
				
/* punts */		for (int punts=1; punts<=linia; punts++){
					System.out.print(".");
				}
					
				for (int i=linia; i<=9; i++){			
					System.out.print(i);
				}
				
				if (linia!=9){
					for (int i=8; i>=linia; i--){			
						System.out.print(i);
					}
				}
				for (int punts=1; punts<=linia; punts++){
					System.out.print(".");
				}
				
				System.out.println();
				
				
				
			}
			System.out.println();
		}
	}

