package Comp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import JDBC.JdbcConnectivity;

public class DeleteIteams {
	JFrame f1;
	JTextField tf1,tf2;
	public DeleteIteams(){
		f1 = new JFrame();
		f1.setBounds(100,100,400,300);
		f1.setLayout(null);
		f1.setTitle("DeleteAccount");
		
		
		JLabel lb1 = new JLabel("ENTER PRODUCT ID");
		lb1.setBounds(150,90,170,20);
		f1.add(lb1);
		
		tf1 = new JTextField();
		tf1.setBounds(137,120,120,20);
		f1.add(tf1);
		
		
		JButton bt1 = new JButton("Delete");
		bt1.setBounds(154, 158, 80, 20);
		f1.add(bt1);
		
		bt1.addActionListener(new ActionListener(){
			boolean flag = true;
			public void actionPerformed(ActionEvent e) {
				int itemId = Integer.parseInt(tf1.getText());
				JOptionPane.showMessageDialog(f1,"Item Deleted Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
				JdbcConnectivity Myjdbc= new JdbcConnectivity();
				flag = Myjdbc.DeleteIteam(itemId);
			}	
		});
		
		f1.setVisible(true);
	}
}
