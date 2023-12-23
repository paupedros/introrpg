/*
 * Demanarem quants enters es vol guardar, el caracter de separacio i els valors a guardar.
 * Els mostrarem separats pel separador indicat
 */

public class EntersEntreComes {
    public static void main(String[] args){
        System.out.println("Quants?");
        boolean enter = false;
        String entrada = Entrada.readLine();
        int quants = demanaEnter(entrada);
        System.out.println("Separador?");
        char separador = getSeparador(Entrada.readLine());
        int[] numeros = new int[quants];
        
        for (int i=0; i<numeros.length; i++){
            System.out.printf("Valor %d?%n", i+1);
            numeros[i] = demanaEnter(Entrada.readLine());
        }

        System.out.println(UtilString.entreComes(numeros, separador));

    }

    public static int demanaEnter(String entrada){
        while(!UtilString.esEnter(entrada)){ // Si la entrada no es un enter
            System.out.println("Per favor, un valor enter");
            entrada = Entrada.readLine();
        }
        int quants = UtilString.aEnter(entrada, false); 
        return quants;
    }

    public static char getSeparador(String entrada){
        char separador = ',';
        if(!entrada.isEmpty()){
            separador = entrada.charAt(0);
        }
        return separador;
    }

}
