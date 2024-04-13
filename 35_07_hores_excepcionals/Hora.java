/*
 * Ampliacio de la classe hora implementant el concepte de duplicacio
 * de classes
 */

public class Hora {
    private int hores = 0;
    private int minuts = 0;
    private int segons = 0;

    public Hora() throws Exception {
        this(0, 0, 0);
    }

    public Hora(int hores, int minuts, int segons) throws Exception {
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

    public void setHores(int hores) throws Exception {
        if (hores>=0 && hores<24) {
            this.hores=hores;
        } else {
            throw new Exception("hores fora de rang: " + hores);
        }
    }

    public void setMinuts(int minuts) throws Exception {
        if (minuts >= 0 && minuts < 60) {
            this.minuts = minuts;
        } else {
            throw new Exception("minuts fora de rang: " + minuts);
        }
    }

    public void setSegons(int segons) throws Exception {
        if (segons >= 0 && segons < 60) {
            this.segons = segons;
        } else {
            throw new Exception("segons fora de rang: " + segons);
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