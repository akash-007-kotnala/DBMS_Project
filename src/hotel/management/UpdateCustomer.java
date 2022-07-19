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

public class UpdateCustomer extends JFrame {
//This is Third Frame

    JTextField t_name, t_gender, t_address, t_room_no, t_date, t_deposit, t_days;

    public UpdateCustomer(Reception parent) {
//      The Title At the top.. Background of the Image...
        getContentPane().setForeground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Update/Remove Customer");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 600);
        getContentPane().setLayout(null);

//      TextField for the NAME..
        JLabel l_name = new JLabel("Customer");
        l_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_name.setBounds(60, 70, 120, 27);
        add(l_name);

        Choice c_emp = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c_emp.add(rs.getString("name") + " [" + rs.getString("id_type") + ":" + rs.getString("id_number") + "]");
            }
        } catch (Exception e) {
        }
        c_emp.setBounds(200, 70, 300, 36);
        add(c_emp);

//            Fetch Button ..
        JButton Fetch = new JButton("fetch");
        Fetch.setBounds(500, 70, 70, 21);
        Fetch.setBackground(Color.WHITE);
        Fetch.setForeground(Color.BLACK);
        add(Fetch);

        JButton Delete = new JButton("DELETE");
        Delete.setBounds(80, 550, 150, 30);
        Delete.setBackground(Color.RED);
        Delete.setForeground(Color.WHITE);
        add(Delete);

        JButton Update = new JButton("UPDATE");
        Update.setBounds(250, 550, 150, 30);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        add(Update);

        JButton Back = new JButton("BACK");
        Back.setBounds(420, 550, 150, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        add(Back);

        JLabel Name = new JLabel("NAME");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 130, 150, 27);
        add(Name);

        t_name = new JTextField();
        t_name.setBounds(200, 130, 240, 27);
        add(t_name);

//            For Age..
        JLabel Address = new JLabel("Address");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 480, 150, 27);
        add(Address);

        t_address = new JTextField();
        t_address.setBounds(200, 480, 240, 27);
        add(t_address);

//            For Gender..
        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 190, 150, 27);
        add(Gender);

        JRadioButton male = new JRadioButton("MALE");
        male.setBackground(Color.WHITE);
        male.setBounds(200, 190, 70, 27);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 190, 90, 27);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(Female);
        add(male);
        add(Female);

        JLabel Room = new JLabel("Allocated Room");
        Room.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Room.setBounds(60, 250, 150, 27);
        add(Room);

        t_room_no = new JTextField();
        t_room_no.setBounds(200, 250, 240, 27);
        add(t_room_no);

        JLabel CheckIn = new JLabel("Check-In Date");
        CheckIn.setFont(new Font("Tahoma", Font.PLAIN, 17));
        CheckIn.setBounds(60, 310, 150, 27);
        add(CheckIn);

        t_date = new JTextField();
        t_date.setBounds(200, 310, 240, 27);
        add(t_date);

        JLabel CheckInDays = new JLabel("Check-In Days");
        CheckInDays.setFont(new Font("Tahoma", Font.PLAIN, 17));
        CheckInDays.setBounds(60, 370, 150, 27);
        add(CheckInDays);

        t_days = new JTextField();
        t_days.setBounds(200, 370, 240, 27);
        add(t_days);

        JLabel Deposit = new JLabel("Deposit");
        Deposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Deposit.setBounds(60, 430, 150, 27);
        add(Deposit);

        t_deposit = new JTextField();
        t_deposit.setBounds(200, 430, 240, 27);
        add(t_deposit);

        setVisible(true);

        JLabel l_add_emp = new JLabel("Update/Remove Customer");
        l_add_emp.setForeground(Color.BLACK);
        l_add_emp.setFont(new Font("Tahoma", Font.PLAIN, 31));
        l_add_emp.setBounds(260, 10, 442, 35);
        add(l_add_emp);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/checkin.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(460, 120, 400, 400);
        add(image);

        Fetch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String S = c_emp.getSelectedItem();
                    String id_number = S.substring(S.indexOf(":") + 1, S.indexOf("]"));
                    String id_type = S.substring(S.indexOf("[") + 1, S.indexOf(":"));

                    conn c = new conn();
                    String str = "select * from customer where id_number = '" + id_number + "' and id_type= '"+id_type+"'";

                    ResultSet rs = c.s.executeQuery(str);
                    while (rs.next()) {
                        t_name.setText(rs.getString("name"));
                        t_address.setText(rs.getString("address"));
                        t_room_no.setText(rs.getString("room_number"));
                        t_date.setText(rs.getString("check_in_date"));
                        t_days.setText(rs.getString("no_of_days"));
                        t_deposit.setText(rs.getString("deposit"));
                        String gender = rs.getString("gender");
                        if (gender.equals("male")) {
                            male.setSelected(true);
                        } else if (gender.equals("female")) {
                            Female.setSelected(true);
                        } else {
                            Female.setSelected(false);
                            male.setSelected(false);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try{
                    conn c = new conn();
                    c.c.setAutoCommit(false);
                    try {
                        String S = c_emp.getSelectedItem();
                        String id_number = S.substring(S.indexOf(":") + 1, S.indexOf("]"));
                        String id_type = S.substring(S.indexOf("[") + 1, S.indexOf(":"));

                        String str1 = "update room set availability='Available' where room_number = (select room_number from customer where id_number='"+id_number+"' and id_type='"+id_type+"')";
                        String str2 = "delete from customer where id_number = '" + id_number + "' and id_type='"+id_type+"'";
                        c.s.executeUpdate(str1);
                        c.s.executeUpdate(str2);
                        c.c.commit();

                        JOptionPane.showMessageDialog(null, "Customer successfully removed");

                        try {
                            c_emp.removeAll();
                            ResultSet rs3 = c.s.executeQuery("select * from customer");
                            while (rs3.next()) {
                                c_emp.add(rs3.getString("name") + " [" + rs3.getString("id_type") + ":" + rs3.getString("id_number") + "]");
                            }
                        } catch (Exception e) {
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.toString());
                        c.c.rollback();
                    }
                    c.c.setAutoCommit(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        Update.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                String S = c_emp.getSelectedItem();
                String id_number = S.substring(S.indexOf(":") + 1, S.indexOf("]"));
                String id_type = S.substring(S.indexOf("[") + 1, S.indexOf(":"));
                String name = t_name.getText();
                String room_number = t_room_no.getText();
                String address = t_address.getText();
                String check_in_date = t_date.getText();
                String check_in_days = t_days.getText();
                String deposit = t_deposit.getText();

                String gender = null;

                if (male.isSelected()) {
                    gender = "male";

                } else if (Female.isSelected()) {
                    gender = "female";
                }
                try{
                    conn c = new conn();
                    c.c.setAutoCommit(false);

                    String str = "select count(*) as count from Customer c, Room r where c.room_number=r.room_number and r.room_number='"+room_number+"' and "
                    +"(date_add(c.check_in_date,INTERVAL c.no_of_days day)>='"+check_in_date+"' and c.check_in_date <= date_add('"+check_in_date+"',INTERVAL "+check_in_days+" day) )";
                    
                    ResultSet rs = c.s.executeQuery(str);
                    while(rs.next()){
                        int count= Integer.parseInt(rs.getString("count"));
                        if(count>0){
                            throw new Exception("Room "+room_number+" will remain occupied for the given days");
                        }
                    }

                    try {
                        
                        String str1 = "update room set availability='Available' where room_number = (select room_number from customer where id_number='"+
                                        id_number+"' and id_type='"+id_type+"')";
                        String str2 = "update customer set name = '" + name + "', room_number= '" + room_number + "', address= '" + address + "', check_in_date= '" + check_in_date + "',"
                                + " gender= '" + gender + "', no_of_days='"+check_in_days+"', deposit= '" + deposit + "' where id_number= '" + id_number + "' and id_type= '"+id_type+"'";
                        String str3 = "update room set availability='Occupied' where room_number ='"+room_number+"'";
                        c.s.executeUpdate(str1);
                        c.s.executeUpdate(str2);
                        c.s.executeUpdate(str3);
                        c.c.commit();
                        JOptionPane.showMessageDialog(null, "Customer Data Updated");

                    } catch (SQLException e) {
                        e.printStackTrace();
                        if(e.getErrorCode() == 1452){
                            JOptionPane.showMessageDialog(null, "Room does not exist!");
                        }
                        else{
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, e.getErrorCode()+" "+e.getMessage());
                        }
                        c.c.rollback();
                    }
                    try {
                        c_emp.removeAll();
                        ResultSet rs3 = c.s.executeQuery("select * from customer");
                        while (rs3.next()) {
                            c_emp.add(rs3.getString("name") + " [" + rs3.getString("id_type") + ":" + rs3.getString("id_number") + "]");
                        }
                    } catch (Exception e) {
                    }
                    c.c.setAutoCommit(true);
                }
                catch(Exception e2){
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, e2.getMessage());
                }
            }
        });

        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                parent.setVisible(true);
            }
        });

        setSize(900, 660);
        setVisible(true);
        setLocation(400, 100);

    }
}
