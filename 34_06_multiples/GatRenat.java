public class GatRenat {
    int vides = 7;   // vides disponibles del gat Renat

    public static void main(String[] args) {
        GatRenat renatI;
        renatI = new GatRenat();               // crea un primer gat Renat
        System.out.println("El gat Renat I té  " + renatI.vides + " vides");

        GatRenat renatII = new GatRenat();     // crea un segon gat Renat!
        System.out.println("El gat Renat II té " + renatII.vides + " vides");

        renatI.vides++;
        System.out.println("El gat Renat I té  " + renatI.vides + " vides");
        System.out.println("El gat Renat II té " + renatII.vides + " vides");

        renatII = renatI; // atenció: la instància de Renat II es perd!
        System.out.println("El gat Renat I té  " + renatI.vides + " vides");
        System.out.println("El gat Renat II té " + renatII.vides + " vides");

        renatI.vides++;
        System.out.println("El gat Renat I té  " + renatI.vides + " vides");
        System.out.println("El gat Renat II té " + renatII.vides + " vides");
    }

}