
/* En aquest programa introduirem un text i una posicio, amb aquesta posicio direm la categoria del
	caracter */

public class AnalitzaCaracter{
	public static void main(String[] args){
		
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		System.out.println("Posició?");
		int pos = Integer.parseInt(Entrada.readLine());
		char caracter = ' ';
		
		if (pos < 0){
			caracter = text.charAt(text.length() - pos);
		}
		else {
			caracter = text.charAt(pos);
		}
		
		
		if (pos > text.length()-1 || pos < (text.length())*-1){
			System.out.println("Fora de rang");
		}
		else {
		
			if (Character.isDigit(caracter)){
				System.out.println("\'" + caracter +  "\' " + "és un nombre");
			}
			else if (Character.isLetter(caracter)){
				System.out.println("\'" + caracter +  "\' " + "és una lletra");
			}
			else {
				System.out.println("\'" + caracter +  "\' " + "és una altra cosa");
			}
		}
		
		
		
	}
}


