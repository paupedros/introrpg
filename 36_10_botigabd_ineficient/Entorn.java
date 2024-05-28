
/**
 * Implementacio de la classe Entorn que contindra la botiga i la
 * interficie amb la cual l'usuari podra manejar la seva botiga
 */

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Entorn {
    private final Botiga botiga = new Botiga();
    private static final String BDD = "botiga.db";
    private static final String CONN = "jdbc:sqlite:" + BDD;
    private Connection conn = null;

    public static void main(String[] args) throws SQLException {
        Entorn entorn = new Entorn();
        mostraBenvinguda();
        entorn.carregarBdd();
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
        entorn.guardarBdd();
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
        Vi newVi = botiga.afegeix(new Vi(1, nom, preu, estoc));
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

   
    public void carregarBdd() throws SQLException {
        connecta();
        creaTaulaVins();
        carregarVins();
        llegirVins();
    }

    public void guardarBdd() throws SQLException {
        eliminaTaulaVins();
        creaTaulaVins();
        guardarVins();
        desconnecta();
    }

    /* ---- CARREGAR VINS DE CSV ---- */

    public void llegirVins() throws SQLException {
        int total = totalVins();
        System.out.println("Referències llegides: " + total);
    }

    private void carregarVins() throws SQLException {
        String sql = "SELECT * FROM VINS";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                int preu = rs.getInt(3);
                int estoc = rs.getInt(4);
                botiga.afegeix(new Vi(id, nom, preu, estoc));
            }
        }
    }

    /**
     * Crea de nou l'arxiu botiga.csv i carrega amb format csv els vins que hi han
     * dins la botiga,
     * es guarden els vins que no siguin null
     */
    public void guardarVins() throws SQLException {
        // Recorrem la botiga
        botiga.iniciaRecorregut();
        // Inicialitzem el comptador de referencies guardades
        int referencies = 0;
        // Obtenim el vi
        Vi vi = botiga.getSeguent();
        // Mentre que vi no sigui un null
        while (vi != null) {
            // Si no es un null el guardem al arxiu csv i incrementem el comptador
            if (vi != null) {
                String sql = String.format("INSERT INTO VINS(nom, preu, estoc) VALUES('%s', %d, %d)", vi.getNom(), vi.getPreu(), vi.getEstoc());
                try (Statement st = conn.createStatement()) {
                    st.executeUpdate(sql);
                }
                referencies++;
            }
            // Passem al seguent vi de la botiga
            vi = botiga.getSeguent();
        }
        System.out.println("Referències guardades: " + referencies);
    }

    private void connecta() throws SQLException {
        if (conn != null)
            return;
        conn = DriverManager.getConnection(CONN);
    }

    private void desconnecta() throws SQLException {
        if (conn == null)
            return;
        conn.close();
        conn = null;
    }

    private void creaTaulaVins() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS VINS (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nom VARCHAR(40),
                    preu INTEGER,
                    estoc INTEGER
                )
                """;
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    private void eliminaTaulaVins() throws SQLException {
        String sql = "DROP TABLE IF EXISTS VINS";
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    private int totalVins() throws SQLException {
        String sql = "SELECT COUNT(id) FROM VINS";
        int vins = 0;
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            vins = rs.getInt(1);
        }
        return vins;
    }

}
