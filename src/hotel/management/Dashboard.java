package hotel.management;

import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public Dashboard(Login parent, String username, int admin) {
        super("HOTEL MANAGEMENT APP");
        Dashboard curr = this;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setForeground(Color.CYAN);
        setLayout(null);
        JButton b_reception, b_admin, b_logout;
        JPanel container;
        
        
        
//        To set the image..
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/nalanda.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000);
        add(NewLabel);

//        Heading at the top..
        JLabel l_welcome = new JLabel("The Hotel Nalanda Welcomes You");
        l_welcome.setForeground(Color.BLACK);
        l_welcome.setFont(new Font("Tahoma", Font.PLAIN, 46));
        l_welcome.setBounds(400, 60, 1000, 85);
        NewLabel.add(l_welcome);   

        
        container = new JPanel();
        container.setBackground(Color.WHITE);
        container.setLayout(null);
        container.setBounds(470, 460, 580, 200);
        NewLabel.add(container);

        int x1,x2;

        if(admin != 1)
        {
           
            JLabel UserWelcome = new JLabel("Welcome " + username);
            UserWelcome.setForeground(Color.RED);
            UserWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
            UserWelcome.setBounds(220, 10, 1000, 85);
            container.add(UserWelcome);
            x1= 110;
            x2= 330;
        }
        else{
          
            JLabel UserWelcome = new JLabel("Welcome " + username + " (Admin)");
            UserWelcome.setForeground(Color.RED);
            UserWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
            UserWelcome.setBounds(150, 10, 1000, 85);
            container.add(UserWelcome);
            x1=40;
            x2=400;
        }
        
        b_logout = new JButton("LOGOUT");
        b_logout.setBounds(x2, 120, 160, 40);
        b_logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        b_logout.setBackground(Color.RED);
        b_logout.setForeground(Color.WHITE);
        b_logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try 
                {   
                    parent.setVisible(true);
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        container.add(b_logout);
        
        b_reception = new JButton("RECEPTION");
        b_reception.setBounds(x1, 120, 160, 40);
        b_reception.setFont(new Font("Tahoma", Font.BOLD, 15));
        b_reception.setBackground(Color.BLACK);
        b_reception.setForeground(Color.WHITE);
        b_reception.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Reception(curr,parent);
            }
        });
        container.add(b_reception);
        
        
        b_admin = new JButton("ADMIN");
        b_admin.setBounds(220, 120, 160, 40);
        b_admin.setFont(new Font("Tahoma", Font.BOLD, 15));
        b_admin.setBackground(Color.BLACK);
        b_admin.setForeground(Color.WHITE);

        if(admin==1)
        {
            container.add(b_admin);
        }

        b_admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Admin(curr,username);
            }
        });
        container.add(b_reception);      
        

        setSize(1950, 1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        //new Dashboard().setVisible(true);
    }

    Dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
