/* En aquest programa el sistema pensara un numero entre el 1 i el 100, l'usuari l'ha d'endevinar
	amb pistes de si es mes gran o mes petit */
	
public class EndevinaNombre {
	public static void main(String[] args){
		int numPensat = 42;
		boolean encertat = false;
		System.out.println("Ves introduint enters entre 1 i 100 fins que encertis el que jo he pensat");
		System.out.println("Introdueix un valor");
		String numEndevina = Entrada.readLine();
		if (!numEndevina.isEmpty()){ // Si no esta buida
			while (!numEndevina.isEmpty() && encertat == false) { // Mentre no estigui buida
				int numEndevina1 = Integer.parseInt(numEndevina); // Convertim a enter
				if (numEndevina1 != numPensat){ // Si no és igual al pensat
					
					if (numEndevina1 > 100){
						System.out.println("Com a màxim 100");
					}
					else if (numEndevina1 < 1){
						System.out.println("Com a mínim 1");
					}
					else if (numEndevina1 > numPensat){
						System.out.println("És més petit que " + numEndevina1);
					}
					else if (numEndevina1 < numPensat) {
						System.out.println("És més gran que " + numEndevina1);
					}
					
					System.out.println("Introdueix un valor");
					numEndevina = Entrada.readLine();
				}
				else { // Si no es diferent al numPensat es perque ha encertat
					System.out.println("Has encertat!");
					encertat = true;
					
				}
				
					
				
			}
			
			
		}
		if (numEndevina.isEmpty()) { // Si esta buit es cancel·la
			System.out.println("Cancel·lat!");
		}
		
		
	}
		
}
