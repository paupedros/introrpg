
/* En aquest programa el lloro espera una paraula i la repeteix si comença amb vocal i en minuscula, 
	demanara paraules fins que li introdueixis una cadena buida o amb espai/tabuladors */
	
public class LloroVocalMinuscules {
	public static void main(String[] args){
		System.out.println("El lloro pregunta paraula que comenci amb vocal en minúscules");
		String paraula = Entrada.readLine();
        
        while (!paraula.isBlank()){
        	if (paraula.startsWith("a") || paraula.startsWith("e") || paraula.startsWith("i") || paraula.startsWith("o") || paraula.startsWith("u")) {
        	
		    	System.out.println("El lloro diu: " + paraula);
		    	
        	}
        	System.out.println("El lloro pregunta paraula que comenci amb vocal en minúscules");
        	paraula = Entrada.readLine();
		}
        
		
		System.out.println("Adéu");
	}
}
