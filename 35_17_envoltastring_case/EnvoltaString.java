/*
 * Retornara true si les dues strings son iguals ignorant majuscules i minuscules
 */

public class EnvoltaString {
    private String valor;

    public EnvoltaString(String valor) { this.valor = valor; }
    public String toString() { return String.format("ENVOLTAT(\"%s\")", valor); }

    public boolean equals(EnvoltaString altre) {
        return valor.equalsIgnoreCase(altre.valor);
    }

    public static void main(String[] args) {
        String nom1 = "Renat";
        String nom2 = new String("Renat");
        System.out.printf("\"%s\" == \"%s\" -> %b%n", nom1, nom2, nom1 == nom2);
        System.out.printf("\"%s\".equals(\"%s\") -> %b%n", nom1, nom2, nom1.equals(nom2));

        EnvoltaString envoltaNom1 = new EnvoltaString(nom1);
        EnvoltaString envoltaNom2 = new EnvoltaString(nom2);
        System.out.printf("%s == %s -> %b%n", envoltaNom1, envoltaNom2, envoltaNom1 == envoltaNom2);
        System.out.printf("%s.equals(%s) -> %b%n", envoltaNom1, envoltaNom2, envoltaNom1.equals(envoltaNom2));
    }
}