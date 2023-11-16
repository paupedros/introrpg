
/* En aquest programa demanem un text i farem un triangle invertit a partir dels seus caracters */

public class TriangleLletresInvertit{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		while(true){
			// Si el text esta buit sortim del bucle
			if(text.length()==0) break;
			// Print del text girat
			for (int i=text.length()-1; i>=0; i--){
				char ch = text.charAt(i);
				if (i == 0){
					System.out.print(ch);
				}
				else {
					System.out.print(ch + ", ");
				}
				
			}
			System.out.println();
			// Li treiem l'ultim caracter al text
			text = text.substring(0,text.length()-1);
		}
		
		
		
	}
}



