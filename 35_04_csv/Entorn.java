
/**
 * Implementacio de la classe Entorn que contindra la botiga i la
 * interficie amb la cual l'usuari podra manejar la seva botiga
 */

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class Entorn {
    private final Botiga botiga = new Botiga();

    public static void main(String[] args) throws IOException {
        Entorn entorn = new Entorn();
        mostraBenvinguda();
        llegirVins();
        entorn.carregarVinsCsv();
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
        entorn.guardarVins();
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

    public void processaCerca() {
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank())
            return;
        Vi vi = botiga.cerca(nom);
        // Si no es troba el vi
        if (vi == null) {
            System.out.println("No trobat");
            return;
        }
        // Si es troba el vi
        System.out.println(
                String.format("Trobat:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", nom, vi.getPreu(), vi.getEstoc()));
    }

    public void processaModifica() {
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank())
            return;
        Vi vi = botiga.cerca(nom);
        // Si no es troba el vi
        if (vi == null) {
            System.out.println("No trobat");
            return;
        }
        // Si es troba el vi

        // ---- PREU ----
        if (modificaDades("preu", vi) == -1)
            return;

        // ---- ESTOC ----
        if (modificaDades("estoc", vi) == -1)
            return;

        System.out.println(String.format("Modificat:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", vi.getNom(),
                vi.getPreu(), vi.getEstoc()));

    }

    private int modificaDades(String opcio, Vi vi) {
        // Mostrem el missatge segons l'opcio seleccionada
        if (opcio.equals("preu")) {
            System.out.print(String.format("preu (enter %d)> ", vi.getPreu()));
        }
        if (opcio.equals("estoc")) {
            System.out.print(String.format("estoc (enter %d)> ", vi.getEstoc()));
        }

        // Demanem la dada necessaria a modificar
        String dada = Entrada.readLine();

        // Si la dada introduida esta en blanc
        if (!dada.isBlank()) {
            // Si la dada introduida no es un enter o en el cas que sigui un enter i sigui
            // negatiu, donem com a error
            if (!UtilString.esEnter(dada) || (UtilString.esEnter(dada) && Integer.parseInt(dada) < 0)) {
                System.out.println("ERROR: cal un enter positiu");
                return -1;
            }
            // Si es un enter positiu modifiquem la dada corresponent
            if (opcio.equals("preu"))
                vi.setPreu(Integer.parseInt(dada));
            else if (opcio.equals("estoc"))
                vi.setEstoc(Integer.parseInt(dada));
        }
        return 0;

    }

    public void processaElimina() {
        System.out.print("nom (enter cancel·la)> ");
        String nom = Entrada.readLine();
        if (nom.isBlank())
            return;
        Vi vi = botiga.cerca(nom);
        // Si no es troba el vi
        if (vi == null) {
            System.out.println("No trobat");
            return;
        }
        // Si es troba el vi
        System.out.println(String.format("A eliminar:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", vi.getNom(),
                vi.getPreu(), vi.getEstoc()));

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

    /* ---- CARREGAR VINS DE CSV ---- */

    public static void llegirVins() throws IOException {
        // Obrim el fitxer csv de la botiga
        File csv = new File("botiga.csv");
        csv.createNewFile();
        int lines = countLines(csv);
        System.out.println("Referències llegides: " + lines);
    }

    private void carregarVinsCsv() throws IOException {
        File csv = new File("botiga.csv");
        // Obrim en lectura el fitxer csv
        BufferedReader reader = new BufferedReader(new FileReader(csv));
        while(true) {
            String line = reader.readLine();
            if (line == null) break;

            // Passem del fitxer a un Vi
            Vi vi = Vi.deArrayString(line.split(";"));
            // Si el vi es null el saltem
            if (vi == null) continue;
            // Afegim el vi a la botiga
            botiga.afegeix(vi);
        }

        reader.close();
    }

    public void guardarVins() throws IOException {
        File csv = new File("botiga.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(csv));
        botiga.iniciaRecorregut();
        Vi vi = botiga.getSeguent();
        if (vi != null) {
            writer.write(String.join(";", vi.aArrayString()));
        }

        
        writer.close();
    }

    private static int countLines(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        // Comptem les linies que te l'arxiu, els vins que hi han
        int lines = 0;
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            lines++;
        }
        reader.close();
        return lines;
    }



}
