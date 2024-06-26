/*
 * Codi per probar les funcionalitats de les excepcions dels setters a les hores,
 * en aquest cas utilitzem Illegal Argument Exception, per indicar que hem posat malament
 * un argument
 */

 public class UsaHora {
    public static void main(String[] args) {
        System.out.println("Intentarem crear una hora amb valors no vàlids");
        try {
            Hora hora = new Hora(-1, 1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Argument il·legal!");
        }
    }
}