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
        // Si l'animal ja esta a la bdd, no fem res
        if (!animal.idIndefinit())
            return;
        manageCategoriaAnimal(animal);
        int idCat = animal.getCategoria().getId();
        // Inserim l'animal a la bdd
        String sql = String.format("INSERT INTO ANIMALS (nom, categoria) VALUES ('%s', %d)", animal.getNom(), idCat);
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            animal.setId(id);
        }
    }

    private void manageCategoriaAnimal(Animal animal) throws SQLException {
        Categoria categoria = obteCategoriaPerNom(animal.getCategoria().getNom());
        if (categoria == null) {
            // Afegirem la categoria
            afegeixCategoria(animal.getCategoria());
            categoria = obteCategoriaPerNom(animal.getCategoria().getNom());
        }
        animal.setCategoria(categoria);
    }

    public Animal obteAnimalPerNom(String nom) throws SQLException {
        // Obtindrem dels animals: nom, id
        // de la categoria nomes el nom
        String sql = "SELECT ANIMALS.nom AS nom, ANIMALS.id AS id, CATEGORIES.nom AS cat_nom FROM ANIMALS, CATEGORIES WHERE CATEGORIES.id = ANIMALS.categoria AND ANIMALS.nom = '" + nom + "' ORDER BY ANIMALS.id LIMIT 1";

        try (Statement st = conn.createStatement();) {
            ResultSet rs = st.executeQuery(sql);
            // Si no es troba cap animal
            if (!rs.next())
                return null;

            String nomAnimal = rs.getString("nom");
            int idAnimal = rs.getInt("id");
            Categoria categoria = obteCategoriaPerNom(rs.getString("cat_nom"));

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
                Categoria categoria = obteCategoriaPerNom(nomCategoria);
                Animal animal = new Animal(rs.getInt("id_animal"), nomAnimal, categoria);
                animals.add(animal);
            }
            return animals;   
        }
    }

    public void canviaCategoria(Animal animal, Categoria categoria) throws SQLException {
        if (!animalExists(animal)) {
            if (!categoriaExists(categoria)) {
                afegeixCategoria(categoria);
                categoria = obteCategoriaPerNom(categoria.getNom());
            }
            animal.setCategoria(categoria);
            afegeixAnimal(animal);
        }
        else {
            if (!categoriaExists(categoria)) {
                afegeixCategoria(categoria);
                categoria = obteCategoriaPerNom(categoria.getNom());
            }
            animal.setCategoria(categoria);
        }
        categoria = obteCategoriaPerNom(categoria.getNom());

        String sql = String.format("UPDATE ANIMALS SET categoria = %d WHERE id = %d", categoria.getId(), animal.getId());
        try(Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    private boolean animalExists(Animal animal) throws SQLException {
        String sql = String.format("SELECT COUNT(nom) FROM ANIMALS WHERE nom = '%s'", animal.getNom());
        try(Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            if (rs.getInt(1) > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean categoriaExists(Categoria categoria) throws SQLException {
        String sql = String.format("SELECT COUNT(nom) FROM CATEGORIES WHERE nom = '%s'", categoria.getNom());
        try(Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            if (rs.getInt(1) > 0) {
                return true;
            }
        }
        return false;
    }
}