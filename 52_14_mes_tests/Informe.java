public class Informe {
    public static void main(String[] args) {
        Client client = new Client("DSAGY213DS", "Pau", "8327923");
        Vehicle basic = new Vehicle("seat", "600", 1);
        Vehicle basic2 = new Vehicle("Fiat", "Multipla", 1);
        Vehicle general = new Vehicle("Honda", "Civic EK", 2);
        Vehicle general2 = new Vehicle("Renault", "Scnenic", 2);
        Vehicle luxe = new Vehicle("Toyota", "Yaris GR", 3);
        Vehicle luxe2 = new Vehicle("VW", "Golf", 3);

        // Lloguers basics
        Lloguer basic1dia = new Lloguer(basic, 1);
        Lloguer basic1diaDiff = new Lloguer(basic2, 1);
        Lloguer basic2dies = new Lloguer(basic, 2);
        Lloguer basic3dies = new Lloguer(basic, 3);
        Lloguer basic4dies = new Lloguer(basic, 4);
        Lloguer basic5dies = new Lloguer(basic, 5);

        //Lloguers Generals
        Lloguer general1dia = new Lloguer(general, 1);
        Lloguer general1diaDiff = new Lloguer(general2, 1);
        Lloguer general2dies = new Lloguer(general, 2);
        Lloguer general5dies = new Lloguer(general, 5);

        // Lloguers Luxes
        Lloguer luxe1dia = new Lloguer(luxe, 1);
        Lloguer luxe1diaDiff = new Lloguer(luxe2, 1);
        Lloguer luxe3dies = new Lloguer(luxe, 3);
        Lloguer luxe5dies = new Lloguer(luxe, 5);


        client.getLloguers().add(basic4dies);
		client.getLloguers().add(general5dies);
		client.getLloguers().add(luxe3dies);
        System.out.println(client.informe());
    }
}
