package Comp;
import javax.swing.*;
import JDBC.JdbcConnectivity;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.Image;

class TransparentPanel extends JPanel {
    private Image backgroundImage;

    public TransparentPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}


class LoginPages {
    JFrame f1;
    JTextField tf1;
    JPasswordField pf2;
    JComboBox<String> jc1;
    int adminId = 123;
    String adminPass = "pass123";

    public void MyFrame() {
        f1 = new JFrame();
        f1.setBounds(100, 100, 1000, 600);
        f1.setTitle("LoginForm");

        // Add background image        
        String imagePath = "C:\\Users\\Tanmay Ahuja\\Downloads/canteen.png";
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Tanmay Ahuja\\Downloads/canteen.png");
        Image image = imageIcon.getImage().getScaledInstance(f1.getWidth(), f1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        TransparentPanel backgroundPanel = new TransparentPanel(resizedImageIcon.getImage());
        backgroundPanel.setLayout(null);
        f1.setContentPane(backgroundPanel);

        JLabel lb1 = new JLabel("USERNAME");
        lb1.setForeground(Color.WHITE);
        lb1.setBounds(300, 180, 100, 20);
        lb1.setOpaque(true);  
        lb1.setBackground(new Color(0, 0, 0, 150)); 
        lb1.setFont(new Font("Arial", Font.BOLD, 14)); 
        backgroundPanel.add(lb1);

        tf1 = new JTextField();
        tf1.setBounds(420, 180, 120, 20);
        backgroundPanel.add(tf1);

        JLabel lb2 = new JLabel("PASSWORD");
        lb2.setForeground(Color.WHITE);
        lb2.setBounds(300, 230, 100, 20);
        lb2.setOpaque(true);  
        lb2.setBackground(new Color(0, 0, 0, 150));  
        lb2.setFont(new Font("Arial", Font.BOLD, 14)); 
        backgroundPanel.add(lb2);

        pf2 = new JPasswordField();
        pf2.setBounds(420, 230, 120, 20);
        backgroundPanel.add(pf2);

        JLabel lb3 = new JLabel("USERROLE");
        lb3.setForeground(Color.WHITE);
        lb3.setBounds(300, 280, 100, 20);
        lb3.setOpaque(true);  
        lb3.setBackground(new Color(0, 0, 0, 150));  
        lb3.setFont(new Font("Arial", Font.BOLD, 14));
        backgroundPanel.add(lb3);

        String[] modes = {"-SELECT-", "ADMIN", "EMPLOYEE"};
        jc1 = new JComboBox<String>(modes);
        jc1.setBounds(420, 280, 120, 20);
        backgroundPanel.add(jc1);

        JButton bt1 = new JButton("LOGIN");
        bt1.setBounds(370, 330, 100, 30);
        bt1.setBackground(new Color(52, 152, 219)); 
        bt1.setForeground(Color.WHITE); 
        bt1.setFont(new Font("Arial", Font.BOLD, 14)); 
        bt1.setFocusPainted(false); 
        backgroundPanel.add(bt1);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf1.getText());
                char[] passwordChars = pf2.getPassword();
                String password = new String(passwordChars);

                String mode = (String) jc1.getSelectedItem();

                if (mode.equals("ADMIN")) {
                    if (password.equals(adminPass) && id == adminId) {
                        System.out.println("Admin login successful");
                        JOptionPane.showMessageDialog(f1,"Successfully Login As Admin","Message",JOptionPane.WARNING_MESSAGE);
                        AdminPage adminPage = new AdminPage();
                    } else {
                        JOptionPane.showMessageDialog(f1, "Enter correct Password", mode, JOptionPane.WARNING_MESSAGE);
                    }
                } else if (mode.equals("EMPLOYEE")) {
                    System.out.println("Employee login successful");
                    JOptionPane.showMessageDialog(f1,"Successfully Login As Employee","Message",JOptionPane.WARNING_MESSAGE);
                    JdbcConnectivity Myjdbc = new JdbcConnectivity();
					String salesPass = Myjdbc.FetchPassword(id);
					if(password.equals(salesPass)){
						SalesBoyPage sbp = new SalesBoyPage();
					}
					else {
						JOptionPane.showMessageDialog(f1,"Enter correct UserName And Password","Message",JOptionPane.WARNING_MESSAGE);
					}
                } else {
                    JOptionPane.showMessageDialog(f1, "Select Mode", "Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(500, 330, 80, 30);
        exitButton.setBackground(new Color(231, 76, 60)); 
        exitButton.setForeground(Color.WHITE); 
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        backgroundPanel.add(exitButton);

        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class LoginPage {
    public static void main(String args[]) {
        LoginPages obj1 = new LoginPages();
        obj1.MyFrame();
    }
}