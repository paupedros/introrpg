/* Aquest programa ens demana 3 nombres i els retorna ordenats ascendenment */

public class TresEnOrdre{
	public static void main(String[] args) {
		System.out.println("Primer?");
		int primer = Integer.parseInt(Entrada.readLine());
		System.out.println("Segon?");
		int segon = Integer.parseInt(Entrada.readLine());
		System.out.println("Tercer?");
		int tercer = Integer.parseInt(Entrada.readLine());
		int primerNum = 0;
		int segonNum = 0;
		int tercerNum = 0;
		
		if ( primer < segon && primer < tercer) {
			primerNum = primer;
		}
		else if ( segon < primer && segon < tercer ) {
			primerNum = segon;
		}
		else if ( tercer < primer && tercer < segon ) {
			primerNum = tercer;
		}
		
		if ( (segon < primer && segon > tercer) || (segon < tercer && segon > primer)) {
			segonNum = segon;
		}
		else if ( (primer < segon && primer > tercer) || (primer < tercer && primer > segon)) {
			segonNum = primer;
		}
		else if ((tercer < primer && tercer > segon) || (tercer < segon && tercer > primer) ){
			segonNum = tercer;
		}
		
		if ( tercer > primer && tercer > segon ) {
			tercerNum = tercer;
		}
		else if ( primer > tercer && primer > segon ) {
			tercerNum = primer;
		}
		else if ( segon > primer && segon > tercer ) {
			tercerNum = segon;
		}
		
		System.out.println( primerNum + ", " + segonNum + " i " + tercerNum);
		
		
	}
}
