public class SumaPositius {

    public static void main(String[] args) {


        int suma = 0;

        int valor;


        // demana el primer valor

        System.out.println("Introdueix valor");

        valor = Integer.parseInt(Entrada.readLine());


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
