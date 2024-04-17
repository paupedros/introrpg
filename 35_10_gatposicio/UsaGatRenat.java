/*
 * Classe per probar les implementacions amb enums de posicio,
 * aquest enum conte les posicions posibles que pot tenir el GatRenat
 * i amb un fromString podem convertir d'un string a la posicio corresponent
 */

public class UsaGatRenat {
    public static void main(String[] args){
        try {
            GatPosicio posicio = GatPosicio.fromString(args[0]);
            GatRenat renat = new GatRenat(posicio);
            System.out.println("El gat Renat està: " + renat.getPosicio());
       } catch (IllegalArgumentException e) {
           System.out.println(e);
       }
    }
}