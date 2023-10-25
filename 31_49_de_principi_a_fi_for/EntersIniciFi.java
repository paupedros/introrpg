
/* En aquest programa preguntem un valor d'inici, fi i el salt. I imprimim els nombres que 
	hi han entre els valors amb el salt */
	
public class EntersIniciFi {
	public static void main(String[] args){
		System.out.println("Valor inicial?");
		int numInicial = Integer.parseInt(Entrada.readLine());
		System.out.println("Valor final?");
		int numFinal = Integer.parseInt(Entrada.readLine());
		System.out.println("Salt?");
		int salt = Integer.parseInt(Entrada.readLine());
		
		for(int i=numInicial; i<numFinal; i+=salt){
			System.out.println(i);
		}
	}
}
