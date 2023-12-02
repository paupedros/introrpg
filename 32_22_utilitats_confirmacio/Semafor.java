
/* En aquest programa direm de quin color esta el semafor i ens diu que hem de fer 
	Com a ampliacio farem que l'usuari digui si és major d'edat, si no ho es no el deixarem executar
	el programa.
*/

public class Semafor {
	public static void main(String[] args){
		
		System.out.println("Ets major d'edat?");
		String resposta = Entrada.readLine();
		// Guardem el boolea de sortida de la confirmacio
		boolean major = UtilitatsConfirmacio.respostaABoolean(resposta);
		if (!major){ // Si no es major d'edat no el deixem executar el programa
			System.out.println("No pots fer servir aquest programa sense supervisió");
			return;
		}
		
		semafor();
		
	}
	
	public static void semafor(){
		System.out.println("Color?");
		String color = Entrada.readLine();
		if (color.equals("groc")) {
	    	System.out.println("corre!");
		}
		else if (color.equals("vermell")) {
	    	System.out.println("espera");
		}
		else if (color.equals("verd")) {
	    	System.out.println("passa");
		}
		else {
			System.out.println("ves a l'oculista");
		}
	}
	
}
