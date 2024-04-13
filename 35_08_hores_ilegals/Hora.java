/*
 * Ampliacio de la classe hora implementant el concepte de duplicacio
 * de classes
 */

public class Hora {
    private int hores = 0;
    private int minuts = 0;
    private int segons = 0;

    public Hora() {
        this.hores = 0;
        this.minuts = 0;
        this.segons = 0;
    }

    public Hora(int hores, int minuts, int segons) throws IllegalArgumentException {
        setHores(hores);
        setMinuts(minuts);
        setSegons(segons);
    }

    /* -------------------------------------------------------------------------- */
    /* GETTERS & SETTERS */
    /* -------------------------------------------------------------------------- */

    public int getHores() {
        return hores;
    }

    public int getMinuts() {
        return minuts;
    }

    public int getSegons() {
        return segons;
    }

    public void setHores(int hores) throws IllegalArgumentException {
        if (hores>=0 && hores<24) {
            this.hores=hores;
        } else {
            throw new IllegalArgumentException("hores fora de rang: " + hores);
        }
    }

    public void setMinuts(int minuts) throws IllegalArgumentException {
        if (minuts >= 0 && minuts < 60) {
            this.minuts = minuts;
        } else {
            throw new IllegalArgumentException("minuts fora de rang: " + minuts);
        }
    }

    public void setSegons(int segons) throws IllegalArgumentException {
        if (segons >= 0 && segons < 60) {
            this.segons = segons;
        } else {
            throw new IllegalArgumentException("segons fora de rang: " + segons);
        }
    }

    public static boolean esValida(int hora, int minuts, int segons){
        if(hora > 23 || hora < 0)
            return false;
        if (minuts > 59 || minuts < 0)
            return false;
        if (segons > 59 || segons < 0)
            return false;

        return true;
    }


    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }
    
}