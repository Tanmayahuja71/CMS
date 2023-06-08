package Comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JDBC.JdbcConnectivity;

public class AddIteams {
    private JFrame frame;
    private JTextField tf1, tf2, tf4, tf5, tf6, tf7;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    private JComboBox<String> jc1;

    public AddIteams() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 700);
        frame.setContentPane(new JLabel(new ImageIcon("add.jpg"))); // Set the background image
        frame.setLayout(null);
        frame.setTitle("Add Item");

        lb1 = createLabel("Enter Item Name:", 200, 120, 300, 40, 24);
        frame.add(lb1);

        tf1 = createTextField(520, 120, 200, 30, 18);
        frame.add(tf1);

        lb2 = createLabel("Enter Item Id:", 200, 180, 300, 40, 24);
        frame.add(lb2);

        tf2 = createTextField(520, 180, 200, 30, 18);
        frame.add(tf2);

        lb3 = createLabel("Select Unit:", 200, 240, 300, 40, 24);
        frame.add(lb3);

        String[] modes = { "-Select-", "plate", "bowl", "half", "full" };
        jc1 = new JComboBox<>(modes);
        jc1.setBounds(520, 240, 200, 30);
        frame.add(jc1);

        lb4 = createLabel("Enter Weight:", 200, 300, 300, 40, 24);
        frame.add(lb4);

        tf4 = createTextField(520, 300, 200, 30, 18);
        frame.add(tf4);

        lb5 = createLabel("Enter Price:", 200, 360, 300, 40, 24);
        frame.add(lb5);

        tf5 = createTextField(520, 360, 200, 30, 18);
        frame.add(tf5);

        lb6 = createLabel("Enter Discount:", 200, 420, 300, 40, 24);
        frame.add(lb6);

        tf6 = createTextField(520, 420, 200, 30, 18);
        frame.add(tf6);

        lb7 = createLabel("Enter Total Qty:", 200, 480, 300, 40, 24);
        frame.add(lb7);

        tf7 = createTextField(520, 480, 200, 30, 18);
        frame.add(tf7);

        JButton bt1 = createButton("Submit", 450, 550, 150, 50, new Color(52, 152, 219), Color.WHITE, 20);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itmName = tf1.getText();
                int itmId = Integer.parseInt(tf2.getText());
                String itmMeasUnit = (String) jc1.getSelectedItem();
                int itmQty = Integer.parseInt(tf4.getText());
                int itmPrice = Integer.parseInt(tf5.getText());
                int itmDiscount = Integer.parseInt(tf6.getText());
                int stock = Integer.parseInt(tf7.getText());

                JdbcConnectivity jc = new JdbcConnectivity();
                jc.AddStockDetails(itmName, itmId, itmQty, itmMeasUnit, itmPrice, itmDiscount, stock);

                JOptionPane.showMessageDialog(frame, "Item added successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                AdminPage adminPage = new AdminPage();
            }
        });
        frame.add(bt1);

        JButton btnBack = createButton("Back", 20, 20, 150, 50, new Color(255, 128, 0), Color.WHITE, 20);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current add item page
                String role = (String) jc1.getSelectedItem();
                
                if (role.equals("ADMIN")) {
                    AdminPage adminPage = new AdminPage(); // Open the AdminPage
                } else if (role.equals("EMPLOYEE")) {
                    SalesBoyPage salesBoyPage = new SalesBoyPage(); // Open the SalesBoyPage
                }
            }
        });

        frame.add(btnBack);

        frame.setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setForeground(Color.BLUE);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height, int fontSize) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(new Font("Arial", Font.PLAIN, fontSize));
        return textField;
    }

    private JButton createButton(String text, int x, int y, int width, int height, Color bgColor, Color fgColor,
            int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return button;
    }
}