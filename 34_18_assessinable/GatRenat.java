/*
 * Declaracio de la classe GatRenat amb propietats privades,
 * i amb setters i getters per poder treballar amb les propietats.
 * Afegim els metodes per saber la seva posicio i si es viu.
 * Metodes per a ensinistrar al Gat Renat: aixecat, seu i estirat
 * Metodes per a jugar amb les vides de Renat: mor, reviu i reviu indicant les vides
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";

    public int getVides() {
        return vides;
    }

    public void setVides(int vida) {
        if (vida >= 0)
            vides = vida;
    }

    public String getPosicio() {
        return posicio;
    }

    public void setPosicio(String pos) {

        if (pos.equals("dret")
                || pos.equals("estirat")
                || pos.equals("assegut"))
            posicio = pos;
    }

    public boolean esViu() {
        return vides > 0;
    }

    public boolean esDret() {
        return posicio.equals("dret");
    }

    public boolean esAssegut() {
        return posicio.equals("assegut");
    }

    public boolean esEstirat() {
        return posicio.equals("estirat");
    }

    public String aixecat(){
        if (!posicio.equals("dret")){
            setPosicio("dret");
            return "ja m'aixeco";
        }
        return "passo de fer res";
    }

    public String seu(){
        if (!posicio.equals("assegut")){
            setPosicio("assegut");
            return "ja m'assec";
        }
        return "passo de fer res";
    }

    public String estirat(){
        if (!posicio.equals("estirat")){
            setPosicio("estirat");
            return "ja m'estiro";
        }
        return "passo de fer res";
    }

    public String mor(){
        if(vides == 0) // Si ja estava mort
            return "...";
        if (vides > 0) // Si estava viu li treiem una vida
            vides -= 1;
        if(vides == 0) // Al treure la vida si esta mort
            return "ximpún";
        return "auch"; // Si encara esta viu
    }

    public String reviu(){
        if (vides > 0)
            return "...";
        if (vides == 0)
            vides += 1;
        return "guai!";
    }

    public String reviu(int numVides){
        if (vides > 0 || numVides < 1)
            return "...";
        if (vides == 0)
            vides += numVides;
        return "guai!";
    }

}
