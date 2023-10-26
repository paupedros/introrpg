
/* En aquest programa demanem un nombre, farem un triangle amb tots els nombres que hi han fins
	aquell, en valor decreixent */

public class TriangleNombres{
	public static void main(String[] args){
		System.out.println("Nombre?");
		int nombre = Integer.parseInt(Entrada.readLine());
		
		for (int linia=1; linia<=nombre; linia++){
			for (int columna=linia; columna>=1; columna--){
				System.out.print(" " + columna);
			}
			System.out.println();
		}
	}
}


