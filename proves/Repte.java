
/* En aquest programa diubaixerem un cercle amb el caracter '■', preguntarem quants cercles volem */


public class Repte{
	public static void main(String[] args){
		
		System.out.println("Quina amplada vols?");
		int amplada = Integer.parseInt(Entrada.readLine());
		System.out.println("Quina llargada vols?");
		int llargada = Integer.parseInt(Entrada.readLine())+2;
		
		for (int i=llargada; i>=1; i--){
			if (i==llargada){
				System.out.print("-".repeat(amplada));
			}
			else if (i==1){
				System.out.print("-".repeat(amplada));
			}
			else {
				System.out.print("|"+" ".repeat((amplada-2))+"|");
			}
			System.out.println();
		}
		
		
	}
}


