/* Programa que indica quina es la categoria de les caravanes segons el seu preu */

public class ClassificaCaravana {
	public static void main(String[] args){
		int preu = Integer.parseInt(args[0]);
		String categoria = "";
		if ( preu < 50000 ){
			categoria = "Econòmica";
		}
		else if ( preu <= 175000 ) {
			categoria = "General";
		}
		else if ( preu > 175000 ) {
			categoria = "Luxe";
		}
		
		
		System.out.println(categoria);
	}
}
