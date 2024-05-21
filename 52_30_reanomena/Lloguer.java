/*
 * Classe Lloguer: contindra informacio sobre un lloguer de vehicle, amb
 * la informacio del vehicle i el nombre de dies de lloguer
 */

public class Lloguer {
    private int dies;
    private Vehicle vehicle;
    private static final int QUANTITAT_BASIC = 3;
    private static final int DIES_BASIC = 3;
    private static final double MULT_BASIC = 1.5;

    private static final int QUANTITAT_GENERAL = 4;
    private static final int DIES_GENERAL = 2;
    private static final double MULT_GENERAL = 2.5;

    private static final int QUANTITAT_LUXE = 6;

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

    public double calculaPreuLloguer() {
        double preu = 0;
        switch (vehicle.getCategoria()) {
            case Vehicle.BASIC:
                preu += QUANTITAT_BASIC;
                if (dies > DIES_BASIC) {
                    preu += (dies - DIES_BASIC) * MULT_BASIC;
                }
                break;
            case Vehicle.GENERAL:
                preu += QUANTITAT_GENERAL;
                if (dies > DIES_GENERAL) {
                    preu += (dies - DIES_GENERAL) * MULT_GENERAL;
                }
                break;
            case Vehicle.LUXE:
                preu += dies * QUANTITAT_LUXE;
                break;
        }
        return preu;
    }

    public int bonificacions() {
        if (vehicle.getCategoria() == Vehicle.LUXE &&
                    dies > 1) {
                return 2;
        }
        return 1;
    }

}
