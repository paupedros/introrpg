/*
 * Codi que posa a prova el EnvoltaString que retornara true
 * si dues Strings son iguals sense distingir entre majuscules ni minuscules
 * 
 * Explicacio nota:
 * Quan estem comparant nom1 estem comparant un String amb una instancia d'un objecte que no te res
 * a veure amb String (són dos classes diferents). 
 * Al inreves seria al contrari, podria donar true ja que el equals de EnvoltaString
 * permet Strings.
 * El equals del String no es pot sobreescriure (Override) ja que, la classe
 * String es una classe final i no es pot modificar el seu contingut.
 */
 public class UsaEnvoltaString {
    public static void main(String[] args) {
        String nom1 = "Renat";
        String nom2 = args.length > 0 ? args[0] : "nom per defecte";
        System.out.printf("\"%s\".equals(\"%s\") -> %b%n", nom1, nom2, nom1.equals(nom2));

        EnvoltaString envoltaNom1 = new EnvoltaString(nom1);
        EnvoltaString envoltaNom2 = new EnvoltaString(nom2);
        System.out.printf("%s.equals(%s) -> %b%n", envoltaNom1, envoltaNom2, envoltaNom1.equals(envoltaNom2));
        System.out.printf("%s.equals(\"%s\") -> %b%n", envoltaNom1, nom2, envoltaNom1.equals(nom2));
        System.out.printf("\"%s\".equals(%s) -> %b%n", nom1, envoltaNom2, nom1.equals(envoltaNom2));
    }
}