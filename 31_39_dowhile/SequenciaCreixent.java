
/* En aquest exercici utilitzarem el do-while per demanar un valor fins que el valor introduit sigui
	més petit que l'anterior */
	
public class SequenciaCreixent {
	public static void main(String[] args){
		
		
		int valor;
		int valor2;
		
		int i = 2;
		do {
			System.out.println("Introdueix un valor");
			valor = Integer.parseInt(Entrada.readLine());
			System.out.println("Introdueix un valor");
			valor2 = Integer.parseInt(Entrada.readLine());
			i++;
			
			
		} while (valor < valor2);
		
		System.out.println("Longitud de la seqüencia creixent: " + i);
	}
}



