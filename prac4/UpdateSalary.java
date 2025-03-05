import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateSalary {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sybsc?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    private static void updateSalaries(double multiplier) throws Exception {
        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, salary FROM employees");
            
            String updateQuery = "UPDATE employees SET salary = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(updateQuery);
            
            System.out.println("\nSalary Updates:");
            System.out.println("--------------------------------------------------");
            System.out.printf("%-5s %-15s %-12s %-12s%n", "ID", "Name", "Old Salary", "New Salary");
            System.out.println("--------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double currentSalary = rs.getDouble("salary");
                double newSalary = currentSalary * multiplier;
                
                pstmt.setDouble(1, newSalary);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                
                System.out.printf("%-5d %-15s %-12.2f %-12.2f%n", 
                    id, name, currentSalary, newSalary);
            }
            
            System.out.println("--------------------------------------------------");
            System.out.println("Salary update completed successfully!");
        }
    }

    public static void main(String[] args) {
        try {
            double multiplier = 1.2;
            updateSalaries(multiplier);
            
        } catch (Exception e) {
            System.out.println("Error updating salaries: " + e.getMessage());
            e.printStackTrace();
        }
    }
}