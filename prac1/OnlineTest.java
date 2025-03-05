import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[4];
    JButton b1;
    ButtonGroup bg;
    int count = 0, current = 0;

    OnlineTest(String s) {  
        setTitle(s);   
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b1.addActionListener(this);
        add(b1);
        set();
        
        l.setBounds(30, 40, 450, 20);
        for (int i = 0; i < 4; i++) {
            jb[i].setBounds(50, 80 + (i * 30), 200, 20);
        }
        b1.setBounds(100, 240, 100, 30);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check()) count++;
            current++;
            if (current > 1) {
                JOptionPane.showMessageDialog(this, "Correct answers=" + count);
                System.exit(0);
            }
            set();
        }
    }

    void set() {
        bg.clearSelection();
        if (current == 0) {
            l.setText("Que1: Which one among these is not a primitive datatype?");
            jb[0].setText("int"); jb[1].setText("Float"); jb[2].setText("boolean"); jb[3].setText("char");
        } else if (current == 1) {
            l.setText("Que10: Which one among these is not a valid component?");
            jb[0].setText("JButton"); jb[1].setText("JList"); jb[2].setText("JButtonGroup"); jb[3].setText("JTextArea");
        }
    }

    boolean check() {
        return (current == 0 && jb[1].isSelected()) || (current == 1 && jb[2].isSelected());
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test Of Java");
    }
}
