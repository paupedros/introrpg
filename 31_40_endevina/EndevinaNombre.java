/* En aquest programa el sistema pensara un numero entre el 1 i el 100, l'usuari l'ha d'endevinar
	amb pistes de si es mes gran o mes petit */
	
public class EndevinaNombre {
	public static void main(String[] args){
		int numPensat = 42;
		
		System.out.println("Ves introduint enters entre 1 i 100 fins que encertis el que jo he pensat");
		System.out.println("Introdueix un valor");
		int numEndevina = Integer.parseInt(Entrada.readLine());
		
		while (numEndevina != numPensat){
			
			if (numEndevina > numPensat){
				System.out.println("És més petit que " + numEndevina);
			}
			else if (numEndevina < numPensat) {
				System.out.println("És més gran que " + numEndevina);
			}
			else if (numEndevina > 100){
				System.out.println("Com a màxim 100");
			}
			else if (numEndevina < 1){
				System.out.println("Com a miním 1");
			}
			System.out.println("Introdueix un valor");
			numEndevina = Integer.parseInt(Entrada.readLine());
		}
		
		System.out.println("Has encertat!");
		
	}
		
}
