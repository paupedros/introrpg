/*
 * Joc de proves unitaries de la funcionalitat que retorna un informe
 * dels lloguers d'un client
 */

/*
    cap lloguer

    BASIC
    un lloguer de vehicle de categoria bàsica per un dia
    el mateix però per 2 dies
    el mateix però per 3 dies
    el mateix però per més de 3 dies (per exemple 5)
    dos lloguers de vehicles de categoria bàsica per un dia

    GENERAL
    un lloguer general 1 dia
    mateix pero 2 dies
    mateix pero 5 dies
    dos lloguers de 1 dia

    LUXE
    un lloguer luxe de 1 dia
    lloguer més de 2 dies (bonificacio)
    2 lloguers 1 dia

    MIX
    Client amb 1 basic 1 general
    Client 1 basic 1 general 1 luxe
    Client 1 basic 4 dies 1 general 5 dies  1 luxe 3 dies

 */

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGestor {

	@Test
	public void testInforme() {
		Client demo = GestorLite.creaClientDemo();
		String esperat = """
				Informe de lloguers del client Eugènia Salinas Roig (51590695Q)
					Seat 600: 90.0€
					Tata Vista: 180.0€
					Fiat Uno: 540.0€
				Import a pagar: 810.0€
				Punts guanyats: 4
				""";
		String resultat = demo.informe();
		assertEquals(esperat, resultat);
	}

	// NONE
	@Test
	public void ClientCapLloguer() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		String esperat = """
				Informe de lloguers del client Pau (DSAGY213DS)
				Import a pagar: 0.0€
				Punts guanyats: 0
				    """;
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// BASIC

	// 1 Lloguer 1 dia
	@Test
	public void Basic1Dia() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Lloguer basic1dia = new Lloguer(basic, 1);
		client.getLloguers().add(basic1dia);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 90.0€
		Import a pagar: 90.0€
		Punts guanyats: 1
				        """;
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 Lloguer 2 dies
	@Test
	public void Basic2Dies() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Lloguer basic2dies = new Lloguer(basic, 2);
		client.getLloguers().add(basic2dies);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 90.0€
		Import a pagar: 90.0€
		Punts guanyats: 1
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 Lloguer 3 dies
	@Test
	public void Basic3Dies() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Lloguer basic3dies = new Lloguer(basic, 3);
		client.getLloguers().add(basic3dies);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 90.0€
		Import a pagar: 90.0€
		Punts guanyats: 1
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 Lloguer 5 dies
	@Test
	public void Basic5Dies() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Lloguer basic5dies = new Lloguer(basic, 5);
		client.getLloguers().add(basic5dies);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 180.0€
		Import a pagar: 180.0€
		Punts guanyats: 1
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 2 Lloguers 1 dia
	@Test
	public void Basic2Lloguers1Dia() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Vehicle basic2 = new Vehicle("Fiat", "Multipla", 1);
		Lloguer basic1dia = new Lloguer(basic, 1);
		Lloguer basic1diaDiff = new Lloguer(basic2, 1);
		client.getLloguers().add(basic1dia);
		client.getLloguers().add(basic1diaDiff);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 90.0€
			Fiat Multipla: 90.0€
		Import a pagar: 180.0€
		Punts guanyats: 2
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// General

	// 1 Lloguer 1 dia
	@Test
	public void General1Dia() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle general = new Vehicle("Honda", "Civic EK", 2);
		Lloguer general1dia = new Lloguer(general, 1);
		client.getLloguers().add(general1dia);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			Honda Civic EK: 120.0€
		Import a pagar: 120.0€
		Punts guanyats: 1
				""";;
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 Lloguer 2 dies
	@Test
	public void General2Dies() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle general = new Vehicle("Honda", "Civic EK", 2);
		Lloguer general2dies = new Lloguer(general, 2);
		client.getLloguers().add(general2dies);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			Honda Civic EK: 120.0€
		Import a pagar: 120.0€
		Punts guanyats: 1
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 Lloger 5 dies
	@Test
	public void General5Dies() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle general = new Vehicle("Honda", "Civic EK", 2);
		Lloguer general5dies = new Lloguer(general, 5);
		client.getLloguers().add(general5dies);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			Honda Civic EK: 345.0€
		Import a pagar: 345.0€
		Punts guanyats: 1
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 2 Lloguers 1 dia
	@Test
	public void General2Lloguers1Dia() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle general = new Vehicle("Honda", "Civic EK", 2);
		Vehicle general2 = new Vehicle("Renault", "Scnenic", 2);
		Lloguer general1dia = new Lloguer(general, 1);
		Lloguer general1diaDiff = new Lloguer(general2, 1);
		client.getLloguers().add(general1dia);
		client.getLloguers().add(general1diaDiff);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			Honda Civic EK: 120.0€
			Renault Scnenic: 120.0€
		Import a pagar: 240.0€
		Punts guanyats: 2
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// LUXE

	// 1 Lloguer 1 dia
	@Test
	public void Luxe1Dia() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle luxe = new Vehicle("Toyota", "Yaris GR", 3);
		Lloguer luxe1dia = new Lloguer(luxe, 1);
		client.getLloguers().add(luxe1dia);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			Toyota Yaris GR: 180.0€
		Import a pagar: 180.0€
		Punts guanyats: 1
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 Lloguer 5 dies
	@Test
	public void Luxe5Dies() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle luxe = new Vehicle("Toyota", "Yaris GR", 3);
		Lloguer luxe5dies = new Lloguer(luxe, 5);
		client.getLloguers().add(luxe5dies);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			Toyota Yaris GR: 900.0€
		Import a pagar: 900.0€
		Punts guanyats: 2
				""";;
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 2 Lloguers 1 dia
	@Test
	public void Luxe2Lloguers1Dia() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle luxe = new Vehicle("Toyota", "Yaris GR", 3);
		Vehicle luxe2 = new Vehicle("VW", "Golf", 3);
		Lloguer luxe1dia = new Lloguer(luxe, 1);
		Lloguer luxe1diaDiff = new Lloguer(luxe2, 1);
		client.getLloguers().add(luxe1dia);
		client.getLloguers().add(luxe1diaDiff);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			Toyota Yaris GR: 180.0€
			VW Golf: 180.0€
		Import a pagar: 360.0€
		Punts guanyats: 2
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// MIX

	// 1 Basic 1 General 1 dia
	@Test
	public void Basic1General1Dia() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Vehicle general = new Vehicle("Honda", "Civic EK", 2);
		Lloguer basic1dia = new Lloguer(basic, 1);
		Lloguer general1dia = new Lloguer(general, 1);
		client.getLloguers().add(basic1dia);
		client.getLloguers().add(general1dia);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 90.0€
			Honda Civic EK: 120.0€
		Import a pagar: 210.0€
		Punts guanyats: 2
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 Basic 1 General 1 Luxe
	@Test
	public void Basic1General1Luxe() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Vehicle general = new Vehicle("Honda", "Civic EK", 2);
		Vehicle luxe = new Vehicle("Toyota", "Yaris GR", 3);
		Lloguer basic1dia = new Lloguer(basic, 1);
		Lloguer general1dia = new Lloguer(general, 1);
		Lloguer luxe1dia = new Lloguer(luxe, 1);
		client.getLloguers().add(basic1dia);
		client.getLloguers().add(general1dia);
		client.getLloguers().add(luxe1dia);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 90.0€
			Honda Civic EK: 120.0€
			Toyota Yaris GR: 180.0€
		Import a pagar: 390.0€
		Punts guanyats: 3
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	// 1 basic 4 dies 1 general 5 dies  1 luxe 3 dies
	@Test
	public void Basic4Dies1General5Dies1Luxe3Dies() {
		Client client = new Client("DSAGY213DS", "Pau", "8327923");
		Vehicle basic = new Vehicle("seat", "600", 1);
		Vehicle general = new Vehicle("Honda", "Civic EK", 2);
		Vehicle luxe = new Vehicle("Toyota", "Yaris GR", 3);
		Lloguer basic4dies = new Lloguer(basic, 4);
		Lloguer general5dies = new Lloguer(general, 5);
		Lloguer luxe3dies = new Lloguer(luxe, 3);
		client.getLloguers().add(basic4dies);
		client.getLloguers().add(general5dies);
		client.getLloguers().add(luxe3dies);
		String esperat = """
		Informe de lloguers del client Pau (DSAGY213DS)
			seat 600: 135.0€
			Honda Civic EK: 345.0€
			Toyota Yaris GR: 540.0€
		Import a pagar: 1020.0€
		Punts guanyats: 4
				""";
		String result = client.informe();
		assertEquals(esperat, result);
	}

	@Test
	public void informeHTMLDemo() {
		Client client = GestorLite.creaClientDemo();
		String result = client.informeHTML();
		String esperat = """
			<p>Informe de lloguers del client <em>Eugènia Salinas Roig</em> (<strong>51590695Q</strong>)</p>
			<table>
			  <tr>
				<td><strong>Marca</strong></td>
				<td><strong>Model</strong></td>
				<td><strong>Import</strong></td>
			  </tr>
			  <tr><td>Seat</td><td>600</td><td>90.0€</td></tr>
			  <tr><td>Tata</td><td>Vista</td><td>180.0€</td></tr>
			  <tr><td>Fiat</td><td>Uno</td><td>540.0€</td></tr>
			</table>
			<p>Import a pagar: <em>810.0€</em></p>
			<p>Punts guanyats: <em>4</em></p>
				""";
		assertEquals(esperat, result);
	}

}
