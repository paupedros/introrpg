/*
 * Classe Lloguer: contindra informacio sobre un lloguer de vehicle, amb
 * la informacio del vehicle i el nombre de dies de lloguer
 */

public class Lloguer {
    private int dies;
    private Vehicle vehicle;

    Lloguer(Vehicle vehicle, int dies) {
        this.dies = dies;
        this.vehicle = vehicle;
    }

    public int getDies() { return dies; }
    public Vehicle getVehicle() { return vehicle; }

    public void setDies(int dies) { this.dies = dies; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    
}
