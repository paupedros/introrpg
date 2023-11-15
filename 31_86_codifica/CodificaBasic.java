
/* En aquest programa demanem un text i codifiquem les lletres entre la 'a' i la 'z' */

public class CodificaBasic{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		String textNou = "";
		
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			
			if (ch == 'z'){
				ch = 'a';
			}
			else if(ch >= 'a' && ch <= 'z'){
				ch = (char) (ch + 1);
			}
			
			
			textNou+=ch;
		}
		
		System.out.println(textNou);
		
	}
}



