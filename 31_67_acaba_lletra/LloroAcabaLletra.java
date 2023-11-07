
/* En aquest programa el lloro espera una paraula i la repeteix si acaba amb una lletra no vocal, 
	demanara paraules fins que li introdueixis una cadena buida o amb espai/tabuladors */
	
public class LloroAcabaLletra {
	public static void main(String[] args){
		System.out.println("El lloro pregunta paraula que finalitzi per lletra no vocal");
		String paraula = Entrada.readLine();
        
        while (!paraula.isBlank()){
        	paraula.toLowerCase();
        	if (paraula.endsWith("a") || paraula.endsWith("e") || paraula.endsWith("i") || paraula.endsWith("o") || paraula.endsWith("u")) {		    	
        	}
        	else {
        		System.out.println("El lloro diu: " + paraula);
        	}
        	System.out.println("El lloro pregunta paraula que finalitzi per lletra no vocal");
        	paraula = Entrada.readLine();
        	
        	
        	
        	
		}
        
		
		System.out.println("Adéu");
	}
}
