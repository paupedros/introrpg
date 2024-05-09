/*
 * Classe GestorLite: petita implementació per a fer proves bàsiques del codi del gestor de lloguers
 * de vehicles. Contindrà dos mètodes estàtics: creaClientDemo i mostraClient, a més tindrà un main
 * per provar aquestes funcionalitats.
 */

public class GestorLite {
    public static Client creaClientDemo(){
        Client demo = new Client("51590695Q", "Eugènia Salinas Roig", "93614214242");
        Lloguer seat = new Lloguer(new Vehicle("Seat", "600", 1), 2);
        Lloguer tata = new Lloguer(new Vehicle("Tata", "Vista", 1), 5);
        Lloguer fiat = new Lloguer(new Vehicle("Fiat", "Uno", 3), 3);
        demo.getLloguers().add(seat);
        demo.getLloguers().add(tata);
        demo.getLloguers().add(fiat);

        return demo;
    }

    public static void mostraClient(Client demo) {
        String client = String.format("Client: %s%n        %s%n        %s", demo.getNom(), demo.getNif(), demo.getTelefon());
        System.out.println(client);
        System.out.println("Lloguers: " + demo.getLloguers().size());
        for (int i = 0; i < demo.getLloguers().size(); i++) {
            Lloguer lloguer = demo.getLloguers().get(i);
            Vehicle vehicle = lloguer.getVehicle();
            System.out.print("        ");
            System.out.println(String.format("%d. vehicle: %s %s", i+1, vehicle.getMarca(), vehicle.getModel()));
            System.out.print("           ");
            System.out.println(String.format("dies llogats: %d", lloguer.getDies()));
        }
    }

    public static void main(String[] args) {
        Client demo = creaClientDemo();
        mostraClient(demo);
    }
}