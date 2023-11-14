
/* En aquest programa introduirem un text i convertirem les vocals en majuscules */

public class VocalsMajuscules{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		text = text.toLowerCase();
		String vocals = "aeiou";
		
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			// Comprovar si el caracter es una vocal (el passarem a majuscula)
			boolean vocal = false;
			for (int n=0; n<vocals.length(); n++){
				if (ch == vocals.charAt(n)){
					vocal = true;
					ch = Character.toUpperCase(ch);
					break;
				}
			}
			
			System.out.print(ch);
			
			
		}
		System.out.println();
		
	}
}


