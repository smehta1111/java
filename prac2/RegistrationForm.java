import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class RegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel mainPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Name:"));
        mainPanel.add(new JTextField(20));

        mainPanel.add(new JLabel("Father Name:"));
        mainPanel.add(new JTextField(20));

        mainPanel.add(new JLabel("Age:"));
        mainPanel.add(new JTextField(20));

        mainPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        mainPanel.add(genderPanel);

        mainPanel.add(new JLabel("Course:"));
        mainPanel.add(new JComboBox<>(new String[]{"Java", "Python", "C++", "JavaScript"}));

        mainPanel.add(new JLabel("Hobbies:"));
        JPanel hobbiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hobbiesPanel.add(new JCheckBox("Drawing"));
        hobbiesPanel.add(new JCheckBox("Singing"));
        hobbiesPanel.add(new JCheckBox("Music"));
        mainPanel.add(hobbiesPanel);

        mainPanel.add(new JLabel("Address:"));
        mainPanel.add(new JScrollPane(new JTextArea(3, 20)));

        mainPanel.add(new JButton("Save Details"));
        mainPanel.add(new JButton("Clear All"));

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
