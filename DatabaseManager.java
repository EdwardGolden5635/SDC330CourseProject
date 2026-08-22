import java.sql.*;

/**
 * Handles all database operations.
 */
public class DatabaseManager {

    private static final String DB_URL =
            "jdbc:sqlite:sportscards.db";

    public DatabaseManager() {
        createTable();
    }

    /**
     * Creates table if it does not exist.
     */
    private void createTable() {

        String sql =
                "CREATE TABLE IF NOT EXISTS cards (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "playerName TEXT," +
                "team TEXT," +
                "year INTEGER," +
                "cardType TEXT," +
                "manufacturer TEXT," +
                "gradingCompany TEXT," +
                "grade REAL" +
                ");";

        try (Connection conn =
                     DriverManager.getConnection(DB_URL);
             Statement stmt =
                     conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * CREATE
     */
    public void saveCard(Card card) {

        String sql =
                "INSERT INTO cards " +
                "(playerName, team, year, cardType," +
                " manufacturer, gradingCompany, grade)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn =
                     DriverManager.getConnection(DB_URL);

             PreparedStatement pstmt =
                     conn.prepareStatement(sql)) {

            pstmt.setString(1, card.getPlayerName());
            pstmt.setString(2, card.getTeam());
            pstmt.setInt(3, card.getYear());

            if (card instanceof SportsCard) {

                SportsCard sc = (SportsCard) card;

                pstmt.setString(4, "SportsCard");
                pstmt.setString(5,
                        sc.getManufacturer());
                pstmt.setNull(6, Types.VARCHAR);
                pstmt.setNull(7, Types.DOUBLE);

            } else if (card instanceof GradedCard) {

                GradedCard gc =
                        (GradedCard) card;

                pstmt.setString(4,
                        "GradedCard");
                pstmt.setNull(5,
                        Types.VARCHAR);
                pstmt.setString(6,
                        gc.getGradingCompany());
                pstmt.setDouble(7,
                        gc.getGrade());
            }

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * READ
     */
    public void displayCards() {

        String sql = "SELECT * FROM cards";

        try (Connection conn =
                     DriverManager.getConnection(DB_URL);

             Statement stmt =
                     conn.createStatement();

             ResultSet rs =
                     stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        "ID: "
                                + rs.getInt("id")
                                + " | Player: "
                                + rs.getString("playerName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * UPDATE
     */
    public void updatePlayer(int id,
                             String newPlayerName) {

        String sql =
                "UPDATE cards " +
                "SET playerName=? " +
                "WHERE id=?";

        try (Connection conn =
                     DriverManager.getConnection(DB_URL);

             PreparedStatement pstmt =
                     conn.prepareStatement(sql)) {

            pstmt.setString(1,
                    newPlayerName);
            pstmt.setInt(2,
                    id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * DELETE
     */
    public void deleteCard(int id) {

        String sql =
                "DELETE FROM cards WHERE id=?";

        try (Connection conn =
                     DriverManager.getConnection(DB_URL);

             PreparedStatement pstmt =
                     conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}