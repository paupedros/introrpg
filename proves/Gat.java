public class Gat {
    private Enums enums = Enums.INDIFERENT;
    Gat(Enums enums){
        this.enums = enums;
    }

    public static void main(String[] args) {
        Enums enums = Enums.HOLA;
        Gat gat = new Gat(enums);
    }
}

