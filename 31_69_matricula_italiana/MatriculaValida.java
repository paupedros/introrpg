
/* En aquest programa introduim una matricula i ens dira si te un format valid per a ser d'Italia */

public class MatriculaValida {
	public static void main(String[] args) {
	
		System.out.println("Introduïu una matrícula");
		String matricula = Entrada.readLine();
		
		String lletresInicial = matricula.substring(0,2);
		String nums = matricula.substring(2,5);
		String lletresFinal = matricula.substring(5,7);
		
		boolean valida = false;
		
		
		// Validació primeres dues lletres
		for (int i=0; i<=1; i++){
			char caracter = lletresInicial.charAt(i);
			int ascii = (int) caracter;
			
			if (ascii<65 || ascii>=90){
				valida=true;
			}
			
			else if (caracter == 'I'
			|| caracter == 'O'
			|| caracter == 'Q'
			|| caracter == 'U'){
				valida=false;
			}
			else valida=false;
			
		}
		
		if (valida==true){
			// Validació nombres
			for (int i=0; i<=2; i++){
				char caracter = nums.charAt(i);
				
				if (Character.isDigit(caracter)){
					valida=true;
				}
				else {
					valida=false;
				}
			}
		}
		
		if (valida==true) {
			// Validació dues lletres finals
			for (int i=0; i<=1; i++){
				char caracter = lletresFinal.charAt(i);
				int ascii = (int) caracter;
				
				if (ascii<65 || ascii>=90){
					valida=true;
				}
				
				else if (caracter == 'I'
				|| caracter == 'O'
				|| caracter == 'Q'
				|| caracter == 'U'){
					valida=false;
				}
				else valida=false;
				
			}
		}
		
		
		
		
		
		
		if (valida == true) {
			System.out.println("És una matrícula italiana vàlida");
		}
		
		else {
			System.out.println("No és una matrícula italiana vàlida");
		}

	}
}
