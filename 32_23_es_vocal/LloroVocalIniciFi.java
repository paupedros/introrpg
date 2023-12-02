
/* En aquest programa fem un lloro que repeteix una paraula si comença o acaba en vocal, si la paraula
	és buida demanara confirmacio per acabar el programa */

public class LloroVocalIniciFi{
	
	public static void main(String[] args){
		
		
		while(true){
			System.out.println("El lloro demana paraula amb vocal a l'inici o/i final");
			String paraula = Entrada.readLine();
			if(paraula.isEmpty()){
				System.out.println("El lloro demana confirmació per finalitzar");
				String resposta = Entrada.readLine();
				boolean fi = UtilitatsConfirmacio.respostaABoolean(resposta);
				if (fi) break;
				else {
					continue;
				}
			}
			if(UtilString.esVocal(paraula.charAt(0)) 
			|| UtilString.esVocal(paraula.charAt(paraula.length()-1))){
				System.out.println("El lloro diu: " + paraula);
				
			}
		}
		
		System.out.println("Adéu");
		
		
		
		
	}
	
}



