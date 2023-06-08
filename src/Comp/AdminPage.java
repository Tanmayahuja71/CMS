package Comp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminPage {
    private JFrame frame;

    public AdminPage() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setTitle("Admin Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK); // Set background color to black
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns with 10px spacing
        frame.setContentPane(panel);

        JButton btnAddEmployee = createButton("Add Employee");
        btnAddEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddEmployee addEmployee = new AddEmployee();
            }
        });
        panel.add(btnAddEmployee);

        JButton btnRemoveEmployee = createButton("Remove Employee");
        btnRemoveEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteEmpAccount deleteEmpAccount = new DeleteEmpAccount();
            }
        });
        panel.add(btnRemoveEmployee);

        JButton btnAddItems = createButton("Add Items");
        btnAddItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddIteams addIteams = new AddIteams();
            }
        });
        panel.add(btnAddItems);

        JButton btnModifyItems = createButton("Modify Items");
        btnModifyItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModifyItemsDetails modifyItemsDetails = new ModifyItemsDetails();
            }
        });
        panel.add(btnModifyItems);

        JButton btnDeleteItems = createButton("Delete Items");
        btnDeleteItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteIteams deleteItems = new DeleteIteams();
            }
        });
        panel.add(btnDeleteItems);

        JButton btnStatistics = createButton("Statistics");
        btnStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Statistics statistics = new Statistics();
            }
        });
        panel.add(btnStatistics);

        JButton btnExit = createButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnExit);

        JButton btnBack = createButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginPage loginPage = new LoginPage();
            }
        });
        panel.add(btnBack);

        frame.setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(59, 89, 182)); // Set button background color to blue
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Increased font size
        button.setFocusPainted(false);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        return button;
    }
}
