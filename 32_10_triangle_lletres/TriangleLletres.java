
/* En aquest programa demanem un text, a partir d'aquest text farem un 
	triangle creixent amb els caracters. Ho farem amb dos moduls, un per dibuixar la linea i l'altre
	pel triangle sencer.
	
	Aixi:
	Nemesio
	N
	N, e
	N, e, m
	N, e, m, e	
	N, e, m, e, s
 	N, e, m, e, s, i
 	N, e, m, e, s, i, o
		
*/

public class TriangleLletres {
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		
		dibuixaTriangle(text);
		
		
		
	}
	
	public static void dibuixaTriangle(String text){
		for (int linia=1; linia<=text.length(); linia++){
			
			dibuixaLinia(text, linia);
			
			System.out.println();
		}
	}
	
	public static void dibuixaLinia(String text, int linia){
		// Fer linia
		for (int i=0; i<linia; i++){
			char ch = text.charAt(i);
			if(i==0){
				System.out.print(ch);
				continue;
			}
			System.out.print(", " + ch);
		}
		
	}
	
	
	
}





