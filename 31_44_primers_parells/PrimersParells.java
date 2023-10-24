
/* Imprimirem els 10 primers nombres parells en ordre ascendent */

public class PrimersParells{
	public static void main(String[] args){
		int numero = 2;         // variable de recorregut assignada al primer valor
		while (numero <= 10) {  // condició de sortida en passar del darrer valor
  	  		System.out.println(numero);
  	  		numero = numero + 2;    // passem el número al següent
		}
	}
}
