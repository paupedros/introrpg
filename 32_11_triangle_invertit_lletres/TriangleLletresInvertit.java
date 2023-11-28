
/* En aquest programa demanem un text i farem un triangle invertit a partir dels seus caracters.
	Tot aixo ho farem utilitzant moduls parametritzats, un per fer la linea invertida  */

public class TriangleLletresInvertit{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		while(true){
			// Si el text esta buit sortim del bucle
			if(text.length()==0) break;
			// Print del text girat
			dibuixaTriangleInvertit(text);
			
			// Li treiem l'ultim caracter al text
			text = text.substring(0,text.length()-1);
		}
		
	}
	
	public static void dibuixaTriangleInvertit(String text){
		for (int i=text.length()-1; i>=0; i--){
			dibuixaLiniaInvertida(text, i);
		}
		System.out.println();
	}
	
	public static void dibuixaLiniaInvertida(String text, int linia){
		char ch = text.charAt(linia);
		if (linia == 0){
			System.out.print(ch);
		}
		else {
			System.out.print(ch + ", ");
		}
	}
	
}



