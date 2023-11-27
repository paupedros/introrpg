
/* En aquest programa demanem un text i un enter, allargarem la cadena fins a que tingui la llargada
	del enter donat, a partir de la cadena */

public class CadenaContinua {
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		
		
		
		if (!text.isBlank()){
			System.out.println("Nombre?");
			int num = Integer.parseInt(Entrada.readLine());
			String nova = "";
			if (num<1){
				
			}
			else {
				int i = 0;
				while(nova.length()<=num-1){
					if (i>=text.length()){
						i=0;
					}
					nova = nova.concat("" + text.charAt(i));
					i++;
				}
			
			
			
			/*	for (int i=0; nova.length()<=num-1; i++){ 
				// Mentre que la llargada de la nova cadena sigui més petita o igual al nombre indicat -1
					if (i>=text.length()){
						i=0;
					}
					nova = nova.concat("" + text.charAt(i));
					
				}*/
				System.out.println(nova);
			}
			
		}
		else {
			System.out.println("error");
		}
		
		
		
	}
}


