/*
 * Classe UllDeGat que afegira els ulls al gat renat, 
 * amb metodes que ens indiquen si esta obert l'ull o esta tancat,
 * el podem obrir i tancar
 */

public class UllDeGat {

    private boolean estat = false;

    public UllDeGat() {
        this(false);
    }

    public UllDeGat(boolean obert) {
        this.estat = obert;
    }

    public void obret() {
        this.estat = true;
    }

    public void tancat() {
        this.estat = false;
    }

    public boolean esObert(){
        return this.estat;
    }
}
