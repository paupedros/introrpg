/*
 * Joc de proves unitaries de la funcionalitat que retorna un informe
 * dels lloguers d'un client
 */

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGestor {

    @Test
    public void testInforme() {
        Client demo = GestorLite.creaClientDemo();
        String esperat = 
"""
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

}