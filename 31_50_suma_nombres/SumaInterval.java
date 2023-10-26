
/* En aquest programa direm dos nombres i calcularem la suma dels nombres que hi ha entre ells
	i ensenyarem els calculs que es fan amb el seu resultat */

public class SumaInterval{
	public static void main(String[] args){
		System.out.println("primer?");
		int primer = Integer.parseInt(Entrada.readLine());
		System.out.println("segon?");
		int segon = Integer.parseInt(Entrada.readLine());
		
		int suma = 0;
		
		if (primer>segon){
			int primerTmp = primer;
			primer = segon;
			segon = primerTmp;
		}
		
		for (int num1 = primer; num1<=segon; num1++){
			int sumaTotal = suma + num1;
			System.out.println(suma + " + " + num1 + " = " + sumaTotal);
			suma = sumaTotal;
		}
		
		
	}
}
