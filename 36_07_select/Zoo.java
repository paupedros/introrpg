/*
 * Classe per a poder accedir a la base de dades dels animals del zoo
 * té els metodes per connectar-se i desconnectar-se
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Zoo {
    private static final String NOM_BASE_DE_DADES = "animals.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" + NOM_BASE_DE_DADES;
    private Connection conn = null;

    public void connecta() throws SQLException {
        if (conn != null)
            return; // ja connectat
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
    }

    public void desconnecta() throws SQLException {
        if (conn == null)
            return; // ja desconnectat
        conn.close();
        conn = null;
    }

    public void creaTaulaCategories() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS CATEGORIES (" +
                "       id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                "       nom       VARCHAR(40))";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public void eliminaTaulaCategories() throws SQLException {
        eliminaTaulaAnimals();
        String sql = "DROP TABLE IF EXISTS CATEGORIES";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public void afegeixCategoria(Categoria categoria) throws SQLException {
        String sql = String.format(
                "INSERT INTO CATEGORIES (nom) VALUES ('%s')",
                categoria.getNom());
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            // Obtenir el id
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            categoria.setId(id);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public List<Categoria> recuperaCategories() throws SQLException {
        String sql = "SELECT * FROM CATEGORIES ORDER BY nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Categoria> categories = new LinkedList<>();
            while (rs.next()) {
                int bdId = rs.getInt("id");
                String nom = rs.getString("nom");
                Categoria categoria = new Categoria(bdId, nom);
                categories.add(categoria);
            }
            rs.close();
            return categories;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public Categoria obteCategoriaPerNom(String nom) throws SQLException {
        String sql = String.format("SELECT * FROM CATEGORIES WHERE nom = '%s' ORDER BY id LIMIT 1", nom);
        Statement st = null;
        try {
            st = conn.createStatement();
            // Executem la Query
            ResultSet rs = st.executeQuery(sql);
            // Iniciem el recorregut
            if (rs.next() == false)
                return null;
            // Obtenim les propietats
            int id = rs.getInt("id");
            String catNom = rs.getString("nom");
            // Tanquem el cursor, ja no necessitem mes
            rs.close();
            // Retornem la categoria trobada
            return new Categoria(id, catNom);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    /* retorna el nom de les taules definides a la bd */
    public String getNomTaules() throws SQLException {
        String sql = "SELECT name FROM sqlite_schema " +
                "WHERE name NOT LIKE 'sqlite%' " +
                "ORDER BY name";
        List<String> taules = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                taules.add(rs.getString("name"));
            }
            rs.close();
        }
        return taules.size() > 0 ? String.join(", ", taules) : "cap";
    }

    public void creaTaulaAnimals() throws SQLException {
        creaTaulaCategories();
        String sql = """
                CREATE TABLE IF NOT EXISTS ANIMALS(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nom VARCHAR(40),
                    categoria INTEGER
                    )
                    """;
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    public void eliminaTaulaAnimals() throws SQLException {
        String sql = "DROP TABLE IF EXISTS ANIMALS";
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    public void afegeixAnimal(Animal animal) throws SQLException {
        // Si el id està definit, no fem res
        if (!animal.idIndefinit())
            return;
        int idCat = -1;
        if (!animal.getCategoria().idIndefinit())
            idCat = animal.getCategoria().getId();
        // Mirem si la categoria del animal a inserir esta dins de la bdd
        if (obteCategoriaPerNom(animal.getCategoria().getNom()) == null) {
            // Afegim la nova categoria
            afegeixCategoria(animal.getCategoria());
            // Obtenim el id de la categoria nova
            idCat = animal.getCategoria().getId();
        }
        // Inserim l'animal a la bdd
        String sql = String.format("INSERT INTO ANIMALS (nom, categoria) VALUES ('%s', %d)", animal.getNom(), idCat);
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    public Animal obteAnimalPerNom(String nom) throws SQLException {
        String sql = "SELECT * FROM ANIMALS WHERE nom = " + nom + " ORDER BY id LIMIT 1";

        try (Statement st = conn.createStatement();) {
            ResultSet rs = st.executeQuery(sql);
            // Si no es troba cap animal
            if (!rs.next())
                return null;

            String nomAnimal = rs.getString("nom");
            int idAnimal = rs.getInt("id");
            Categoria categoria = obteCategoriaPerNom(rs.getString("categoria"));

            return new Animal(idAnimal, nomAnimal, categoria);
        }
    }

    public List<Animal> recuperaAnimals() throws SQLException {
        String sql = """
                SELECT ANIMALS.id as id_animal,
                        ANIMALS.nom as nom_animal,
                        CATEGORIES.id as id_categoria,
                        CATEGORIES.nom as nom_categoria
                FROM ANIMALS, CATEGORIES
                WHERE ANIMALS.categoria = CATEGORIES.id
                ORDER BY ANIMALS.nom
                            """;
        List<Animal> animals = new LinkedList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String nomAnimal = rs.getString("nom_animal");
                String nomCategoria = rs.getString("nom_categoria");
                Categoria categoria = new Categoria(rs.getInt("id_categoria"), nomCategoria);
                Animal animal = new Animal(rs.getInt("id_animal"), nomAnimal, categoria);
                animals.add(animal);
            }
            return animals;   
        }
    }
}