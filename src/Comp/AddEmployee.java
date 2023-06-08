package Comp;

import JDBC.JdbcConnectivity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddEmployee {
    private JFrame frame;
    private JTextField tf1, tf2, tf4, tf5, tf6, tf7;
    private JLabel lb1, lb2, lb4, lb5, lb6, lb7;

    public AddEmployee() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setTitle("Add Employee");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lb1 = createLabel("Enter Employee First Name:", 45, 120);
        frame.getContentPane().add(lb1);
        tf1 = createTextField(270, 120);
        frame.getContentPane().add(tf1);

        lb2 = createLabel("Enter Employee Last Name:", 500, 120);
        frame.getContentPane().add(lb2);
        tf2 = createTextField(745, 120);
        frame.getContentPane().add(tf2);

        lb4 = createLabel("Enter Employee ID:", 45, 220);
        frame.getContentPane().add(lb4);
        tf4 = createTextField(270, 220);
        frame.getContentPane().add(tf4);

        lb5 = createLabel("Enter Employee Phone Number:", 500, 220);
        frame.getContentPane().add(lb5);
        tf5 = createTextField(745, 220);
        frame.getContentPane().add(tf5);

        lb6 = createLabel("Enter Employee Email ID:", 45, 320);
        frame.getContentPane().add(lb6);
        tf6 = createTextField(270, 320);
        frame.getContentPane().add(tf6);

        lb7 = createLabel("Create Employee Password:", 500, 320);
        frame.getContentPane().add(lb7);
        tf7 = createTextField(745, 320);
        frame.getContentPane().add(tf7);

        JButton submitButton = createButton("Submit", 350, 450, 100, 40);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ID = Integer.parseInt(tf4.getText());
                String firstName = tf1.getText();
                String lastName = tf2.getText();
                long phoneNumber = Long.parseLong(tf5.getText());
                String email = tf6.getText();
                String password = tf7.getText();
                
                System.out.println(firstName+lastName+phoneNumber+email+password);
                JOptionPane.showMessageDialog(frame,"Employee Added Successfully","Message",JOptionPane.WARNING_MESSAGE);
				JdbcConnectivity jd = new JdbcConnectivity();
				jd.AddEmpDetails(ID, firstName, lastName, phoneNumber, email, password);
				
            }
        });
        frame.getContentPane().add(submitButton);
        
        JButton backButton = createButton("Back", 20, 20, 80, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AdminPage adminpage=new AdminPage();
            }
        });
        frame.getContentPane().add(backButton);

        frame.setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 250, 30);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.BLUE);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 200, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        return textField;
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(59, 89, 182));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        return button;
    }
}