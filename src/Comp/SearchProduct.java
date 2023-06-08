package Comp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import JDBC.JdbcConnectivity;

public class SearchProduct {
	JFrame f1;
	public SearchProduct() {
		f1 = new JFrame();
		f1.setBounds(100,100,700,400);
		
		f1.setTitle("statistics");
		
		String ProductName = JOptionPane.showInputDialog("Enter Product Name:");
		
		JdbcConnectivity jd = new JdbcConnectivity();
		String [] record= jd.fetchProductDetails(ProductName);
		
		String[] columnName= {"PRODUCT_ID","PRODUCT_NAME","QTY","MES_UNIT","MRP","DISCOUNT","AFTER_DISCOUNT"};
		String[][] data = {{record[0],record[1],record[2],record[3],record[4],record[5],record[6]}};
		
		JTable table = new JTable(data,columnName);
		
		f1.add(new JScrollPane(table));
		
		f1.setVisible(true);
	}
}
