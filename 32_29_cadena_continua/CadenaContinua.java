
/* En aquest programa demanem un text i un enter, allargarem la cadena fins a que tingui la llargada
	del enter donat, a partir de la cadena 
	Implementacio del modul cadenaContinua per a fer-ho externament, i la funcio esEnter per comprovar 
	si el nombre indtroduit es un enter.
*/

public class CadenaContinua {
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		if (!text.isBlank()){
			System.out.println("Nombre?");
			String num = Entrada.readLine();
			if(UtilString.esEnter(num)){
				int numInt = UtilString.aEnter(num, true);
				
				System.out.println(UtilString.cadenaContinua(text, numInt));
				
			}
			else{
				System.out.println("error");
				return;
			}
			return;
		}
		
		System.out.println("error");
		
		
		
		
	}
}


