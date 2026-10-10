import java.awt.FlowLayout;
import javax.swing.*;

public class SwingDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("User Form");
        f.setSize(800, 400);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Username:");
        JTextField t1 = new JTextField(20);

        JLabel l2 = new JLabel("Password:");
        JPasswordField t2 = new JPasswordField(20);

        JButton b = new JButton("Submit");

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(b);

        f.setVisible(true);
    }
}
