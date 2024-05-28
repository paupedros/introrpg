import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class BotigaVins {
    private Vi[] vins;
    private int DEFAULT_MAX_VINS = 10;
    private static final String BDD = "botiga.db";
    private static final String CONN = "jdbc:sqlite:" + BDD;
    private Connection conn = null;

    BotigaVins() {
        vins = new Vi[DEFAULT_MAX_VINS];
    }

    BotigaVins(int maxVins) {
        vins = new Vi[maxVins];
    }

    public void connecta() throws SQLException {
        if (conn != null)
            return;
        conn = DriverManager.getConnection(CONN);
    }

    public void desconnecta() throws SQLException {
        if (conn == null)
            return;
        conn.close();
        conn = null;
    }

    public void creaTaulaVins() throws SQLException {
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

    public void eliminaTaulaVins() throws SQLException {
        String sql = "DELETE IF EXISTS VINS";
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    public int totalVins() throws SQLException {
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
