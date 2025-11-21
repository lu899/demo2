import java.sql.*;

public class DatabaseConnection {
    private static Connection conn = null;

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "your_sql_password";

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
