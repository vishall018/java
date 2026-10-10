```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener
{
    JLabel q1, q2, q3, result;
    JRadioButton a1, a2, b1, b2, c1, c2;
    JButton submit;

    QuizApp()
    {
        setTitle("Quiz Application");
        setSize(450, 400);
        setLayout(new GridLayout(10, 1));

        q1 = new JLabel("1. Which language is used for Android development?");
        a1 = new JRadioButton("Java");
        a2 = new JRadioButton("HTML");
        ButtonGroup g1 = new ButtonGroup();
        g1.add(a1);
        g1.add(a2);

        q2 = new JLabel("2. Which keyword is used to inherit a class in Java?");
        b1 = new JRadioButton("implements");
        b2 = new JRadioButton("extends");
        ButtonGroup g2 = new ButtonGroup();
        g2.add(b1);
        g2.add(b2);

        q3 = new JLabel("3. Which method starts a new thread?");
        c1 = new JRadioButton("run()");
        c2 = new JRadioButton("start()");
        ButtonGroup g3 = new ButtonGroup();
        g3.add(c1);
        g3.add(c2);

        submit = new JButton("Submit");
        result = new JLabel(" ");

        add(q1);
        add(a1);
        add(a2);
        add(q2);
        add(b1);
        add(b2);
        add(q3);
        add(c1);
        add(c2);
        add(submit);
        add(result);

        submit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        int score = 0;

        if(a1.isSelected())
            score++;

        if(b2.isSelected())
            score++;

        if(c2.isSelected())
            score++;

        result.setText("Your Score: " + score + " / 3");
        submit.setEnabled(false);
    }

    public static void main(String args[])
    {
        new QuizApp();
    }
}
```