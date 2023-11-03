
/* En aquest programa el lloro espera una paraula i la repeteix si comença amb vocal i en minuscula, 
	demanara paraules fins que li introdueixis una cadena buida o amb espai/tabuladors */
	
public class LloroVocalMinuscules {
	public static void main(String[] args){
		System.out.println("El lloro pregunta paraula que finalitzi amb vocal en minúscules");
		String paraula = Entrada.readLine();
        
        while (!paraula.isBlank()){
        	if (paraula.endsWith("a") || paraula.endsWith("e") || paraula.endsWith("i") || paraula.endsWith("o") || paraula.endsWith("u")) {
        	
		    	System.out.println("El lloro diu: " + paraula);
		    	
        	}
        	System.out.println("El lloro pregunta paraula que finalitzi amb vocal en minúscules");
        	paraula = Entrada.readLine();
		}
        
		
		System.out.println("Adéu");
	}
}
