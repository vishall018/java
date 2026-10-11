
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeLeaveApplication extends JFrame implements ActionListener {

    JTextField id, name, dept, days, reason;
    JComboBox<String> type;
    JButton apply;
    JTextArea summary;

    EmployeeLeaveApplication() {
        setTitle("Employee Leave Application");
        setSize(400, 650);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Employee ID:");
        l1.setPreferredSize(new Dimension(350, 25));
        l1.setHorizontalAlignment(JLabel.CENTER);
        id = new JTextField(30);

        JLabel l2 = new JLabel("Employee Name:");
        l2.setPreferredSize(new Dimension(350, 25));
        l2.setHorizontalAlignment(JLabel.CENTER);
        name = new JTextField(30);

        JLabel l3 = new JLabel("Department:");
        l3.setPreferredSize(new Dimension(350, 25));
        l3.setHorizontalAlignment(JLabel.CENTER);
        dept = new JTextField(30);

        JLabel l4 = new JLabel("Leave Type:");
        l4.setPreferredSize(new Dimension(350, 25));
        l4.setHorizontalAlignment(JLabel.CENTER);

        String leaves[] = {"Sick Leave", "Casual Leave", "Earned Leave"};
        type = new JComboBox<>(leaves);
        type.setPreferredSize(new Dimension(290, 30));

        JLabel l5 = new JLabel("Number of Days:");
        l5.setPreferredSize(new Dimension(350, 25));
        l5.setHorizontalAlignment(JLabel.CENTER);
        days = new JTextField(30);

        JLabel l6 = new JLabel("Reason for Leave:");
        l6.setPreferredSize(new Dimension(350, 25));
        l6.setHorizontalAlignment(JLabel.CENTER);
        reason = new JTextField(30);

        apply = new JButton("Apply for Leave");
        apply.addActionListener(this);

        JLabel l7 = new JLabel("--- Application Summary ---");

        summary = new JTextArea(10, 30);
        summary.setEditable(false);
        summary.setFont(new Font("Arial", Font.PLAIN, 14));

        add(l1);
        add(id);
        add(l2);
        add(name);
        add(l3);
        add(dept);
        add(l4);
        add(type);
        add(l5);
        add(days);
        add(l6);
        add(reason);
        add(apply);
        add(l7);
        add(summary);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String employeeId = id.getText();
        String employeeName = name.getText();
        String department = dept.getText();
        String leaveType = (String) type.getSelectedItem();
        String numberOfDays = days.getText();
        String leaveReason = reason.getText();

        summary.setText(
            "ID: " + employeeId +
            "\nName: " + employeeName +
            "\nDept: " + department +
            "\nType: " + leaveType +
            "\nDays: " + numberOfDays +
            "\nReason: " + leaveReason
        );
    }

    public static void main(String[] args) {
        new EmployeeLeaveApplication();
    }
}
