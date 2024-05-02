/*
 * Joc de Proves per a anar testejant les funcionalitats de la classe
 * Segment que contindra un segment de dos punts
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSegment {

    @Test
    public void constructorEspecific() {
        // comprova que Segment() pugui ser cridat amb els dos punts
        Punt p1 = new Punt();
        Punt p2 = new Punt();
        new Segment(p1, p2);
    }

    // @Test
    // public void getP1() {
    //     Punt p1 = new Punt();
    //     Punt p2 = new Punt();
    //     Segment s = new Segment(p1, p2);
    //     assertEquals(p1, s.getP1());
    // }

    // @Test
    // public void setP1() {
    //     Punt p1 = new Punt();
    //     Punt p2 = new Punt();
    //     Segment s = new Segment(p1, p2);
    //     Punt p3 = new Punt(3, 1);
    //     s.setP1(p3);
    //     assertEquals(p3, s.getP1());
    // }

    // @Test
    // public void getP2() {
    //     Punt p1 = new Punt();
    //     Punt p2 = new Punt();
    //     Segment s = new Segment(p1, p2);
    //     assertEquals(p2, s.getP2());
    // }

    // @Test
    // public void setP2() {
    //     Punt p1 = new Punt();
    //     Punt p2 = new Punt();
    //     Segment s = new Segment(p1, p2);
    //     Punt p3 = new Punt(3, 1);
    //     s.setP2(p3);
    //     assertEquals(p3, s.getP2());
    // }

    @Test
    public void constructor() {
        Segment s = new Segment();
        assertAll(
                // Comprova que els punts del segment son punts per defecte
                () -> assertEquals(true, s.getP1().equals(new Punt())),
                () -> assertEquals(true, s.getP2().equals(new Punt()))
        );
    }

    @Test
    public void longitud() {
        Segment s = new Segment(new Punt(2, 3), new Punt(4, 5));
        assertEquals(2.83, s.longitud(), 0.01d);
    }

}