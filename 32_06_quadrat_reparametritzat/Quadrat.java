
/* En aquest programa dibuixarem un quadrat, amb parametritzacio doble, la grandaria i el caracter
	amb el que es dibuixarà */

public class Quadrat{
	public static void main(String[] args){
		int num = Integer.parseInt(args[0]);
		char ch = args[1].charAt(0);
		dibuixaQuadrat(num, ch);
		
	}
	
	
	public static void dibuixaQuadrat(int num, char ch){
		// dibuixa un quadrat
		for (int linia=1; linia <= num; linia++) {
			// dibuixa una línia
			dibuixaLinia(num, ch);
			// dibuixa un salt de línia
	        System.out.println();
       	}
		
	}
	
	public static void dibuixaLinia(int num, char ch){
		for (int columna=1; columna <= num; columna++) {
			// dibuixa un element de la línia
	    	System.out.print(" "+ch);
		}
	}
}





