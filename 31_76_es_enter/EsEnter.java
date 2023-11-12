
/* En aquest programa introduirem un text i ens dira si es un enter o no, 
	parara quan es trobi amb el text buit */

public class EsEnter{
	public static void main(String[] args){
		System.out.println("Introdueix texts (enter sol per finalitzar)");
		String text = Entrada.readLine();
		boolean number = true;
		
		
		while(!text.isBlank()){
			text = text.strip();
			number = true;
			for (int i = 0; i<text.length(); i++){
				char ch = text.charAt(i);
				if (ch == '-' || ch == '+'){
				
				}
				else if (!Character.isDigit(ch)){
					number = false;
				}
				
			}
			if (number == false){
				System.out.println("No és enter");
			}
			else {
				System.out.println("És enter");
			}
			text = Entrada.readLine();
			
		}
		System.out.println("Adéu");
	}
}


