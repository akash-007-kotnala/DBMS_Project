/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ashirbad
 */
public class AddCustomer extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t_id_number, t_name, t_address, t_check_in_days,t_check_in_date, t_deposite;

    private JComboBox c_id_type;
    JRadioButton r_male, r_female;
    Choice c1;

    public AddCustomer( Reception parent) throws SQLException {

        setBounds(350, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480, 10, 300, 500);
        add(l1);

        JLabel lFormName = new JLabel("NEW CUSTOMER FORM");
        lFormName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lFormName.setBounds(118, 11, 260, 53);
        contentPane.add(lFormName);

        JLabel l_id_type = new JLabel("ID TYPE :");
        l_id_type.setBounds(35, 76, 200, 14);
        contentPane.add(l_id_type);

        c_id_type = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        c_id_type.setBounds(271, 73, 150, 20);
        contentPane.add(c_id_type);

        JLabel l_id_number = new JLabel("ID Number :");
        l_id_number.setBounds(35, 111, 200, 14);
        contentPane.add(l_id_number);

        t_id_number = new JTextField();
        t_id_number.setBounds(271, 111, 150, 20);
        contentPane.add(t_id_number);
        t_id_number.setColumns(10);

        JLabel l_name = new JLabel("Name :");
        l_name.setBounds(35, 151, 200, 14);
        contentPane.add(l_name);

        t_name = new JTextField();
        t_name.setBounds(271, 151, 150, 20);
        contentPane.add(t_name);
        t_name.setColumns(10);

        JLabel l_gender = new JLabel("Gender :");
        l_gender.setBounds(35, 191, 200, 14);
        contentPane.add(l_gender);

        r_male = new JRadioButton("Male");
        r_male.setFont(new Font("Raleway", Font.BOLD, 14));
        r_male.setBackground(Color.WHITE);
        r_male.setBounds(271, 191, 80, 12);
        add(r_male);

        r_female = new JRadioButton("Female");
        r_female.setFont(new Font("Raleway", Font.BOLD, 14));
        r_female.setBackground(Color.WHITE);
        r_female.setBounds(350, 191, 100, 12);
        add(r_female);

        JLabel l_address = new JLabel("Address :");
        l_address.setBounds(35, 231, 200, 14);
        contentPane.add(l_address);

        t_address = new JTextField();
        t_address.setBounds(271, 231, 150, 20);
        contentPane.add(t_address);
        t_address.setColumns(10);

        JLabel l_allocated_room_no = new JLabel("Allocated Room Number :");
        l_allocated_room_no.setBounds(35, 274, 200, 14);
        contentPane.add(l_allocated_room_no);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while (rs.next()) {
                c1.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
        }
        c1.setBounds(271, 274, 150, 20);
        contentPane.add(c1);

        JLabel l_check_in_date = new JLabel("start date [YYYY-MM-DD] :");
        l_check_in_date.setBounds(35, 316, 200, 14);
        contentPane.add(l_check_in_date);

        t_check_in_date = new JTextField();
        t_check_in_date.setBounds(271, 316, 150, 20);
        contentPane.add(t_check_in_date);
        t_check_in_date.setColumns(10);

        JLabel l_check_in_days = new JLabel("Check-In Days :");
        l_check_in_days.setBounds(35, 359, 200, 14);
        contentPane.add(l_check_in_days);

        t_check_in_days = new JTextField();
        t_check_in_days.setBounds(271, 359, 150, 20);
        contentPane.add(t_check_in_days);
        t_check_in_days.setColumns(10);

        JLabel l_deposite = new JLabel("Deposit :");
        l_deposite.setBounds(35, 400, 200, 14);
        contentPane.add(l_deposite);

        t_deposite = new JTextField();
        t_deposite.setBounds(271, 400, 150, 20);
        contentPane.add(t_deposite);
        t_deposite.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                    conn c = new conn();
                    c.c.setAutoCommit(false);
                    String radio = null;

                    if (r_male.isSelected()) {
                        radio = "male";
                    } else if (r_female.isSelected()) {
                        radio = "female";
                    }

                    String s_room = c1.getSelectedItem();
                    String s_id_type = (String) c_id_type.getSelectedItem();
                    String s_id_number = t_id_number.getText();
                    String s_name = t_name.getText();
                    String s_gender = radio;
                    String s_address = t_address.getText();
                    String s_date = t_check_in_date.getText();
                    String s_days = t_check_in_days.getText();
                    String s_deposite = t_deposite.getText();
                    
                    

                    String str = "select count(*) as count from Customer c, Room r where c.room_number=r.room_number and r.room_number='"+s_room+"' and "
                    +"(date_add(c.check_in_date,INTERVAL c.no_of_days day)>='"+s_date+"' and c.check_in_date <= date_add('"+s_date+"',INTERVAL "+s_days+" day) )";
                    
                    ResultSet rs = c.s.executeQuery(str);
                    while(rs.next()){
                        int count= Integer.parseInt(rs.getString("count"));
                        if(count>0){
                            throw new Exception("Room "+s_room+" will remain occupied for the given days");
                        }
                    }

                    try {

                        String q1 = "insert into customer values('" + s_id_type + "','" + s_id_number + "','" + s_name + "','" + s_gender + "','" + s_address + "','" + s_room + "','" + s_days + "','" + s_deposite +"','" + s_date + "')";
                        String q2 = "update room set availability = 'Occupied' where room_number = '" + s_room+"'";
                        System.out.println(q1);
                        c.s.executeUpdate(q1);
                        c.s.executeUpdate(q2);
                        c.c.commit();

                        JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    } catch (SQLException e1) {
                        System.out.println(e1.getMessage());
                        c.c.rollback();
                    } catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(null, "Please Enter an valid number");
                    }
                    c.c.setAutoCommit(true);
                }
                catch(Exception e2){
                    JOptionPane.showMessageDialog(null, e2.getMessage());
                }
            }
        });
        btnNewButton.setBounds(100, 450, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 450, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
