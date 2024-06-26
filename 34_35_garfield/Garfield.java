/*
 * Porgrama que conte els constructors de la classe
 * Garfield, dins d'aquests tindrem el vincle amb els constructors
 * de la super classe Gat
 */

public class Garfield extends Gat {

    public Garfield() {
        super("Garfield", 9, "estirat");
        this.setVides(9);
    }

    @Override
    public void setVides(int novesVides) {
        if (novesVides >= 0 && novesVides >= 9) {
            super.setVides(novesVides);
        }
        else super.setVides(9);
    }

    @Override
    public String aixecat() {
        if (getPosicio().equals("assegut")) {
            super.setPosicio("dret");
            return "ja m'aixeco";
        }
        if (!getPosicio().equals("assegut") && !getPosicio().equals("dret"))
            return "Bai Maitea, bai";
        return "passo de fer res";
    }

    @Override
    public String seu() {
        if (!getPosicio().equals("assegut")) {
            super.setPosicio("assegut");
            return "ja m'assec";
        }
        return "passo de fer res";
    }

    @Override
    public String estirat() {
        if (getPosicio().equals("assegut")) {
            super.setPosicio("estirat");
            return "ja m'estiro";
        }
        if (!getPosicio().equals("assegut") && !getPosicio().equals("estirat"))
            return "Bai Maitea, bai";
        return "passo de fer res";
    }
}