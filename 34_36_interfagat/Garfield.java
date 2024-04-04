/*
 * Implementacio de la classe Garfield que implementa Animal de companyia i es un Gat
 */

public class Garfield extends Gat implements AnimalDeCompanyia{
    Garfield(){
        super("Garfield");
    }
    @Override
    public String deixatEstimar(){
        return "em deixo estimar, però només una mica";
    }
    
}