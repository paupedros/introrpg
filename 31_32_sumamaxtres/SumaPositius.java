public class SumaPositius {

    public static void main(String[] args) {


        // creem la variable on guardarem el resultat de sumar

        int suma = 0;   // inicialment no hem sumat res i per tant és 0


        // demana el primer valor

        System.out.println("Introdueix valor");

        int valor = Integer.parseInt(Entrada.readLine());


        // ves sumant mentre el valor sigui positiu

        while (valor >= 0) {

            suma = suma + valor;

            // demana un nou valor

            System.out.println("Introdueix valor");

            valor = Integer.parseInt(Entrada.readLine());

        }


        // mostrem el resultat

        System.out.println("La suma és " + suma);

    }

}
