/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Ashirbad
 */
public class UpdateMyDetail extends JFrame {
//This is Third Frame

    JTextField t_username; 
    JPasswordField t_pass, t_repass;
    JComboBox c_auth;

    public UpdateMyDetail(Admin parent, String username) {
//         The Title At the top.. Background of the Image...
        getContentPane().setForeground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD APPLICATION USER");

        //setSize(778, 360);
        getContentPane().setLayout(null);

//            TextField for the NAME..
        JLabel l_username = new JLabel("NEW USERNAME");
        l_username.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_username.setBounds(60, 90, 200, 27);
        add(l_username);

        t_username = new JTextField();
        t_username.setBounds(280, 90, 150, 27);
        add(t_username);

//            Add Button ..
        JButton Update = new JButton("UPDATE");
        Update.setBounds(80, 340, 150, 30);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        add(Update);

        JButton Back = new JButton("BACK");
        Back.setBounds(250, 340, 150, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        add(Back);

//            For l_pass..
        JLabel l_pass = new JLabel("ENTER PASSWORD");
        l_pass.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_pass.setBounds(60, 150, 200, 27);
        add(l_pass);

        t_pass = new JPasswordField();
        t_pass.setBounds(280, 150, 150, 27);
        add(t_pass);

        JLabel l_repass = new JLabel("RE-ENTER PASSWORD");
        l_repass.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_repass.setBounds(60, 210, 200, 27);
        add(l_repass);

        t_repass = new JPasswordField();
        t_repass.setBounds(280, 210, 150, 27);
        add(t_repass);

//        For JOB...    
        JLabel l_auth = new JLabel("AUTHORIZATION");
        l_auth.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_auth.setBounds(60, 270, 200, 27);
        add(l_auth);

        String course[] = {"Admin","Standard"};
        c_auth = new JComboBox(course);
        c_auth.setBackground(Color.WHITE);
        c_auth.setBounds(280, 270, 150, 30);
        add(c_auth);

        setVisible(true);

//            Heading at the top of the Image..
        JLabel l_add_emp = new JLabel("UPDATE MY DETAILS");
        l_add_emp.setForeground(Color.BLACK);
        l_add_emp.setFont(new Font("Tahoma", Font.PLAIN, 31));
        l_add_emp.setBounds(80, 20, 442, 35);
        add(l_add_emp);

//     For IMAGE..
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 20, 480, 410);
        add(image);

        Update.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    String new_username= t_username.getText();
                    String pass = new String(t_pass.getPassword());
                    String repass = new String(t_repass.getPassword());
                    String auth = (String)c_auth.getSelectedItem();
    
                    try {
                            
                        if(!pass.equals(repass)){
                                throw  new Exception("Password do not match!");
                        }
    
                        if(new_username.equals(" ") || new_username.isBlank()){
                            new_username=username;
                        }
                        conn c = new conn();
                        
                        ResultSet rs = c.s.executeQuery("select count(*) as count from login where username = '"+username+"'");
                        
                        while(rs.next()){
                            int size = Integer.parseInt(rs.getString("count"));
                            if(size==0){
                                    throw  new Exception("Username not found!");
                            }
                        }
                        String str = "update login set username= '" + new_username + "', password='" + pass + "', authorization='" + auth+ "' where username= '"+username+"'";
    
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null, "Successfully Updated");
    
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, e.getMessage() );
                    }
                }
            });

        Back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                        dispose();
                        parent.setVisible(true);
                }
            });

        setSize(900, 440);
        setVisible(true);
        setLocation(360, 250);

    }
}

