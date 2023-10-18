
/* En aquest programa el client introduirà els sintomes que te, 
	segons aquests l'assistent li dirà el seu diagnostic */
	
public class Metge {
	public static void main(String[] args){
		System.out.println("Tens alguns d'aquests símptomes? Digues-me'ls separats per comes");
		System.out.println("esternuts, mal de cap, problemes d'estómac, tos");
		String simptomes = Entrada.readLine();
		System.out.println("Quants anys tens?");
		int edat = Integer.parseInt(Entrada.readLine());
		
		if (simptomes.contains("esternuts") && simptomes.contains("mal de cap")){
			if (simptomes.contains("problemes d'estómac")){
				System.out.println("Et recomano que et prenguis un Paracetamol");
			}
			else {
				System.out.println("Et recomano que prenguis àcid acetil salicílic (AAS)");
			}
		}
		else if (simptomes.contains("tos")){
			if (edat < 12){
				System.out.println("Et recomano prendre un caramel de mel");
			}
			else {
				System.out.println("Et recomano prendre un caramel d'eucaliptus");
			}
		}
		else {
			System.out.println("Seria millor que vinguesis a la consulta presencialment!");
		}
		
	}
}

