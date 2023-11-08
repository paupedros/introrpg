
/* En aquest programa introduim una matricula i ens dira si te un format valid per a ser d'Italia,
	si no te un format valid ens dira el perque */

public class MatriculaValida {
	public static void main(String[] args) {
	
		System.out.println("Introduïu una matrícula");
		String matricula = Entrada.readLine();
		boolean valid = true;
		char caracter = ' ';
		String error = "";
		
		if (matricula.length() == 7){
			
			for (int i=0; i<7; i++){
				caracter = matricula.charAt(i);
				// Primeres i ultimes dues lletres 
				if (i==0 || i==1 || i==5 || i==6){
					if (!Character.isLetter(caracter)){
						valid=false;
						error = error.concat(caracter + ": Ha de ser una lletra\n");
					}
					else if (Character.toUpperCase(caracter) != caracter){
						valid = false;
						error = error.concat(caracter + ": Ha de ser majúscula\n");
					}
					else if (caracter == 'I'
						|| caracter == 'O'
						|| caracter == 'Q'
						|| caracter == 'U') {
						valid = false;
						error = error.concat(caracter + ": No és una lletra vàlida\n");
					}
					else if (!(caracter >= 'A' && caracter <= 'Z')) {
						valid = false;
						error = error.concat(caracter + ": No és una lletra vàlida\n");
					}
					else {
						error = error.concat(caracter + ": Correcte\n");
					}
				}
				// Nombres
				if (i==2 || i==3 || i==4){
					if(!Character.isDigit(caracter)){
						valid=false;
						error = error.concat(caracter + ": Ha de ser un dígit\n");
					}
					else {
						error = error.concat(caracter + ": Correcte\n");
					}
				}
			}
					
					
			//System.out.println(valid);
			if (valid==false){
				System.out.println("No és una matrícula italiana vàlida");
				System.out.println(error);
			}
			else if (valid) {
				System.out.println("És una matrícula italiana vàlida");
			}
			
		}
		else if (matricula.length() > 7){
			System.out.println("No és una matrícula italiana vàlida: massa llarga");
		}
		else if (matricula.length() < 7){
			System.out.println("No és una matrícula italiana vàlida: massa curta");
		}
		
	}
}
