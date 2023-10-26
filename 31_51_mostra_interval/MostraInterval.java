
/* En aquest programa introduim dos valors i indiquem els nombres que hi han entre mig */

public class MostraInterval {
	public static void main(String[] args){
		System.out.println("inici?");
		int inici = Integer.parseInt(Entrada.readLine());
		System.out.println("final?");
		int numFinal = Integer.parseInt(Entrada.readLine());
		
		if (inici<=numFinal){
			for (int i=inici; i<=numFinal; i++){
				System.out.println(i);
			}
		}
		else {
			for (int i=inici; i>=numFinal; i--){
				System.out.println(i);
			}
		}
	}
}


