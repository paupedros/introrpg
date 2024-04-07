/**
 * Implementacio de la classe Entorn que contindra la botiga i la
 * interficie amb la cual l'usuari podra manejar la seva botiga
 */

public class Entorn {
    private final Botiga botiga = new Botiga();

    public static void main(String[] args) {
        Entorn entorn = new Entorn();
        mostraBenvinguda();
        while (true) {
            mostraPrompt();
            String comanda = Entrada.readLine().strip();
            if (comanda.isEmpty())
                continue;
            if (comanda.equals("surt"))
                break;
            switch (comanda) {
                case "ajuda":
                    mostraAjuda();
                    break;
                case "afegeix":
                    entorn.processaAfegeix();
                    break;
                case "cerca":
                    entorn.processaCerca();
                    break;
                case "modifica":
                    entorn.processaModifica();
                    break;
                case "elimina":
                    entorn.processaElimina();
                    break;
                default:
                    mostraErrorComandaDesconeguda();
            }
        }
        mostraComiat();
    }

    /* ---- PROCESSAMENT ---- */

    public void processaAfegeix() {
        // ---- NOM ----
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank())
            return;

        // ---- PREU ----
        System.out.print("preu (en cèntims)> ");
        int preu = tractaDades(Entrada.readLine());
        // Si no es un enter sera -1
        if (preu == -1)
            return;

        // ---- ESTOC ----
        System.out.print("estoc (enter sense estoc)> ");
        int estoc = tractaDades(Entrada.readLine());
        // Si no es un enter sera -1
        if (estoc == -1)
            return;

        // Afegim el vi a la botiga
        Vi newVi = botiga.afegeix(new Vi(nom, preu, estoc));
        if (newVi == null) {
            System.out.println("ERROR: no s'ha pogut afegir");
            return;
        }
        System.out.println(String.format("Introduït:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", nom, preu, estoc));
    }

    public void processaCerca(){
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank())
            return;
        Vi vi = botiga.cerca(nom);
        // Si no es troba el vi
        if(vi == null) {
            System.out.println("No trobat");
            return;
        }
        // Si es troba el vi
        System.out.println(String.format("Trobat:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", nom, vi.getPreu(), vi.getEstoc()));
    }

    public void processaModifica(){
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank())
            return;
        Vi vi = botiga.cerca(nom);
        // Si no es troba el vi
        if(vi == null) {
            System.out.println("No trobat");
            return;
        }
        // Si es troba el vi

        // ---- PREU ----
        System.out.print(String.format("preu (enter %d)> ", vi.getPreu()));
        String preuString = Entrada.readLine();
        // Si el preu no esta en blanc...
        if (!preuString.isBlank()) {
            // Si no es un enter donem l'error
            if (!UtilString.esEnter(preuString) || (UtilString.esEnter(preuString) && Integer.parseInt(preuString) < 0)) {
                System.out.println("ERROR: cal un enter positiu");
                return;
            }
            // Si es un enter modifiquem el preu del vi
            vi.setPreu(Integer.parseInt(preuString));
        }

        // ---- ESTOC ----
        System.out.print(String.format("estoc (enter %d)> ", vi.getEstoc()));
        String estocString = Entrada.readLine();
        // Si el preu no esta en blanc...
        if (!estocString.isBlank()) {
            // Si no es un enter donem l'error
            if (!UtilString.esEnter(estocString)) {
                System.out.println("ERROR: el valor ha de ser un enter positiu");
                return;
            }
            // Si es un enter modifiquem el preu del vi
            vi.setEstoc(Integer.parseInt(estocString));
        }

        System.out.println(String.format("Modificat:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", vi.getNom(), vi.getPreu(), vi.getEstoc()));

    }

    public void processaElimina(){
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank())
            return;
        Vi vi = botiga.cerca(nom);
        // Si no es troba el vi
        if(vi == null) {
            System.out.println("No trobat");
            return;
        }
        // Si es troba el vi
        System.out.println(String.format("A eliminar:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", vi.getNom(), vi.getPreu(), vi.getEstoc()));

        // Demanem confirmacio
        System.out.print("Segur?> ");
        boolean confirm = UtilitatsConfirmacio.respostaABoolean(Entrada.readLine());
        if (confirm) {
            Vi deleted = botiga.elimina(vi.getNom());
            // Si no s'ha pogut eliminar diem error
            if (deleted == null) {
                System.out.println("ERROR: no s'ha pogut eliminar");
                return;
            }
            // Si si s'ha pogut ho diem
            System.out.println("Eliminat");
            return;
        }
        System.out.println("No eliminat");
    }

    private int tractaDades(String data) {
        // Si la dada esta buida ho interpretem com un 0
        if (data.isBlank())
            return 0;
        
        // Si no es un enter indiquem l'error i sortim de la comanda
        if (!UtilString.esEnter(data) || (UtilString.esEnter(data) && Integer.parseInt(data) < 0)) {
            System.out.println("ERROR: cal un enter positiu");
            return -1;
        }
        // Passem el preu a enter
        return Integer.parseInt(data);
    }

    /* ---- MISSATGES ---- */

    public static void mostraBenvinguda() {
        System.out.println("Celler La Bona Estrella. Escriviu ajuda per veure opcions.");
    }

    public static void mostraPrompt() {
        System.out.print("botiga> ");
    }

    public static void mostraAjuda() {
        System.out.println(String.format("Comandes disponibles:%najuda%ncerca%nafegeix%nmodifica%nelimina%nsurt"));
    }

    public static void mostraErrorComandaDesconeguda() {
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda");
    }

    public static void mostraComiat() {
        System.out.println("adéu");
    }
}
