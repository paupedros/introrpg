
/* Amb aquest programa introduim nombres i es contaran quants parells hem introduit, es para de demanar
	nombres quan s'introdueix un negatiu */
	
	
public class QuantsParells {
	public static void main(String[] args){
		int valor = 0;
		int parells = 0;
		System.out.println("Introdueix un valor");
		valor = Integer.parseInt(Entrada.readLine());
		while (valor >=0){
			if (valor % 2 == 0){
				parells = parells + 1;
			}
			
			System.out.println("Introdueix un valor");
			valor = Integer.parseInt(Entrada.readLine());
			
			
			
		}
		System.out.println("Nombre de parells introduïts: " + parells);
		
	}
}
