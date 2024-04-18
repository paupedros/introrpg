/**
 * test per probar try catch si al demanar les propietats de la especificacio a buscar
 * s'introdueixen no enters en preu i estoc
 */
public class test {

    
    public static void main(String[] args) {
        String[] properties = new String[6];
        try {
            properties = askProperties(properties);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        printArray(properties);

    }

    private static String[] askProperties(String[] properties) {
        System.out.print("nom> ");
        String nom = Entrada.readLine();
        // Si no esta buit
        if (nom.equals("!"))
            return properties;
        if (!nom.isBlank()) {
            properties[0] = nom;
        }
        // Si esta buit segueix en null

        System.out.print("preu max.> ");
        String preu = Entrada.readLine();
        // Si no esta buit
        if (!preu.isBlank()) {
            if (preu.equals("!"))
                return properties;
            if (!UtilString.esEnter(preu)) {
                throw new IllegalArgumentException("ERROR: el valor ha de ser un enter positiu");
            }
            properties[1] = preu;
        }

        System.out.print("estoc min.> ");
        String estoc = Entrada.readLine();
        // Si no esta buit
        if (!estoc.isBlank()) {
            if (estoc.equals("!"))
                return properties;
            if (!UtilString.esEnter(estoc)) {
                throw new IllegalArgumentException("ERROR: el valor ha de ser un enter positiu");
            }
            properties[2] = estoc;
        }

        System.out.print("D.O.> ");
        String origen = Entrada.readLine();
        // Si no esta buit
        if (origen.equals("!"))
            return properties;
        if (!origen.isBlank()) {
            properties[3] = origen;
        }

        System.out.print("tipus> ");
        String tipus = Entrada.readLine();
        // Si no esta buit
        if (tipus.equals("!"))
            return properties;
        if (!tipus.isBlank()) {
            properties[4] = tipus;
        }

        System.out.print("collita> ");
        String collita = Entrada.readLine();
        // Si no esta buit
        if (collita.equals("!"))
            return properties;
        if (!collita.isBlank()) {
            properties[5] = collita;
        }
        return properties;
    }

    public static void printArray(String[] array) {
        for (String element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}