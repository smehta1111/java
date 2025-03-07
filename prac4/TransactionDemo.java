import java.sql.*;

public class TransactionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sybsc";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students (id, name, age) VALUES (?, ?, ?)")) {

                pstmt.setInt(1, 101);
                pstmt.setString(2, "Alice");
                pstmt.setInt(3, 20);
                pstmt.executeUpdate();

                pstmt.setInt(1, 102);
                pstmt.setString(2, "Bob");
                pstmt.setInt(3, 22);
                pstmt.executeUpdate();

                conn.commit(); // Commit transaction
                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {
                conn.rollback(); // Rollback transaction if an error occurs
                System.out.println("Transaction rolled back due to an error.");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
