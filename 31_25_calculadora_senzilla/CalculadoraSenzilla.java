/*
 * Aquest programa demana dos operands i un operador binari (+, -, * o /)
 * i mostra el resultat del càlcul corresponent
 */
public class CalculadoraSenzilla {
    public static void main(String[] args) {
        System.out.println("Operand1?");
        double operand1 = Double.parseDouble(Entrada.readLine());
        System.out.println("Operador?");
        char operador = Entrada.readLine().charAt(0);
        System.out.println("Operand2?");
        double operand2 = Double.parseDouble(Entrada.readLine());
        if (operador == '+') {
            double resultat = operand1 + operand2;
            System.out.println(operand1 + " + " + operand2 + " = " + resultat);
        }
        else if (operador == '-') {
	        double resultat = operand1 + operand2;
           	System.out.println(operand1 + " + " + operand2 + " = " + resultat);
        }
		else if (operador == '/'){
			if (operand1 == 0 || operand2 == 0) {
				System.out.println("No es pot dividir entre 0");
			}
			else {
				double resultat = operand1 / operand2;
				System.out.println(operand1 + " / " + operand2 + " = " + resultat);
			}
        }
        else if (operador == '*'){
        	double resultat = operand1 * operand2;
        	System.out.println(operand1 + " * " + operand2 + " = " + resultat);
        }
    }
}
