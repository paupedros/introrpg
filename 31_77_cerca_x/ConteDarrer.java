
/* En aquest programa introduim un text i mirem si al text següent hi ha l'ultim caracter del primer */

public class ConteDarrer {
	public static void main(String[] args){
		System.out.println("Introdueix texts (enter sol per finalitzar)");
		String text = Entrada.readLine();
		String text2 = "";
		char ch = ' ';
		
		if (text.isBlank()){
			System.out.println("Adéu");
		}
		else {
			System.out.println("bé");
			while (true){
				text2 = Entrada.readLine();
				ch = Character.toLowerCase(text.charAt(text.length()-1));
				int index = text2.indexOf(ch);
				if (index<0){
					break;
					
				}
				System.out.println("bé");
				text = text2;
				text2 = "";
			}
			System.out.println("Adéu");
			
			
		}
	}
}



