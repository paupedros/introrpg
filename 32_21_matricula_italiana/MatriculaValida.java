
/* En aquest programa introduim una matricula i ens dira si te un format valid per a ser d'Italia,
	la validacio de les lletres la farem amb un modul */

public class MatriculaValida {
	public static void main(String[] args) {
	
		System.out.println("Introduïu una matrícula");
		String matricula = Entrada.readLine();
		boolean valid = true;
		char caracter = ' ';
		
		if (matricula.length() == 7){
			
			for (int i=0; i<7; i++){
				caracter = matricula.charAt(i);
				// Primeres i ultimes dues lletres 
				if (i==0 || i==1 || i==5 || i==6){
					valid = esLletraValidaPerMatriculaItaliana(caracter);
				}
				// Nombres
				if (i==2 || i==3 || i==4){
					if(!Character.isDigit(caracter)){
						valid=false;
					}
				}
			}
			
			//System.out.println(valid);
			if (valid==false){
				System.out.println("No és una matrícula italiana vàlida");
			}
			else if (valid) {
				System.out.println("És una matrícula italiana vàlida");
			}
		}
		else {
			System.out.println("No és una matrícula italiana vàlida");
		}
	}
	
	public static boolean esLletraValidaPerMatriculaItaliana(char caracter){
		
		if (!Character.isLetter(caracter)){
			return false;
		}
		else if (Character.toUpperCase(caracter) != caracter){
			return false;
		}
		else if (caracter == 'I'
			|| caracter == 'O'
			|| caracter == 'Q'
			|| caracter == 'U') {
			return false;
		}
		else if (!(caracter >= 'A' && caracter <= 'Z')) {
			return false;
		}
		return true;
	}
	
}
