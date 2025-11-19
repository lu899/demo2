import java.sql.*;

public class RegisterDAO {
    private Connection con = DatabaseConnection.getConnection();

    public void addUser(String name, String email, String password){
        String insertSQL = "INSERT INTO users (name, email, password) VALUES(?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Couldn't add user: " + e.getMessage());
        }
    }
}
