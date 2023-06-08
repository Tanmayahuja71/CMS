package Comp;


import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import JDBC.JdbcConnectivity;

public class Statistics {
    JFrame frame;
    JTable table;
    String[] columnNames = { "Time Period", "Total Amount", "Discount", "Total Amount After Discount" };

    public Statistics() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setTitle("Statistics");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);

        JdbcConnectivity jdbc = new JdbcConnectivity();
        int[] record = jdbc.fetchStatistics();
        Object[][] data = {
                { "Today", record[0], record[1], record[2] },
                { "Week", record[3], record[4], record[5] },
                { "Month", record[6], record[7], record[8] },
                { "Year", record[9], record[10], record[11] }
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        // Center align the cell content
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Set font for table headers
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // Increased font size

        // Set font for table content
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
        table.setForeground(Color.DARK_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 900, 400);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}