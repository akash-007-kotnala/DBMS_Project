/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ashirbad
 */
public class CheckOut extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t_room_no;
    Choice c_id_number, c2, c1;

    /**
     * Launch the application.
     */
/*    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOut frame = new CheckOut();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    */

    public void close() {
        this.dispose();
    }

    /**
     * Create the frame.
     *
     * @throws SQLException
     */
    public CheckOut(Reception parent) throws SQLException {
        //conn = Javaconnect.getDBConnection();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 200, 850, 294);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(340, 0, 500, 225);
        add(l1);

        JLabel lblCheckOut = new JLabel("Check Out ");
        lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCheckOut.setBounds(70, 11, 140, 35);
        contentPane.add(lblCheckOut);

        JLabel l_id_type = new JLabel("ID TYPE :");
        l_id_type.setBounds(25, 80, 90, 14);
        contentPane.add(l_id_type);

        Choice c_id_type = new Choice();
        c_id_type.add("Passport");
        c_id_type.add("Aadhar Card");
        c_id_type.add("Voter Id");
        c_id_type.add("Driving license");
        c_id_type.setBounds(130, 80, 130, 20);
        contentPane.add(c_id_type);

        JLabel l_id_num = new JLabel("ID NUMBER:");
        l_id_num.setBounds(25, 120, 90, 14);
        contentPane.add(l_id_num);

        c_id_number = new Choice();
        c_id_number.setBounds(130, 117, 203, 20);
        contentPane.add(c_id_number);

        JButton b_id_num = new JButton("fetch");

        b_id_num.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    c_id_number.removeAll();
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where id_type = '" + c_id_type.getSelectedItem() + "'");
                    while (rs.next()) {
                        c_id_number.add(rs.getString("id_number"));
                    }
                } catch (Exception e) {
                }
            }
        });

        b_id_num.setBounds(265, 80, 70, 21);
        b_id_num.setBackground(Color.WHITE);
        b_id_num.setForeground(Color.BLACK);
        contentPane.add(b_id_num);

        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setBounds(20, 160, 86, 20);
        contentPane.add(lblRoomNumber);

        t_room_no = new JTextField();
        t_room_no.setBounds(130, 160, 182, 20);
        contentPane.add(t_room_no);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l2 = new JButton(i6);
        l2.setBounds(313, 160, 20, 20);
        add(l2);

        l2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                try {

                    conn c = new conn();
                    String type = c_id_type.getSelectedItem();
                    String num = c_id_number.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where id_type = '" + type + "' and id_number = '" + num + "'");

                    if (rs.next()) {
                        System.out.println("clicked");
                        t_room_no.setText(rs.getString("room_number"));
                    }
                } catch (Exception e) {
                }
            }
        });

        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id_num = c_id_number.getSelectedItem();
                String id_type = c_id_type.getSelectedItem();
                String room_no = t_room_no.getText();
                String deleteSQL = "Delete from customer where id_number = '" + id_num + "' and id_type= '" + id_type + "'";
                String q2 = "update room set availability = 'Available' where room_number = " + room_no;

                conn c = new conn();

                try {
                    c.s.executeUpdate(deleteSQL);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Check Out Successful");

                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        btnCheckOut.setBounds(50, 200, 100, 25);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        contentPane.add(btnCheckOut);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });
        btnExit.setBounds(160, 200, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
