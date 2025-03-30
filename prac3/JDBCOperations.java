import java.sql.*;
import java.util.Scanner;

public class JDBCOperations {

  // Establish database connection
  private static Connection getConnection()
  throws Exception {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/sybsc";
    String jdbcUser = "root";
    String jdbcPassword = "root";
    
    return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
  }

  // Insert record into the database
  private static void insertRecord(Connection connection,
    String name, double salary)
  throws Exception {
    String query = "INSERT INTO employees (name,salary) VALUES (?, ?)";
    
    PreparedStatement preparedStatement
      = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.setDouble(2, salary);
    preparedStatement.executeUpdate();
    
    System.out.println("Record inserted successfully.");
  }

  // Update record in the database
  private static void updateRecord(Connection connection,
    int id, String name,double salary)
  throws Exception {
    
    String query
      = "UPDATE employees SET name = ?, salary = ? WHERE id = ?";
    
    PreparedStatement preparedStatement
      = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.setDouble(2, salary);
    preparedStatement.setInt(3, id);
    preparedStatement.executeUpdate();
    
    System.out.println("Record updated successfully.");
  }

  // Retrieve records from the database
  private static void
  retrieveRecords(Connection connection) throws Exception {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
    
    System.out.println("Records in the database:");
    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      double salary = resultSet.getDouble("salary");
      System.out.println("ID: " + id + ", Name: " + name +
        ", Salary: " + salary);
    
    }
  }

  // Delete record from the database
  private static void deleteRecord(Connection connection,
    int id)
  throws Exception {
    String query = "DELETE FROM employees WHERE id = ?";
    PreparedStatement preparedStatement
      = connection.prepareStatement(query);
    preparedStatement.setInt(1, id);
    preparedStatement.executeUpdate();
    System.out.println("Record deleted successfully.");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = getConnection();

      System.out.println("Select an operation:");
      System.out.println("1. Insert");
      System.out.println("2. Update");
      System.out.println("3. Retrieve");
      System.out.println("4. Delete");

      int choice = scanner.nextInt();

      switch (choice) {
      case 1:
        System.out.println("Enter name:");
        
        String nameToInsert = scanner.next();
        System.out.println("Enter salary:");
        double salaryToInsert = scanner.nextDouble();
        insertRecord(connection, nameToInsert,
          salaryToInsert);
        break;

      case 2:
        System.out.println("Enter ID to update:");
        int idToUpdate = scanner.nextInt();
        System.out.println("Enter new name:");
        String nameToUpdate = scanner.next();
        System.out.println("Enter new salary:");
        double salaryToUpdate
          = scanner.nextDouble();
        updateRecord(connection, idToUpdate,
          nameToUpdate, salaryToUpdate);
        break;

      case 3:
        retrieveRecords(connection);
        break;

      case 4:
        System.out.println("Enter ID to delete:");
        int idToDelete = scanner.nextInt();
        deleteRecord(connection, idToDelete);
        break;

      default:
        System.out.println("Invalid choice.");
        break;
      }

      // Close the connection at the end
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      scanner.close();
    }
  }
}