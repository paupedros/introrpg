/*
 * Classe que defineix el comportament i propietats Punt, utilitzada
 * per aprendre a fer proves unitaries amb JUnit
 */

public class Punt {
    private int[] coord = {0, 0};

    public Punt(){
        coord[0] = 0;
        coord[1] = 0;
    }

    public Punt(int x, int y) {
        this.coord[0] = x;
        this.coord[1] = y;
    }

    public int getX() { return coord[0]; }
    public int getY(){ return coord[1]; }

    public void setX(int x) {
        this.coord[0] = x;
    }
    public void setY(int y) {
        this.coord[1] = y;
    }

    public void suma(Punt p) { coord[0]+=p.coord[0]; coord[1]+=p.coord[1]; }

    @Override
    public String toString() {
        return String.format("Punt(%d, %d)", coord[0], coord[1]);
    }

    public boolean equals(Punt p) {
        // Retorna true si les coordenades son iguals
        return coord[0] == p.getX() && coord[1] == p.getY();
    }
}
