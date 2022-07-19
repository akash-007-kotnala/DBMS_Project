/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ashirbad
 */
public class UpdateRoomStatus extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t_aval_stat;
    private JTextField t_clean_stat;

    Choice c1;

    /**
     * Launch the application.
     */

    public void close() {
        this.dispose();
    }

    /**
     * Create the frame.
     *
     * @throws SQLException
     */
    public UpdateRoomStatus(Reception parent) throws SQLException {
        //conn = Javaconnect.getDBConnection();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 200, 1000, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/room.jpg"));
        Image i3 = i1.getImage().getScaledInstance(512, 288, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400, 80, 600, 250);
        add(l1);

        JLabel lUpdateRoomStatus = new JLabel("Update Room Status");
        lUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lUpdateRoomStatus.setBounds(85, 11, 206, 34);
        contentPane.add(lUpdateRoomStatus);

        JLabel lRoomNo = new JLabel("Room Number:");
        lRoomNo.setBounds(27, 87, 90, 14);
        contentPane.add(lRoomNo);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while (rs.next()) {
                c1.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
        }
        c1.setBounds(160, 84, 140, 20);
        contentPane.add(c1);

        JLabel l_aval_stat = new JLabel("Availability:");
        l_aval_stat.setBounds(27, 130, 90, 14);
        contentPane.add(l_aval_stat);

        t_aval_stat = new JTextField();
        t_aval_stat.setBounds(160, 130, 140, 20);
        contentPane.add(t_aval_stat);
        t_aval_stat.setColumns(10);

        JLabel l_clean_stat = new JLabel("Clean Status:");
        l_clean_stat.setBounds(27, 180, 90, 14);
        contentPane.add(l_clean_stat);

        t_clean_stat = new JTextField();
        t_clean_stat.setBounds(160, 180, 140, 20);
        contentPane.add(t_clean_stat);
        t_clean_stat.setColumns(10);

        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = c1.getSelectedItem();
                    conn c = new conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = " + s1);
                    while (rs2.next()) {
                        t_aval_stat.setText(rs2.getString("availability"));
                        t_clean_stat.setText(rs2.getString("clean_status"));
                    }
                } catch (Exception ee) {
                }
            }
        });
        b1.setBounds(120, 240, 89, 23);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws NumberFormatException {

                try {
                    conn c = new conn();
                    String s1 = c1.getSelectedItem();
                    String str = "update room set clean_status = '" + t_clean_stat.getText() + "' where room_number = " + s1;
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Update Sucessful");

                } catch (Exception ee) {
                    ee.printStackTrace();
                }

            }
        });
        btnUpdate.setBounds(60, 280, 89, 23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });
        btnExit.setBounds(180, 280, 89, 23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }

}
