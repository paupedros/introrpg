/**
 * testCerca
 */
public class testCerca {

    public static void main(String[] args) {
        Botiga botiga = new Botiga(1);
        Vi vi = new Vi("Roura Blanc", 1234, 42);
        botiga.afegeix(vi);
        System.out.println(botiga.cerca("Roura Blanc"));
    }
}