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
/*
                case "cerca":
                    entorn.processaCerca();
                    break;
                case "modifica":
                    entorn.processaModifica();
                    break;
                case "elimina":
                    entorn.processaElimina();
                    break;
*/
                default:
                    mostraErrorComandaDesconeguda();
            }
        }
        mostraComiat();
    }

    /* ---- PROCESSAMENT ---- */
    
    public void processaAfegeix(){
        // ---- NOM ----
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank()) return;

        // ---- PREU ----
        System.out.print("preu (en cèntims)> ");
        String preuString = Entrada.readLine();
        int preu = tractaDades(preuString);
        // Si no es un enter sera -1
        if (preu == -1) return;

        // ---- ESTOC ----
        System.out.print("estoc (enter sense estoc)> ");
        String estocString = Entrada.readLine();
        int estoc = tractaDades(estocString);
        // Si no es un enter sera -1
        if (estoc == -1) return;

        
    }

    private int tractaDades(String data){
        // Si la dada esta buida ho interpretem com un 0
        if (data.isBlank()) return 0;
        // Si no es un enter indiquem l'error i sortim de la comanda
        if (!UtilString.esEnter(data)){
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
        System.out.println(String.format("Comandes disponibles:%najuda%ncerca%nafegeix%nmodifica%nelimina%nsurt%n"));
    }

    public static void mostraErrorComandaDesconeguda(){
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda");
    }

    public static void mostraComiat(){
        System.out.println("adeu");
    }
}
