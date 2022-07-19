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
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ashirbad
 */
public class UpdateCheckStatus extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t_room_no;
    private JTextField t_name;
    private JTextField t_date,t_day;
    private JTextField t_deposit;
    private JTextField t_pending;

    Choice c_id_number, c2;

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
    public UpdateCheckStatus(Reception parent) throws SQLException {
        //conn = Javaconnect.getDBConnection();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 200, 950, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
        lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
        contentPane.add(lblUpdateCheckStatus);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450, 70, 476, 270);
        add(l1);

        JLabel l_id_type = new JLabel("ID TYPE :");
        l_id_type.setBounds(25, 80, 107, 14);
        contentPane.add(l_id_type);

        Choice c_id_type = new Choice();
        c_id_type.add("Passport");
        c_id_type.add("Aadhar Card");
        c_id_type.add("Voter Id");
        c_id_type.add("Driving license");
        c_id_type.setBounds(248, 80, 130, 20);
        contentPane.add(c_id_type);

        JLabel l_id_num = new JLabel("ID NUMBER:");
        l_id_num.setBounds(25, 120, 107, 14);
        contentPane.add(l_id_num);

        c_id_number = new Choice();
        c_id_number.setBounds(248, 117, 202, 20);
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

        b_id_num.setBounds(380, 80, 70, 21);
        b_id_num.setBackground(Color.WHITE);
        b_id_num.setForeground(Color.BLACK);
        contentPane.add(b_id_num);

        JLabel lRoomNo = new JLabel("Room Number :");
        lRoomNo.setBounds(25, 160, 107, 14);
        contentPane.add(lRoomNo);

        t_room_no = new JTextField();
        t_room_no.setBounds(248, 157, 202, 20);
        contentPane.add(t_room_no);

        JLabel l_name = new JLabel("Name : ");
        l_name.setBounds(25, 200, 97, 14);
        contentPane.add(l_name);

        t_name = new JTextField();
        t_name.setBounds(248, 197, 202, 20);
        contentPane.add(t_name);
        t_name.setColumns(10);

        JLabel l_date = new JLabel("Check-in date :");
        l_date.setBounds(25, 240, 107, 14);
        contentPane.add(l_date);

        t_date = new JTextField();
        t_date.setBounds(248, 240, 202, 20);
        contentPane.add(t_date);
        t_date.setColumns(10);

        JLabel l_day = new JLabel("Check-In Days :");
        l_day.setBounds(25, 280, 107, 14);
        contentPane.add(l_day);

        t_day = new JTextField();
        t_day.setBounds(248, 277, 202, 20);
        contentPane.add(t_day);
        t_day.setColumns(10);

        JLabel l_deposit = new JLabel("Amount Paid (Rs) : ");
        l_deposit.setBounds(25, 320, 107, 14);
        contentPane.add(l_deposit);

        t_deposit = new JTextField();
        t_deposit.setBounds(248, 317, 202, 20);
        contentPane.add(t_deposit);
        t_deposit.setColumns(10);

        JLabel l_pending = new JLabel("Pending Amount (Rs) : ");
        l_pending.setBounds(25, 360, 150, 14);
        contentPane.add(l_pending);

        t_pending = new JTextField();
        t_pending.setBounds(248, 357, 202, 20);
        contentPane.add(t_pending);
        t_pending.setColumns(10);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    conn c = new conn();

                    String s0 = c_id_type.getSelectedItem();
                    String s1 = c_id_number.getSelectedItem();
                    String s2 = t_room_no.getText(); //room_number;    
                    String s4 = t_day.getText();
                    String s6 = t_date.getText();    
                    String s5 = t_deposit.getText(); //deposit    

                    c.s.executeUpdate("update customer set room_number = '" + s2 + "', no_of_days = '" + s4 + "', deposit = '" + s5 + "', check_in_date ='"+s6+"' where id_number = '" + s1 + "' and id_type= '" + s0 + "'");

                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                } catch (Exception ee) {
                    System.out.println(ee);
                }

            }
        });
        btnUpdate.setBounds(168, 400, 89, 23);
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
        btnExit.setBounds(281, 400, 89, 23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JButton btnAdd = new JButton("Check");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String deposit="0",days="0";
                try {
                    String s0 = c_id_type.getSelectedItem();
                    String s1 = c_id_number.getSelectedItem();
                    conn c = new conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where id_number = '" + s1 + "' and id_type= '" + s0 + "'");

                    while (rs1.next()) {
                        t_room_no.setText(rs1.getString("room_number"));
                        t_name.setText(rs1.getString("name"));
                        t_date.setText(rs1.getString("check_in_date"));
                        deposit=rs1.getString("deposit");
                        t_deposit.setText(deposit);
                        days=rs1.getString("no_of_days");
                        t_day.setText(days);
                    }
                } catch (Exception ee) {
                    System.out.println("error");
                }

                try {
                    String total = "0";
                    conn c = new conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + t_room_no.getText()+"'");
                    while (rs2.next()) {
                        total = rs2.getString("price");
                    }
                    int pending = (Integer.parseInt(total)*Integer.parseInt(days)) - Integer.parseInt(deposit);

                    t_pending.setText(Integer.toString(pending));

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        });
        btnAdd.setBounds(56, 400, 89, 23);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        contentPane.add(btnAdd);

        getContentPane().setBackground(Color.WHITE);
    }

}
