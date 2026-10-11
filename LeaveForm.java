```java
import java.awt.FlowLayout;
import javax.swing.*;

public class SwingDemo {
    public static void main(String[] args) {

        JFrame f = new JFrame("Swing Components");
        f.setSize(800, 500);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l = new JLabel("Label");
        JTextField t = new JTextField(20);
        JPasswordField p = new JPasswordField(20);
        JButton b = new JButton("Button");
        JRadioButton r = new JRadioButton("Radio Button");
        JCheckBox c = new JCheckBox("Check Box");

        String items[] = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> cb = new JComboBox<>(items);

        JTextArea ta = new JTextArea(5, 20);
        JPanel panel = new JPanel();

        ButtonGroup bg = new ButtonGroup();
        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("Female");

        bg.add(r1);
        bg.add(r2);

        f.add(l);
        f.add(t);
        f.add(p);
        f.add(b);
        f.add(r);
        f.add(c);
        f.add(cb);
        f.add(ta);
        f.add(panel);
        f.add(r1);
        f.add(r2);

        f.setVisible(true);
    }
}
```