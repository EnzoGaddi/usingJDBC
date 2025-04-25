package ie.atu.week2sem2;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // DB URL
        String user = "root"; // DB username
        String password = "password"; // DB password

        try {
            // 1. Load the JDBC driver (optional for newer Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // 3. Create a statement
            Statement stmt = conn.createStatement();

            // 4. Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars");

            // 5. Process the result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // 6. Close everything
            rs.close();
            stmt.close();
            conn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}