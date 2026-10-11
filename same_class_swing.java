```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeaveForm extends JFrame implements ActionListener
{
    JTextField id, name, days;
    JComboBox<String> dept, type;
    JTextArea reason;
    JButton apply;

    LeaveForm()
    {
        setTitle("Employee Leave Form");
        setSize(400, 450);
        setLayout(new GridLayout(7, 2, 5, 5));

        id = new JTextField();
        name = new JTextField();
        days = new JTextField();

        String departments[] = {"IT", "HR", "Finance", "Sales"};
        dept = new JComboBox<>(departments);

        String leaves[] = {"Casual Leave", "Sick Leave", "Earned Leave"};
        type = new JComboBox<>(leaves);

        reason = new JTextArea(3, 15);
        apply = new JButton("Apply");

        add(new JLabel("Employee ID:"));
        add(id);

        add(new JLabel("Employee Name:"));
        add(name);

        add(new JLabel("Department:"));
        add(dept);

        add(new JLabel("Leave Type:"));
        add(type);

        add(new JLabel("Number of Days:"));
        add(days);

        add(new JLabel("Reason:"));
        add(new JScrollPane(reason));

        add(new JLabel(""));
        add(apply);

        apply.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String details = "Employee ID: " + id.getText()
            + "\nName: " + name.getText()
            + "\nDepartment: " + dept.getSelectedItem()
            + "\nLeave Type: " + type.getSelectedItem()
            + "\nNumber of Days: " + days.getText()
            + "\nReason: " + reason.getText();

        JOptionPane.showMessageDialog(this, details,
            "Leave Application Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[])
    {
        new LeaveForm();
    }
}
```
