/*
 * Demanem per entrada quants enters volem guardar i els mostrem separats per comes
 */

public class EntersEntreComes {
    public static void main(String[] args) {

        int[] numeros;

        System.out.println("Quants?");
        int quants = Integer.parseInt(Entrada.readLine());
        if(quants < 1){
            System.out.println("Res a fer");
            return;
        }
        numeros = new int[quants];


        for (int i=0; i<numeros.length; i++) {
            System.out.printf("Valor %d?%n", i+1);
            numeros[i] = Integer.parseInt(Entrada.readLine());
        }

        System.out.print(numeros[0]);

        for (int i = 1; i < numeros.length; i++) {

            System.out.print(", " + numeros[i]);

        }

        System.out.println();

    }
}
