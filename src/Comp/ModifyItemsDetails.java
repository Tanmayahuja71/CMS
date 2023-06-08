package Comp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import JDBC.JdbcConnectivity;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ModifyItemsDetails {
    JFrame frame;
    JTextField tf1, tf2, tf3, tf4;

    JToggleButton addStockToggle;
    JToggleButton modifyPriceToggle;
    JToggleButton modifyDiscountToggle;

    JComboBox<String> jc1;
    public ModifyItemsDetails() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setLayout(null);
        frame.setTitle("Modify Item Details");

        // Set background image
        ImageIcon backgroundImageIcon = new ImageIcon("add.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(resizedBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
        ((JPanel) frame.getContentPane()).setOpaque(false);

        addStockToggle = new JToggleButton("Add Stock");
        addStockToggle.setBounds(200, 150, 150, 50);
        addStockToggle.setFont(new Font("Arial", Font.BOLD, 16));
        addStockToggle.setForeground(Color.WHITE);
        addStockToggle.setBackground(new Color(52, 152, 219));
        frame.add(addStockToggle);

        tf1 = new JTextField();
        tf1.setBounds(370, 150, 120, 30);
        frame.add(tf1);

        modifyPriceToggle = new JToggleButton("Modify Price");
        modifyPriceToggle.setBounds(200, 220, 150, 50);
        modifyPriceToggle.setFont(new Font("Arial", Font.BOLD, 16));
        modifyPriceToggle.setForeground(Color.WHITE);
        modifyPriceToggle.setBackground(new Color(52, 152, 219));
        frame.add(modifyPriceToggle);

        tf2 = new JTextField();
        tf2.setBounds(370, 220, 120, 30);
        frame.add(tf2);

        modifyDiscountToggle = new JToggleButton("Modify Discount");
        modifyDiscountToggle.setBounds(200, 290, 150, 50);
        modifyDiscountToggle.setFont(new Font("Arial", Font.BOLD, 16));
        modifyDiscountToggle.setForeground(Color.WHITE);
        modifyDiscountToggle.setBackground(new Color(52, 152, 219));
        frame.add(modifyDiscountToggle);

        tf3 = new JTextField();
        tf3.setBounds(370, 290, 120, 30);
        frame.add(tf3);

        JLabel jl1 = new JLabel("Enter Product Name:");
        jl1.setBounds(200, 80, 200, 30);
        jl1.setFont(new Font("Arial", Font.BOLD, 16));
        jl1.setForeground(Color.BLUE);
        frame.add(jl1);

        JButton bt1 = createButton("Submit", 300, 380, 120, 40, new Color(46, 204, 113), Color.WHITE, 20);
        frame.add(bt1);
//     // Add the following code after the declaration of tf4 variable
//     jc1 = new JComboBox<>(new String[]{"ADMIN", "EMPLOYEE"});
//        jc1.setBounds(370, 120, 150, 30);
//        frame.add(jc1);

        tf4 = new JTextField();
        tf4.setBounds(370, 80, 150, 30);
        frame.add(tf4);


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

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JdbcConnectivity MyJdbc = new JdbcConnectivity();
                String productName = tf4.getText();

                if (addStockToggle.isSelected()) {
                    String addStockText = tf1.getText();
                    if (!addStockText.isEmpty()) {
                        int addStock = Integer.parseInt(addStockText);
                        MyJdbc.UpdateTotalStock(productName, addStock);
                    }
                }

                if (modifyPriceToggle.isSelected()) {
                    String MRPText = tf2.getText();
                    if (!MRPText.isEmpty()) {
                        int MRP = Integer.parseInt(MRPText);
                        MyJdbc.UpdateMRP(productName, MRP);
                    }
                }

                if (modifyDiscountToggle.isSelected()) {
                    String discountText = tf3.getText();
                    if (!discountText.isEmpty()) {
                        int discount = Integer.parseInt(discountText);
                        MyJdbc.UpdateDiscount(productName, discount);
                    }
                }

                JOptionPane.showMessageDialog(frame, "Modifications successfully added!");

                frame.dispose(); // Close the current frame
                AdminPage adminPage = new AdminPage(); // Create an instance of AdminPage
                adminPage.initialize(); // Show the AdminPage frame
            }
        });

    


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private JButton createButton(String text, int x, int y, int width, int height, Color bgColor, Color fgColor, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setFocusPainted(false);
        return button;
    }
}