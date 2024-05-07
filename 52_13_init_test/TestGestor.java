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
        String esperat = demo.informe();
        String resultat = demo.informe();
        assertEquals(esperat, resultat);
    }

}