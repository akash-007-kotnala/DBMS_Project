package hotel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame{

//    All the variable(global Declarations..)
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

//    Constructor..
    Login(HotelManagement parent) {
        
        super("Login");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);
        
        Login l = this;
        
        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String u = t1.getText();
                String v = new String(t2.getPassword());
                conn c = new conn();

         
               String q = "select * from login where username=? and password=?";
                
              
                 
                
                
                try {
             
                    PreparedStatement ps=c.c.prepareStatement(q);
                    ps.setString(1,u);
                    ps.setString(2, v);
                    ResultSet rs = ps.executeQuery();
                  
                    if(rs.next()) {
                        int admin;
                        String username = rs.getString("username");
                       if( rs.getString("authorization").equals("Admin"))
                       { 
                            admin = 1;
                       }
                       else
                       {
                            admin = 0;
                       }
                         Dashboard obj = new Dashboard(l,username,admin);
                          obj.setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid UserName or Password");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.setVisible(true);
            }
        });
        add(b2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500, 300, 600, 260);
        setVisible(true);
    }

    public static void main(String args[]) {
        //new Login();
    }
}
