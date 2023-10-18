public class SumaPositius {
    public static void main(String[] args) {

        // creem la variable on guardarem el resultat de sumar
        int suma = 0;   // inicialment no hem sumat res i per tant és 0

        // demanem valors

        // declarem la variable que contindrà els valors llegits
        int valor;

        // processem el primer valor
        System.out.println("Introdueix el primer valor");
        valor = Integer.parseInt(Entrada.readLine());
        
        while (valor >= 0){
        	System.out.println("Introdueix el tercer valor");
        	valor = Integer.parseInt(Entrada.readLine());
        	suma = suma + valor;
        }

        // mostrem el resultat
        System.out.println("La suma és " + suma);
    }
}
