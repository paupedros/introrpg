
/* En aquest programa farem un lloro que repeteix texts fins que troba un text buit, si el text és
	'dibuixa quadrat', dibuixarà un quadrat, si és 'dibuixa rectangle', un rectangle */

public class LloroQuadrat{
	
	public static void main(String[] args){
		
		System.out.println("El lloro espera paraula:");
		String text = Entrada.readLine();
		
		while(true){
			if (text.isEmpty()){
				break;
			}
			else if(text.equals("dibuixa quadrat")){
				dibuixaQuadrat();
			}
			else if(text.equals("dibuixa rectangle")){
				dibuixaRectangle();
			}
			else{
				System.out.println("El lloro repeteix: " + text);
			}
			
			System.out.println("El lloro espera paraula:");
			text = Entrada.readLine();
		}
		
		System.out.println("Adéu");
		
	}
	
	
	
	public static void dibuixaRectangle(){
		// dibuixa un rectangle
		for (int linia=1; linia <= 5; linia++) {
			// dibuixa una línia
			dibuixaLinia();
			dibuixaLinia();
			// dibuixa un salt de línia
			System.out.println();
       	}
       	
	}
	
	public static void dibuixaQuadrat(){
		// dibuixa un quadrat
		for (int linia=1; linia <= 5; linia++) {
			// dibuixa una línia
			dibuixaLinia();
			// dibuixa un salt de línia
			System.out.println();
       	}
		
	}
	
	public static void dibuixaLinia(){
		for (int columna=1; columna <= 5; columna++) {
			// dibuixa un element de la línia
	    	System.out.print(" X");
		}
		
	}
}



