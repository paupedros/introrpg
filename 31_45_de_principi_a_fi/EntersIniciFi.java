
/* En aquest programa preguntem un valor inicial, un final i un salt.  */

public class EntersIniciFi{
	public static void main(String[] args){
		System.out.println("Valor inicial?");
		int numInicial = Integer.parseInt(Entrada.readLine());	// variable de recorregut assignada al primer valor
		System.out.println("Valor final?");
		int numFinal = Integer.parseInt(Entrada.readLine());
		System.out.println("Salt?");
		int salt = Integer.parseInt(Entrada.readLine());
		
		while (numInicial <= numFinal) {  // condició de sortida en passar del darrer valor
  	  		System.out.println(numInicial);
  	  		numInicial = numInicial + salt;    // passem el número al següent
		}
	}
}
