
/* En aquest programa el lloro espera una paraula i la repeteix, 
	demanara paraules fins que li introdueixis una cadena buida o amb espai/tabuladors */
	
public class Lloro {
	public static void main(String[] args){
		System.out.println("El lloro espera paraula:");
		String paraula = Entrada.readLine();
        
        while (!paraula.isBlank()){
        	System.out.println("El lloro repeteix: " + paraula);
        	System.out.println("El lloro espera paraula:");
			paraula = Entrada.readLine();
		}
        
		
		System.out.println("Adéu");
	}
}
