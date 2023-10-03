/*
 * Aquest programa demana el nom i el primer cognom als usuaris
 * i els mostra un missatge amistós.
 *
 * El programa no controla valors no adequats d'entrada
 */
public class NomCognom {
    public static void main(String[] args) {

        // obté el nom
        System.out.println("Nom?");
        String nom = Entrada.readLine();


        // obté el cognom
        System.out.println("Cognom?");
        String cognom = Entrada.readLine();

        // Mostra resultat
        System.out.println("Ei " + nom + ", tinc una amiga que també és " +  cognom);
    }
}

