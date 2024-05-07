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