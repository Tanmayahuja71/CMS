package Comp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SalesBoyPage {
    JFrame frame;

    public SalesBoyPage() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton bt1 = new JButton("Stock Update");
        bt1.setBackground(Color.BLUE);
        bt1.setForeground(Color.WHITE);
        bt1.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(bt1, gbc);

        JButton bt2 = new JButton("Take Order");
        bt2.setBackground(Color.BLUE);
        bt2.setForeground(Color.WHITE);
        bt2.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(bt2, gbc);

        JButton bt3 = new JButton("Statistics");
        bt3.setBackground(Color.BLUE);
        bt3.setForeground(Color.WHITE);
        bt3.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        frame.add(bt3, gbc);

        JButton bt4 = new JButton("About");
        bt4.setBackground(Color.BLUE);
        bt4.setForeground(Color.WHITE);
        bt4.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(bt4, gbc);

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(exitButton, gbc);

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(backButton, gbc);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StockUpdate su = new StockUpdate();
                frame.dispose(); // Close the current SalesBoyPage window
            }
        });

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current SalesBoyPage window
                Statistics st = new Statistics();
            }
        });

        bt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                About ab = new About();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current SalesBoyPage window
                LoginPage loginPage = new LoginPage();
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}