
/* En aquest programa indicarem un nombre amb el qual farem el mateix numero de linies que el 
	numero indicat comptant 1,2,3 ... fins al numero */
	
public class QuadratNombres {
	public static void main(String[] args){
		System.out.println("Valor final?");
		int valor = Integer.parseInt(Entrada.readLine());
		
		if (valor<1 || valor>9){
			System.out.println("Valor inadequat");
		}
		else {
			for (int linia=1; linia<=valor; linia++){
				for (int i=1; i<=valor; i++){
					System.out.print(" " + i);
				}
				System.out.println();
			}
		}
		
	}
}




