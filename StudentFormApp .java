import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentFormApp extends JFrame implements ActionListener {

    private JTextField nameField, rollField, ageField, classField, emailField;
    private JButton submitButton, clearButton;
    private JTextArea displayArea;

    public StudentFormApp() {
        setTitle("Student Form");
        setSize(400, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        formPanel.add(rollField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Class:"));
        classField = new JTextField();
        formPanel.add(classField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        formPanel.add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        formPanel.add(clearButton);

        add(formPanel, BorderLayout.NORTH);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText().trim();
            String roll = rollField.getText().trim();
            String age = ageField.getText().trim();
            String cls = classField.getText().trim();
            String email = emailField.getText().trim();

            if(name.isEmpty() || roll.isEmpty() || age.isEmpty() || cls.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            displayArea.setText(
                    "Student Details:\n" +
                    "Name: " + name + "\n" +
                    "Roll Number: " + roll + "\n" +
                    "Age: " + age + "\n" +
                    "Class: " + cls + "\n" +
                    "Email: " + email
            );
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            rollField.setText("");
            ageField.setText("");
            classField.setText("");
            emailField.setText("");
            displayArea.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentFormApp().setVisible(true);
        });
    }
}
