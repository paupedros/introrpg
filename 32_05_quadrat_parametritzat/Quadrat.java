
/* En aquest programa dibuixarem quadrats amb X i un nombre determinat d'allargada,
	 amb parametritzacio */

public class Quadrat{
	public static void main(String[] args){
		int num = Integer.parseInt(args[0]);
		dibuixaQuadrat(num);
		
	}
	
	
	public static void dibuixaQuadrat(int num){
		// dibuixa un quadrat
		for (int linia=1; linia <= num; linia++) {
			// dibuixa una línia
			dibuixaLinia(num);
			// dibuixa un salt de línia
	        System.out.println();
       	}
		
	}
	
	public static void dibuixaLinia(int num){
		for (int columna=1; columna <= num; columna++) {
			// dibuixa un element de la línia
	    	System.out.print(" X");
		}
	}
}





