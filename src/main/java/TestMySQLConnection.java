import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_tdevops"; // replace 'testdb' with your DB name
        String username = "root"; // replace with your MySQL username
        String password = "";     // replace with your MySQL password

        try {
            // Load MySQL JDBC driver (optional with JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println(" Connection successful!");

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Connection failed.");
            e.printStackTrace();
        }
    }
}
