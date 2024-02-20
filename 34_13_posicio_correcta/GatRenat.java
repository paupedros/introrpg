/*
 * Declaracio de la classe GatRenat amb propietats privades,
 * i amb setters i getters per poder treballar amb les propietats.
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";

    public int getVides(){
        return vides;
    }

    public void setVides(int vida){
        if (vida >= 0)
            vides = vida;
    }

    public String getPosicio(){
        return posicio;
    }

    public void setPosicio(String pos){
        String posicions = "estirat,dret,assegut";
        if (posicions.contains(pos))
            posicio = pos;
    }


}
