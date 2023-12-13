
/* En aquest programa introduirem un text i ens dira si es un enter o no, 
	parara quan es trobi amb el text buit */

public class EsEnter{
	public static void main(String[] args){
		System.out.println("Introdueix texts (enter sol per finalitzar)");
		String text = Entrada.readLine();
		
		while(!text.isEmpty()){
			text = text.strip();
			boolean number = UtilString.esEnter(text);
			if (!number){
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


