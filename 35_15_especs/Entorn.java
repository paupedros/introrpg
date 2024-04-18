
/**
 * Implementacio de la classe Entorn que contindra la botiga i la
 * interficie amb la cual l'usuari podra manejar la seva botiga
 */

import java.util.List;
import java.util.LinkedList;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class Entorn {
    private final Botiga botiga = new Botiga();

    public static void main(String[] args) throws Exception {
        Entorn entorn = new Entorn();
        mostraBenvinguda();
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
                    entorn.noAvailable();
                    break;
                case "cerca":
                    entorn.processaCerca();
                    break;
                case "modifica":
                    entorn.noAvailable();
                    break;
                case "elimina":
                    entorn.noAvailable();
                    break;
                default:
                    mostraErrorComandaDesconeguda();
            }
        }
        mostraComiat();
    }

    public void noAvailable() {
        System.out.println("Comanda temporalment no disponible");
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
        // Vi newVi = botiga.afegeix(new Vi(nom, preu, estoc));
        // if (newVi == null) {
        // System.out.println("ERROR: no s'ha pogut afegir");
        // return;
        // }
        System.out.println(String.format("Introduït:%n    Vi: %s%n    Preu: %d%n    Estoc: %d%n", nom, preu, estoc));
    }

    public void processaCerca() {
        // Demanem la referencia del vi a buscar
        System.out.print("ref> ");
        String ref = Entrada.readLine();
        List<Vi> vins = new LinkedList<>();
        Vi vi = null;

        // Si la ref esta buida demanem les altres propietats
        if (ref.isBlank()) {
            ref = null;
            String[] properties = new String[6];
            try {
                properties = askProperties(properties);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            Especificacio plantilla = crearPlantilla(properties);
            // System.out.println(plantilla);
            vins = botiga.cerca(plantilla, Integer.parseInt(properties[1]), Integer.parseInt(properties[2]));
        }
        // Si coincideix amb un '!'
        else if (ref.equals("!"))
            return;
        else
            vi = botiga.cerca(ref);

        // Manejo de resultados de búsqueda
        if (vins != null && !vins.isEmpty()) {
            // Si es troba el vi
            System.out.print(
                    String.format("Trobat:%s", printList(vins)));
        } else if (vi != null) {
            System.out.println("Trobat: " + vi);
        } else {
            System.out.println("No trobat");
        }

    }

    private String printList(List<Vi> list) {
        String result = "";

        for (Vi vi : list) {
            if (list.indexOf(vi) != 0)
                result += "" + "\n" + vi.toString();
            else
                result += vi.toString();
        }
        return result;
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
                throw new IllegalArgumentException();
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

    private Especificacio crearPlantilla(String[] propietats) {
        // Crear objeto Vi con las propiedades
        return new Especificacio(
                propietats[0], // nom
                Origen.fromString(propietats[3]), // origen
                Tipus.fromString(propietats[4]), // tipus
                propietats[5]);
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

    private static int tractaDades(String data) {
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
        System.out.println(String.format("Comandes disponibles:%najuda%ncerca%nsurt"));
    }

    public static void mostraErrorComandaDesconeguda() {
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda");
    }

    public static void mostraComiat() {
        System.out.println("adéu");
    }

    /* ---- CARREGAR VINS DE CSV ---- */

    private void carregarVinsCsv() throws Exception {
        File csv = new File("botiga.csv");
        // Creem l'arxiu botiga si no existia
        csv.createNewFile();
        // Obrim en lectura el fitxer csv
        BufferedReader reader = new BufferedReader(new FileReader(csv));
        int lines = 0;
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            // Passem del fitxer a un Vi
            Vi vi = Vi.deArrayString(line.split(";"));
            // System.out.println(vi);
            // Si el vi es null el saltem
            if (vi == null)
                continue;
            // Afegim el vi a la botiga
            try {
                botiga.afegeix(vi);
                lines++;
            } catch (Exception e) {
                System.out.println("ERROR: massa entrades a botiga.csv");
            }
        }
        System.out.println("Referències llegides: " + lines);

        reader.close();
    }

    /**
     * Crea de nou l'arxiu botiga.csv i carrega amb format csv els vins que hi han
     * dins la botiga,
     * es guarden els vins que no siguin null
     */
    public void guardarVins() throws IOException {
        // Es crea un nou arxiu csv i s'elimina l'existent
        File csv = new File("botiga.csv");
        csv.delete();
        // Creem buffer per escriure al arxiu csv
        BufferedWriter writer = new BufferedWriter(new FileWriter(csv));

        List<Vi> vins = botiga.getVins();
        // Inicialitzem el comptador de referencies guardades
        int referencies = 0;
        // Mentre que vi no sigui un null
        for (Vi vi : vins) {
            writer.write(String.join(";", vi.aArrayString()));
            writer.newLine();
            referencies++;
        }
        writer.close();
        System.out.println("Referències guardades: " + referencies);
    }
}
