/*
 * Ampliacio de la classe hora implementant el concepte de duplicacio
 * de classes
 */

public class Hora {
    private int hores = 0;
    private int minuts = 0;
    private int segons = 0;

    public Hora() {
        this(0, 0, 0);
    }

    public Hora(int hores, int minuts, int segons) {
        if ((hores < 0 || hores > 23)
                || (minuts < 0 || minuts > 59)
                || (segons < 0 || segons > 59)) {
            hores = 0;
            minuts = 0;
            segons = 0;
        }
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

    public void setHores(int hores) {
        this.hores = hores;
    }

    public void setMinuts(int minuts) {
        this.minuts = minuts;
    }

    public void setSegons(int segons) {
        this.segons = segons;
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

    public Hora duplica(){
        Hora newHora = new Hora(this.getHores(), this.getMinuts(), this.getSegons());
        return newHora;
    }

    public static Hora duplica(Hora hora){
        Hora newHora = new Hora(hora.getHores(), hora.getMinuts(), hora.getSegons());
        return newHora;
    }

    public static int compareTo(Hora hora1, Hora hora2) {
        // Obtenim la hora en segons
        int hora1Num = (hora1.getHores()) * 3600 + (hora1.getMinuts()) * 60 + hora1.getSegons();
        int hora2Num = (hora2.getHores()) * 3600 + (hora2.getMinuts()) * 60 + hora2.getSegons();
        if (hora1Num < hora2Num)
            return -1;
        if (hora2Num < hora1Num)
            return 1;
        return 0;
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

    public int compareTo(Hora hora) {
        // Obtenim la hora en segons
        int hora1Num = (this.getHores()) * 3600 + (this.getMinuts()) * 60 + this.getSegons();
        int hora2Num = (hora.getHores()) * 3600 + (hora.getMinuts()) * 60 + hora.getSegons();
        if (hora1Num < hora2Num)
            return -1;
        if (hora2Num < hora1Num)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }

    public void decrementa() {
        if (getSegons() == 0) {
            setSegons(59);
            if (getMinuts() == 0) {
                setMinuts(59);
                if (getHores() == 0) {
                    setHores(23);
                } else
                    hores--;
            } else
                minuts--;
        } else
            segons--;
    }

    public void incrementa() {
        if (getSegons() == 59) { // Si estem a 59 segons pasem a 0
            setSegons(0);
            if (getMinuts() == 59) {
                setMinuts(0);
                if (getHores() == 23) {
                    setHores(0);
                } else
                    hores++;
            } else
                minuts++;
        } else
            segons++;
    }

    public void incrementa(int segons) {
        if (segons < 0)
            decrementa(segons * -1);
        else {
            int diesInc = 0;
            int horesInc = 0;
            int minutsInc = 0;

            // Passar hora actual a segons
            int minutsAra = this.minuts * 60;
            int horesAra = this.hores * 3600;
            int segonsAra = minutsAra + horesAra + this.segons;

            // Calcul de segons total de les hores
            int segonsInc = segons + segonsAra;

            // Passar de segons a hores, minuts i segons adequadament
            while (segonsInc > 59) {
                segonsInc -= 60;
                minutsInc++;
            }
            while (minutsInc > 59) {
                minutsInc -= 60;
                horesInc++;
            }
            while (horesInc > 23) {
                horesInc -= 24;
                diesInc++;
            }

            this.segons = segonsInc;
            this.minuts = minutsInc;
            this.hores = horesInc;

            System.out.println(
                    String.format("dies: %d hores: %d minuts: %d segons: %d", diesInc, horesInc, minutsInc, segonsInc));
        }

    }

    public void decrementa(int segons) {
        if (segons < 0)
            incrementa(segons * -1);
        else {
            // Passar hora actual a segons
            int segonsAra = this.hores * 3600 + this.minuts * 60 + this.segons;

            if (segonsAra == 0) {
                decrementa();
                decrementa(segons - 1);
            }
            else {

                // Calcul de segons total de les hores
                int segonsTotal = 0;
                if (segonsAra > segons) {
                    segonsTotal = segonsAra - segons;
                } else
                    segonsTotal = segons - segonsAra;

                // Calcular días
                int diesDec = segonsTotal / 86400; // 86400 segundos en un día
                // Calcular horas restantes
                int segonsRestants = segonsTotal % 86400;
                int horesDec = segonsRestants / 3600; // 3600 segundos en una hora
                // Calcular minutos restantes
                int minutsDec = (segonsRestants % 3600) / 60; // 60 segundos en un minuto
                // Calcular segundos restantes
                int segonsDec = segonsRestants % 60;

                System.out.println(
                        String.format("dies: %d hores: %d minuts: %d segons: %d", diesDec, horesDec, minutsDec, segonsDec));

                this.segons = segonsDec;
                this.minuts = minutsDec;
                this.hores = horesDec;
            }
        }
    }

    public static void main(String[] args) {
        Hora hora1 = new Hora(0, 0, 0);
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