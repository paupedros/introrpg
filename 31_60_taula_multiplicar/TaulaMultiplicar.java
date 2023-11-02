
/* En aquest programa demanarem 4 nombres, els dos primers seran els nombres que farem la taula de 
	multiplicar, els dos ultims pels quals multiplicarem */

public class TaulaMultiplicar {
	public static void main(String[] args) {
		int primer = Integer.parseInt(args[0]);
		int segon = Integer.parseInt(args[1]);
		int tercer = Integer.parseInt(args[2]);
		int quart = Integer.parseInt(args[3]);
		
		if (primer>segon){
			int primerTmp = primer;
			primer = segon;
			segon = primerTmp;
		}
		
		for (int i=primer; i<=segon; i++) {
			if (tercer == quart){
				int mult = i*tercer;
				System.out.println(i + " x " + tercer + " = " + mult);
			}
			else {
				int mult = i*tercer;
				System.out.println(i + " x " + tercer + " = " + mult);
				mult = i*quart;
				System.out.println(i + " x " + quart + " = " + mult);
			}
			
		}
	}
}
