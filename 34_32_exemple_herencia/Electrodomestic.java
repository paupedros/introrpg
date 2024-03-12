/**
 * Exemple d'herencia d'electrodomestics, d'ell penjen diferents
 * subclasses com rentadora, rentaplats, etc...
 */
public class Electrodomestic {
    private String marca;
    private String model;
    private boolean ences = false;

    public Electrodomestic(String marca, String model) {
        this.marca = marca;
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public boolean estaEnces() {
        return ences;
    }

    public void encendre() {
        if (!estaEnces())
            ences = true;
    }

    public void apagar() {
        if (estaEnces())
            ences = false;
    }

    public static void main(String[] args) {
        Rentadora rentadora = new Rentadora("Samsung", "BC34A");
        Rentaplats rentaplats = new Rentaplats("Philips", "B342A", 'B');

        System.out.println("Encenem la rentadora:");
        System.out.println("Marca de la rentadora: " + rentadora.getMarca());
        rentadora.encendre();
        System.out.println("Rentadora encesa: " + rentadora.estaEnces());
        rentadora.centrifugar();

        System.out.println("\nAra, encendrem el rentaplats:");
        System.out.println("Marca del rentaplats: " + rentaplats.getMarca());
        rentaplats.encendre();
        System.out.println("Eficiència del rentaplats: " + rentaplats.getEficiencia());
        rentaplats.neteja();
        rentaplats.apagar();
        System.out.println("El rentaplats està apagat: " + !rentaplats.estaEnces());

    }

}

class Rentadora extends Electrodomestic {
    private int rpm = 0;

    public Rentadora(String marca, String model) {
        super(marca, model);
    }

    public void centrifugar() {
        System.out.println("Centrifugant a 3600 revolucions");
        rpm = 3600;
    }

    public int getRpm() {
        return rpm;
    }
}

class Rentaplats extends Electrodomestic {
    private char eficiencia;

    public Rentaplats(String marca, String model, char eficiencia) {
        super(marca, model);
        this.eficiencia = eficiencia;
    }

    public char getEficiencia() {
        return eficiencia;
    }

    public void neteja() {
        System.out.println("Netejant plats...");
    }

}
