
/* En aquest programa introduim una matricula i ens dira si te un format valid per a ser d'Italia */

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
					if (!Character.isLetter(caracter)){
						valid=false;
					}
					else if (Character.toUpperCase(caracter) != caracter){
						valid = false;
					}
					else if (caracter == 'I'
						|| caracter == 'O'
						|| caracter == 'Q'
						|| caracter == 'U') {
						valid = false;
					}
				}
				if (i==2 || i==3 || i==4){
					if(!Character.isDigit(caracter)){
						valid=false;
					}
				}
			}
					
					
			//System.out.println(valid);
			if (valid=false){
				System.out.println("És una matrícula italiana vàlida");
			}
			else {
				System.out.println("No és una matrícula italiana vàlida");
			}
			
		}
	}
}
