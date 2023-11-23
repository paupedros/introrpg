
/* En aquest programa demanem un nombre i dibuixarem quadrats de 5x5 amb X, utilitzant moduls */

public class Quadrats{
	public static void main(String[] args){
		
		System.out.println("Quants?");
		int num = Integer.parseInt(Entrada.readLine());
		
		for (int i=num; i>0; i--){
			// dibuixa un quadrat
		    for (int linia=1; linia <= 5; linia++) {

		        // dibuixa una línia
		    	for (int columna=1; columna <= 5; columna++) {

		            // dibuixa un element de la línia
		            System.out.print(" X");

		        }

		        // dibuixa un salt de línia
		        System.out.println();
        	}
			System.out.println();
		}
		
		
		
	}
}





