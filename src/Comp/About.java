package Comp;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.*;
import javax.swing.text.*;
public class About {
	JFrame f1;
	
	public About(){
		f1 = new JFrame();
		f1.setBounds(100,100,1000,700);
		f1.setLayout(null);
		
		
		JTextPane jtp= new JTextPane();
		jtp.setText("Hello this is about page");
		
		
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setBold(attr,true);
		jtp.setCharacterAttributes(attr,true);
		f1.getContentPane().add(jtp);
		
		f1.getContentPane().add(jtp);
		
		f1.setVisible(true);
	}
}
