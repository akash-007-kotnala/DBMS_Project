package hotel.management;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame{

    private JPanel contentPane;
    private JTextField t2, t4;
    private JComboBox comboBox, comboBox_2, comboBox_3;
    JButton b1, b2;
    Choice c1;

    public AddRoom(Admin parent) {
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
        JLabel l10 = new JLabel("ADD ROOMS");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(194, 10, 120, 22);
        contentPane.add(l10);

//        Adding Romms Number.
        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 120, 22);
        contentPane.add(l1);

        t4 = new JTextField();
        t4.setBounds(195, 70, 156, 20);
        contentPane.add(t4);

//      Availability of the rooms..
        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 120, 22);
        contentPane.add(l2);

//      ComboBox for giving the option for the user...
        comboBox = new JComboBox(new String[]{"Available", "Occupied"});
        comboBox.setBounds(195, 110, 154, 20);
        contentPane.add(comboBox);

//      Mentioning the status of the Room..
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 120, 22);
        contentPane.add(l3);

        comboBox_2 = new JComboBox(new String[]{"Cleaned", "Dirty"});
        comboBox_2.setBounds(195, 150, 154, 20);
        contentPane.add(comboBox_2);

//        Price Tag for the room..
        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 195, 120, 22);
        contentPane.add(l4);

        t2 = new JTextField();
        t2.setBounds(195, 195, 156, 20);
        contentPane.add(t2);

//        Type of the bed..
        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 120, 22);
        contentPane.add(l5);

        comboBox_3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        comboBox_3.setBounds(195, 230, 154, 20);
        contentPane.add(comboBox_3);

//      Add Button.
        b1 = new JButton("Add");
        b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                        try {
                                conn c = new conn();
                                String room = t4.getText();
                                String available = (String) comboBox.getSelectedItem();
                                String status = (String) comboBox_2.getSelectedItem();
                                String price = t2.getText();
                                String type = (String) comboBox_3.getSelectedItem();
                                String str = "INSERT INTO room values( '" + room + "', '" + available + "', '" + status + "','" + price + "', '" + type + "')";
            
                                c.s.executeUpdate(str);
                                JOptionPane.showMessageDialog(null, "Room Successfully Added");
            
                            } catch (Exception ee) {
                                System.out.println(ee);
                                JOptionPane.showMessageDialog(null, ee.getMessage());;
                            }
                }
            });
        contentPane.add(b1);

//       Back Button..
        b2 = new JButton("Back");
        b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                        parent.setVisible(true);
                        dispose();
                }
            });
        contentPane.add(b2);

//        Setting the background of the panel as white..	
        contentPane.setBackground(Color.WHITE);

    }
}
