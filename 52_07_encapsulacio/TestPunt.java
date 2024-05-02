/*
 * Classe a la que anirem inserint els diferents test unitaris per a la classe
 * Punt.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPunt {
    @Test
    public void constructor() {
        // comprova que Punt() pugui ser cridat
        new Punt();
    }

    @Test
    public void constructorDefecteXZero() {
        // comprova que Punt() deixi a 0 la propietat x de Punt
        Punt p = new Punt();
        assertEquals(0, p.getX());
    }

    @Test
    public void constructorDefecteYZero() {
        // Comprova que Punt() deixi 0 a la propietat y de Punt
        Punt p = new Punt();
        assertEquals(0, p.getY());
    }

    @Test
    public void setX42(){
        Punt p = new Punt();
        p.setX(42);
        assertEquals(42, p.getX());
    }

    @Test
    public void setY42(){
        // Comprova que el setter deixi la propietat amb el valor esperat
        Punt p = new Punt();
        p.setY(42);
        assertEquals(42, p.getY());
    }

    @Test
    public void constructorXY(){
        Punt p = new Punt(42, 42);
        assertEquals(42, p.getX());
        assertEquals(42, p.getY());
    }

    @Test
    public void suma(){
        Punt p1 = new Punt(3,2);
        Punt p2 = new Punt(4,5);
        p1.suma(p2);
        assertEquals(7, p1.getX());
        assertEquals(7, p1.getY());
    }
}