/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Ashirbad
 */
public class UpdateRoom extends JFrame{

    private JPanel contentPane;
    private JTextField t_price;
    private Choice c_room_no;
    private JComboBox c_aval, c_clean, c_bed;
    JButton b1, b2, b3,b4;
    Choice c1;

    public UpdateRoom(Admin parent) {
        setBounds(300, 200, 1000, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

//        Image Loader..     
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(420, 30, 500, 370);
        add(l15);

//        Adding Rooms(Title..)
        JLabel l10 = new JLabel("UPDATE/REMOVE ROOMS");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(180, 10, 240, 22);
        contentPane.add(l10);

//        Adding Romms Number.
        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 120, 22);
        contentPane.add(l1);

        c_room_no = new Choice();
        c_room_no.setBounds(195, 70, 110, 20);
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while (rs.next()) {
                c_room_no.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
        }
        contentPane.add(c_room_no);

        b3 = new JButton("Fetch");
        b3.setBounds(306, 70, 70, 21);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        contentPane.add(b3);


//      Availability of the rooms..
        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 120, 22);
        contentPane.add(l2);

//      ComboBox for giving the option for the user...
        c_aval = new JComboBox(new String[]{"Available", "Occupied"});
        c_aval.setBounds(195, 110, 180, 20);
        contentPane.add(c_aval);

//      Mentioning the status of the Room..
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 120, 22);
        contentPane.add(l3);

        c_clean = new JComboBox(new String[]{"Cleaned", "Dirty"});
        c_clean.setBounds(195, 150, 180, 20);
        contentPane.add(c_clean);

//        Price Tag for the room..
        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 120, 22);
        contentPane.add(l4);

        t_price = new JTextField();
        t_price.setBounds(195, 190, 180, 20);
        contentPane.add(t_price);

//        Type of the bed..
        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 120, 22);
        contentPane.add(l5);

        c_bed = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c_bed.setBounds(195, 230, 180, 20);
        contentPane.add(c_bed);

//      Add Button.
        b1 = new JButton("Update");
        b1.setBounds(155, 321, 110, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                        try {
                                conn c = new conn();
                                String room_no = c_room_no.getSelectedItem();
                                String available = (String) c_aval.getSelectedItem();
                                String status = (String) c_clean.getSelectedItem();
                                String price = t_price.getText();
                                String type = (String) c_bed.getSelectedItem();
                                String str = "update room set availability= '" + available + "', clean_status= '" 
                                            + status + "', price= '" + price + "', bed_type= '" + type + "' where room_number ='"+room_no+"'";
                                c.s.executeUpdate(str);
                                JOptionPane.showMessageDialog(null, "Successfully Updated");
                            } catch (Exception ee) {
                                ee.printStackTrace();
                                JOptionPane.showMessageDialog(null, ee.getMessage());
                            }
                }
            });
        contentPane.add(b1);

//       Back Button..
        b2 = new JButton("Back");
        b2.setBounds(270, 321, 110, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                        parent.setVisible(true);
                        dispose();
                }
            });

        b4 = new JButton("Delete");
        b4.setBounds(40, 321, 110, 33);
        b4.setBackground(Color.RED);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        conn c = new conn();
                        String room_no = c_room_no.getSelectedItem();

                        // check if it is occupied
                        String str1= "select availability from room where room_number= '"+room_no+"'";

                        ResultSet rs1 = c.s.executeQuery(str1);

                        while(rs1.next()){
                            String aval = rs1.getString("availability");
                            if(aval.equals("Occupied")){
                                throw new Exception("Can't remove room! Room is Occupied.");
                            }
                        }

                        String str2 = "delete from room where room_number= '"+room_no+"'"; 
                        c.s.executeUpdate(str2);
                        JOptionPane.showMessageDialog(null, "Successfully Deleted");
                        c_room_no.removeAll();
                        try {
                            ResultSet rs = c.s.executeQuery("select * from room");
                            while (rs.next()) {
                                c_room_no.add(rs.getString("room_number"));
                            }
                        } catch (Exception e) {
                        }
                        
                    } catch (Exception ee) {
                        ee.printStackTrace();
                        JOptionPane.showMessageDialog(null, ee.getMessage());
                    }
                }
            });
        

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                    try {
                            conn c = new conn();
                            String room_number = c_room_no.getSelectedItem();
                            String str = "select * from room where room_number="+room_number;
                            ResultSet rs = c.s.executeQuery(str);
                            while (rs.next()) {
                                c_aval.setSelectedItem(rs.getString("availability"));
                                c_bed.setSelectedItem(rs.getString("bed_type"));
                                c_clean.setSelectedItem(rs.getString("clean_status"));
                                t_price.setText(rs.getString("price"));
                            }
        
                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
            }
        });
        contentPane.add(b2);
        contentPane.add(b4);

//        Setting the background of the panel as white..	
        contentPane.setBackground(Color.WHITE);

    }
}
