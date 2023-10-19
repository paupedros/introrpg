
/* En aquest programa introduirem notes entre el 0 i el 100, quan s'introdueixi 
	una fora del rang ens dirà la suma de les notes */
	
	
public class SumaNotes {
	public static void main(String[] args){
		int nota = 0;
		int notaFinal = 0;
		System.out.println("Introdueix una nota");
		nota = Integer.parseInt(Entrada.readLine());
		while (nota >=0 && nota<=100){
			notaFinal = notaFinal + nota;
			System.out.println("Introdueix una nota");
			nota = Integer.parseInt(Entrada.readLine());
			System.out.println(nota);
			
			
		}
		System.out.println("La suma de les notes vàlides és " + notaFinal);
		
	}
}
