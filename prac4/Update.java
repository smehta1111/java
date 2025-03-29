import java.sql.*;

public class Update {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sybsc";
        String user = "root";
        String password = "root";
        
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE employees SET salary = salary * 1.2 WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, 1);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Salary updated successfully");
            } else {
                System.out.println("No record found with the given ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
