/*
 * Aquesta classe permet fer proves de les
 * funcionalitats de les diferents classes d'aquest
 * exercici.
 *
 * ATENCIÓ: no modifiquis aquest programa
 */
public class ProvaBasica {
    public static void main(String[] args) {
        Client client = new Client("12341234A", "Eugènia Salinas Roig", "93614214242");
        Vehicle vehicle = new Vehicle("Seat", "600", Vehicle.BASIC);
        Lloguer lloguer = new Lloguer(vehicle, 5);
        client.getLloguers().add(lloguer);
        client.setNif("12341234B");
        client.setNom("Eugènia Salerosa Roig");
        client.setTelefon("93614214243");
        vehicle.setModel("Uno");
        vehicle.setMarca("Fiat");
        vehicle.setCategoria(Vehicle.LUXE);
        System.out.println("Client.nif " + client.getNif());
        System.out.println("Client.nom " + client.getNom());
        System.out.println("Client.telefon " + client.getTelefon());
        System.out.println("Client.conte(lloguer) " + client.getLloguers().contains(lloguer));
        System.out.println("Lloguer.dies " + lloguer.getDies());
        System.out.println("Vehicle.model " + lloguer.getVehicle().getModel());
        System.out.println("Vehicle.marca " + lloguer.getVehicle().getMarca());
        System.out.println("Vehicle.categoria " + lloguer.getVehicle().getCategoria());
    }
}
