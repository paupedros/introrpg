/*
 * Classe que defineix el comportament i propietats Punt, utilitzada
 * per aprendre a fer proves unitaries amb JUnit
 */

public class Punt {
    private int[] coord = {0, 0};
    private int x = coord[0];
    private int y = coord[1];

    public Punt(){
        x = 0;
        y = 0;
    }

    public Punt(int x, int y) {
        if (x < 0) throw new IllegalArgumentException();
        if (y < 0) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY(){ return y; }

    public void setX(int x) {
        if (x < 0) throw new IllegalArgumentException();
        this.x = x;
    }
    public void setY(int y) {
        if (y < 0) throw new IllegalArgumentException();
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
