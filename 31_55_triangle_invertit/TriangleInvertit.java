
/* En aquest programa indicarem un nombre i farem un triangle invertit amb una secuencia de nombres
	que cada vegada va a menys */

public class TriangleInvertit{
	public static void main(String[] args){
		System.out.println("Nombre?");
		int nombre = Integer.parseInt(Entrada.readLine());
		
		if (!(nombre<1)) {
			for (int fila=nombre; fila>=1; fila--){
				for (int i=1; i<=fila; i++){
					if (i==fila){
						System.out.print(i);
					}
					else{
						System.out.print(i + ", ");	
					}
					
				}
				
				System.out.println();
			}
		}
	}
}

