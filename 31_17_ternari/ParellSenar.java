/*
 * Programa que indica si el número proporcionat com a primer argument
 * és parell o senar.
 * Si no s'especifica cap número, el resultat és indeterminat.
 */
public class ParellSenar {
	public static void main(String[] args) {
		int numero = Integer.parseInt(args[0]);
		String sortida = ( numero % 2 == 0 ) ? "parell" : "senar";
		System.out.println("El número " + numero + " és " + sortida);
		
		
	}
}
