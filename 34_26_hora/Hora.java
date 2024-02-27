/**
 * Hora
 */
public class Hora {
    private int hores = 0;
    private int minuts = 0;
    private int segons = 0;

    public Hora(){
        this(0,0,0);
    }

    public Hora(int hores, int minuts, int segons){
        if (hores < 0 || minuts < 0 || segons < 0){
            hores = 0;
            minuts = 0;
            segons = 0;
        }
        setHores(hores);
        setMinuts(minuts);
        setSegons(segons);
    }

/* -------------------------------------------------------------------------- */
/*                              GETTERS & SETTERS                             */
/* -------------------------------------------------------------------------- */

    public int getHores(){
        return hores;
    }

    public int getMinuts(){
        return minuts;
    }

    public int getSegons(){
        return segons;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public void setMinuts (int minuts) {
        this.minuts = minuts;
    }

    public void setSegons(int segons) {
        this.segons = segons;
    }

/* -------------------------------------------------------------------------- */
/*                           INCREMENTA I DECREMENTA                          */
/* -------------------------------------------------------------------------- */
    public void incrementa(){
        if (getSegons() == 59){ // Si estem a 59 segons pasem a 0
            setSegons(0);
            if(getMinuts() == 59){
                setMinuts(0);
                if (getHores() == 23){
                    setHores(0);
                }
                else hores++;
            }
            else minuts++;
        }
        else segons++;
    }

    public void incrementa(int segons) {
        this.segons += segons;
    }

    public void decrementa() {
        if (getSegons() == 0){
            setSegons(59);
            if (getMinuts() == 0){
                setMinuts(59);
                if(getHores() == 0){
                    setHores(23);
                }
                else hores--;
            }
            else minuts--;
        }
        else segons--;
    }

    public void decrementa(int segons) {
        if (getSegons() == 0){
            setSegons(59);
            if (getMinuts() == 0){
                setMinuts(59);
                if(getHores() == 0){
                    setHores(23);
                }
                else hores--;
            }
            else minuts--;
        }
        else this.segons -= segons;
    }

    public int compareTo(Hora hora){
        // Obtenim la hora en segons
        int hora1Num = (this.getHores())*3600 + (this.getMinuts())*60 + this.getSegons();
        int hora2Num = (hora.getHores())*3600 + (hora.getMinuts())*60 + hora.getSegons();
        if (hora1Num < hora2Num) return -1;
        if (hora2Num < hora1Num) return 1;
        return 0;
    }

    @Override
    public String toString(){
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }


    /**
     * Compara dues hores i retorna l'operador corresponent
     * Per exemple, si hora1 és menor que hora2, l'operador serà "<". Els
     * altres dos valors possibles són ">" i "=="
     *
     * @param hora1: primera hora a comparar
     * @param hora2: segona hora a comparar
     * @return operador resultant
     */
    private static String composaOperadorComparacio(Hora hora1, Hora hora2) {
        int comparacio = hora1.compareTo(hora2);
        if (comparacio < 0) {
            return "<";
        } else if (comparacio > 0) {
            return ">";
        } else {
            return "==";
        }
    }

    public static void main(String[] args) {
        Hora hora1 = new Hora();
        Hora hora2 = new Hora(0, 0, 2);
        System.out.printf("Inicialment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);
        System.out.println("Incrementem 1 segon a la primera i decrementem 1 segon a la segona");
        hora1.incrementa();
        hora2.decrementa();
        System.out.printf("Finalment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);

    }
}