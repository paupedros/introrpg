
/* En aquest programa introduim dos valors i indiquem els caracters que hi ha entre els dos intervals,
	tot el proces que es fa per retornar el text dins l'interval es fara dins d'un modul */

public class MostraInterval {
	public static void main(String[] args){
		System.out.println("text?");
		String text = Entrada.readLine();
		System.out.println("inici?");
		int inici = Integer.parseInt(Entrada.readLine());
		System.out.println("final?");
		int fi = Integer.parseInt(Entrada.readLine());
		
		mostraInterval(text, inici, fi);
		
	}
	
	public static void mostraInterval(String text, int inici, int fi){
		if (fi >= text.length()){
			fi = text.length()-1;
		}
		if (inici >= text.length()) {
			inici = text.length()-1;
		}
		if (inici < 0) {
			inici = 0;
		}
		if (fi < 0){
			fi = 0;
		}
		if (inici<=fi){
			for (int i=inici; i<=fi; i++){
				System.out.println(text.charAt(i));
			}
		}
		else {
			for (int i=inici; i>=fi; i--){
				System.out.println(text.charAt(i));
			}
		}
	}
}


