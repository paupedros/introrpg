
/* En aquest programa introduim dos valors i indiquem els caracters que hi ha entre els dos intervals */

public class MostraInterval {
	public static void main(String[] args){
		System.out.println("text?");
		String text = Entrada.readLine();
		System.out.println("inici?");
		int inici = Integer.parseInt(Entrada.readLine());
		System.out.println("final?");
		int numFinal = Integer.parseInt(Entrada.readLine());
		
		
		
		if (numFinal > text.length()){
			numFinal = text.length()-1;
		}
		else if (inici > text.length()) {
			inici = text.length()-1;
		}
		
		if (inici<=numFinal){
			for (int i=inici; i<=numFinal; i++){
				System.out.println(text.charAt(i));
			}
		}
		else {
			for (int i=inici; i>=numFinal; i--){
				System.out.println(text.charAt(i));
			}
		}
	}
}


