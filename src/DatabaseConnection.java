import java.sql.*;

public class DatabaseConnection {
    private static Connection conn = null;

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/exampledb";
        String user = "root";
        String password = "Password_22";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find class!!");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to database!!");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return conn;
    }
}
