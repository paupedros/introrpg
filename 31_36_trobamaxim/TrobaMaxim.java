
/* Introduim valors i al final es calcula quin es el maxim, es para d'introduir valors quan 
	s'introdueix un valor negatiu */

public class TrobaMaxim {
	public static void main(String[] args){
		System.out.println("Introdueix un valor");
		int valor = Integer.parseInt(Entrada.readLine());
		int maxim = valor;
		if (valor>= 0){
			while(valor>=0){
				if (valor > maxim){
					maxim = valor;
				}
				System.out.println("Introdueix un valor");
				valor = Integer.parseInt(Entrada.readLine());
			}
			
		}
		else {
			maxim = 0;
		}
		System.out.println("El màxim és " + maxim);
	}
}
