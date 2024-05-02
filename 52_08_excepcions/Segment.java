/*
 * Classe que engloba dos instancies de Punt, ens definira un segment
 */

import java.lang.Math;

public class Segment {
    private Punt p1 = null;
    private Punt p2 = null;

    Segment() {
        p1 = new Punt();
        p2 = new Punt();
    }

    Segment(Punt p1, Punt p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punt getP1() {return p1;}

    public void setP1(Punt p) {
        this.p1 = p;
    }

    public Punt getP2() {return p2;}
    
    public void setP2(Punt p) {
        this.p2 = p;
    }

    public Double longitud(){
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    @Override
    public String toString(){
        return String.format("Segment(%s, %s)", p1, p2);
    }
}
