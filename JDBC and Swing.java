import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CRUDApplication extends JFrame implements ActionListener {
    JLabel nameLabel, ageLabel, phoneLabel, genderLabel;
    JTextField nameField, ageField, phoneField;
    ButtonGroup genderGroup;
    JRadioButton maleRadioButton, femaleRadioButton;
    JButton submitButton, updateButton, clearButton, deleteButton;
    Connection con;
    PreparedStatement pstmt;

    public CRUDApplication() {
        setTitle("CRUD Operations");
        setSize(300, 200);
        setLayout(new FlowLayout());

        nameLabel = new JLabel("Name:");
        ageLabel = new JLabel("Age:");
        phoneLabel = new JLabel("Phone Number:");
        genderLabel = new JLabel("Gender:");

        nameField = new JTextField(10);
        ageField = new JTextField(10);
        phoneField = new JTextField(10);

        genderGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        submitButton = new JButton("Submit");
        updateButton = new JButton("Update");
        clearButton = new JButton("Clear");
        deleteButton = new JButton("Delete");

        this.add(nameLabel);
        this.add(nameField);
        this.add(ageLabel);
        this.add(ageField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(genderLabel);
        this.add(maleRadioButton);
        this.add(femaleRadioButton);
        this.add(submitButton);
        this.add(updateButton);
        this.add(clearButton);
        this.add(deleteButton);

        submitButton.addActionListener(this);
        updateButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource() == submitButton) {
                pstmt = con.prepareStatement("INSERT INTO details (name, age, phone, gender) VALUES (?, ?, ?, ?)");
                pstmt.setString(1, nameField.getText());
                pstmt.setInt(2, Integer.parseInt(ageField.getText()));
                pstmt.setInt(3, Integer.parseInt(phoneField.getText()));
                pstmt.setString(4, maleRadioButton.isSelected() ? "Male" : "Female");
                pstmt.executeUpdate();
                System.out.println("Inserted successfully");
            } 
            else if (event.getSource() == updateButton) {
                pstmt = con.prepareStatement("UPDATE details SET age=?, phone=?, gender=? WHERE name=?");
                pstmt.setInt(1, Integer.parseInt(ageField.getText()));
                pstmt.setInt(2, Integer.parseInt(phoneField.getText()));
                pstmt.setString(3, maleRadioButton.isSelected() ? "Male" : "Female");
                pstmt.setString(4, nameField.getText());
                pstmt.executeUpdate();
                System.out.println("Updated successfully");
            } 
            else if (event.getSource() == deleteButton) {
                pstmt = con.prepareStatement("DELETE FROM details WHERE name=?");
                pstmt.setString(1, nameField.getText());
                pstmt.executeUpdate();
                System.out.println("Deleted successfully");
            } 
            else if (event.getSource() == clearButton) {
                nameField.setText("");
                ageField.setText("");
                phoneField.setText("");
                genderGroup.clearSelection();
                System.out.println("Cleared fields");
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CRUDApplication();
    }
}


//javac -cp ".:/Users/sahaj/Others/Codes/Java/mysql-connector-j-9.1.0.jar" CRUDApplication.java
//java -cp ".:/Users/sahaj/Others/Codes/Java/mysql-connector-j-9.1.0.jar" CRUDApplication 