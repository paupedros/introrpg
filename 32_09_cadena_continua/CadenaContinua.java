
/* En aquest programa demanem un text i un enter, allargarem la cadena fins a que tingui la llargada
	del enter donat, a partir de la cadena. Tot el proces d'allargar la cadena es fara
	mitjançant un modul parametritzat */

public class CadenaContinua {
	// Demanem les dades d'entrada
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		if (!text.isBlank()){
			System.out.println("Nombre?");
			int longitud = Integer.parseInt(Entrada.readLine());
			
			if (longitud<1){
			}
			else {
				mostraCadenaContinua(text, longitud);
			}
			
		}
		else {
			System.out.println("error");
		}
		
		
		
	}
	
	public static void mostraCadenaContinua(String text, int longitud){
		String nova = "";
		int i = 0;
		while(nova.length()<=longitud-1){
			if (i>=text.length()){
				i=0;
			}
			nova = nova.concat("" + text.charAt(i));
			i++;
		}
				
		System.out.println(nova);
		
	}
}


