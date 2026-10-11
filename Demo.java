
import java.awt.*;
import javax.swing.*;
class Demo {
    public static void main(String[] args)
    {
        JFrame f = new JFrame("User Form");
        f.setSize(300,300);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l = new JLabel("Username");
        JTextField t = new JTextField(20);
        f.add(l);
        f.add(t);
        JButton b = new JButton("Submit");
        f.add(b);
        f.setVisible(true);

    }
}