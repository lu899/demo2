import java.sql.*;
import javax.swing.*;

public class RegisterDAO {
    private Connection con = DatabaseConnection.getConnection();

    public void addUser(String name, String telephone, String address, String password){
        String insertSQL = "INSERT INTO users (name, telephone, address, password) VALUES(?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
            stmt.setString(1, name);
            stmt.setString(2, telephone);
            stmt.setString(3, address);
            stmt.setString(4, password);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User Registered Successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "User Registration Failed: " + e.getMessage());
        }
    }
}
