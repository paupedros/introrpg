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

    public int getDies() {
        return dies;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setDies(int dies) {
        this.dies = dies;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double quantitat() {
        double quantitat = 0;
        switch (vehicle.getCategoria()) {
            case Vehicle.BASIC:
                quantitat += 3;
                if (dies > 3) {
                    quantitat += (dies - 3) * 1.5;
                }
                break;
            case Vehicle.GENERAL:
                quantitat += 4;
                if (dies > 2) {
                    quantitat += (dies - 2) * 2.5;
                }
                break;
            case Vehicle.LUXE:
                quantitat += dies * 6;
                break;
        }
        return quantitat;
    }

}
