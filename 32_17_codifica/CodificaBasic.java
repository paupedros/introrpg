
/* En aquest programa demanem un text i codifiquem les lletres entre la 'a' i la 'z'.
	En aquesta nova versio demanem quant nombres incrementem el valor de les lletres, tot 
	utilitzant moduls */

public class CodificaBasic{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		System.out.println("Quants?");
		int quants = Integer.parseInt(Entrada.readLine());
		if (quants < 0){
			System.out.println("No s'accepten números negatius");
			return;
		}
		codifica(text, quants);
		
	}
	
	public static void codifica(String text, int quants){
		String textNou = "";
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			
			if (ch == 'z'){
				ch = 'a';
				ch = (char) (ch + quants - 1);
			}
			else if(ch >= 'a' && ch <= 'z'){
				ch = (char) (ch + quants);
			}
			
			
			textNou+=ch;
		}
		
		System.out.println(textNou);
	}
	
}



