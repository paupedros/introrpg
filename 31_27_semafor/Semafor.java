/* En aquest programa direm de quin color esta el semafor i ens diu que hem de fer */

public class Semafor {
	public static void main(String[] args){
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
