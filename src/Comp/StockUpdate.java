package Comp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StockUpdate {
    JFrame f1;

    public StockUpdate() {
        f1 = new JFrame();
        f1.setBounds(100, 100, 1000, 600);
        f1.setLayout(new GridBagLayout());
        f1.setTitle("Stock Update");
        f1.getContentPane().setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);

        JButton bt1 = createButton("Search Item", 0, 0, gbc);
        JButton bt2 = createButton("Add Item", 1, 0, gbc);
        JButton bt3 = createButton("Modify Item", 0, 1, gbc);
        JButton bt4 = createButton("Delete Item", 1, 1, gbc);
        JButton backButton = createButton("Back", 0, 2, gbc, Color.GRAY);
        JButton exitButton = createButton("Exit", 1, 2, gbc, Color.RED);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        bt1.setFont(buttonFont);
        bt2.setFont(buttonFont);
        bt3.setFont(buttonFont);
        bt4.setFont(buttonFont);
        backButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchProduct sp = new SearchProduct();
            }
        });

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddIteams ai = new AddIteams();
            }
        });

        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModifyItemsDetails mi = new ModifyItemsDetails();
            }
        });

        bt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	DeleteIteams di = new DeleteIteams();
                
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the LoginPage
                LoginPage loginPage = new LoginPage();
                f1.dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private JButton createButton(String text, int gridx, int gridy, GridBagConstraints gbc) {
        JButton button = new JButton(text);
        button.setPreferredSize(new java.awt.Dimension(150, 120));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        gbc.gridx = gridx;
        gbc.gridy = gridy;

        f1.add(button, gbc);
        return button;
    }

    private JButton createButton(String text, int gridx, int gridy, GridBagConstraints gbc, Color color) {
        JButton button = createButton(text, gridx, gridy, gbc);
        button.setBackground(color);
        return button;
    }
}