public class SumaPositius {

    public static void main(String[] args) {

        int suma = 0;

        int valor = 0;

        while (valor >= 0) {

            System.out.println("Introdueix valor");

            valor = Integer.parseInt(Entrada.readLine());

            if (valor >= 0) {

                suma = suma + valor;

            }

        }

        System.out.println("La suma és " + suma);

    }

}
