/*
 * Classe que defineix el comportament i propietats Punt, utilitzada
 * per aprendre a fer proves unitaries amb JUnit
 */

public class Punt {
    private int x = 0;
    private int y = 0;

    public Punt(){
        x = 0;
        y = 0;
    }

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY(){ return y; }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void suma(Punt p) { x+=p.x; y+=p.y; }

    @Override
    public String toString() {
        return String.format("Punt(%d, %d)", x, y);
    }

    public boolean equals(Punt p) {
        // Retorna true si les coordenades son iguals
        return x == p.getX() && y == p.getY();
    }
}
