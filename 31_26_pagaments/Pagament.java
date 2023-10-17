
/* En aquest programa es calcula el canvi o el que falta 
	quan es paga una quantitat de diners */
	

public class Pagament {
	public static void main(String[] args){
		System.out.println("Preu?");
		int preu = Integer.parseInt(Entrada.readLine());
		System.out.println("Paga?");
		int paga = Integer.parseInt(Entrada.readLine());
		
		if (preu == paga){
			System.out.println("No sobra ni falta res");
		}
		else if (preu < paga){
			int canvi = paga - preu;
			System.out.println("Sobren " + canvi + "€");
		}
		else if (paga < preu){
			int canvi = preu - paga;
			System.out.println("Falten " + canvi + "€");
		}
	}
	
}



