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

public class UpdateEmployee extends JFrame {
//This is Third Frame

    JTextField t_name, t_age, t_salary, t_phone, t_aadhar, t_email,t_job;
    JComboBox c1;

    public UpdateEmployee(Admin parent) {
//         The Title At the top.. Background of the Image...
        getContentPane().setForeground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Update/Remove Employee");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

//            TextField for the NAME..
        JLabel l_name = new JLabel("Employee");
        l_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_name.setBounds(60, 30, 120, 27);
        add(l_name);

        Choice c_emp = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                c_emp.add(rs.getString("name")+" ["+rs.getString("aadhar")+"]");
            }
        } catch (Exception e) {
        }
        c_emp.setBounds(200, 30, 180, 36);
        add(c_emp);

//            Fetch Button ..
        JButton Fetch = new JButton("fetch");
        Fetch.setBounds(380, 30, 70, 21);
        Fetch.setBackground(Color.WHITE);
        Fetch.setForeground(Color.BLACK);
        add(Fetch);

        JButton Delete = new JButton("DELETE");
        Delete.setBounds(80, 480, 150, 30);
        Delete.setBackground(Color.RED);
        Delete.setForeground(Color.WHITE);
        add(Delete);

        JButton Update = new JButton("UPDATE");
        Update.setBounds(250, 480, 150, 30);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        add(Update);

        JButton Back = new JButton("BACK");
        Back.setBounds(420, 480, 150, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        add(Back);

        JLabel Name = new JLabel("NAME");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 70, 150, 27);
        add(Name);

        t_name = new JTextField();
        t_name.setBounds(200, 70, 240, 27);
        add(t_name);

//            For Age..
        JLabel Age = new JLabel("AGE");
        Age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Age.setBounds(60, 420, 150, 27);
        add(Age);

        t_age = new JTextField();
        t_age.setBounds(200, 420, 240, 27);
        add(t_age);

//            For Gender..
        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);

        JRadioButton male = new JRadioButton("MALE");
        male.setBackground(Color.WHITE);
        male.setBounds(200, 120, 70, 27);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 120, 90, 27);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(Female);
        add(male);
        add(Female);
//        For JOB...    
        JLabel Job = new JLabel("JOB");
        Job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Job.setBounds(60, 170, 150, 27);
        add(Job);

        String course[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 170, 240, 30);
        add(c1);

//For Salary..            
        JLabel Salary = new JLabel("SALARY");
        Salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Salary.setBounds(60, 220, 150, 27);
        add(Salary);

        t_salary = new JTextField();
        t_salary.setBounds(200, 220, 240, 27);
        add(t_salary);

//            For phone number..
        JLabel l_phone = new JLabel("PHONE");
        l_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_phone.setBounds(60, 270, 150, 27);
        add(l_phone);

        t_phone = new JTextField();
        t_phone.setBounds(200, 270, 240, 27);
        add(t_phone);

//	For adhar card ID..
        JLabel l_aadhar = new JLabel("AADHAR");
        l_aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_aadhar.setBounds(60, 320, 150, 27);
        add(l_aadhar);

        t_aadhar = new JTextField();
        t_aadhar.setBounds(200, 320, 240, 27);
        add(t_aadhar);

//           For email.. 
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        t_email = new JTextField();
        t_email.setBounds(200, 370, 240, 27);
        add(t_email);

        setVisible(true);

//            Heading at the top of the Image..
        JLabel l_add_emp = new JLabel("Update/Remove Employee");
        l_add_emp.setForeground(Color.BLACK);
        l_add_emp.setFont(new Font("Tahoma", Font.PLAIN, 31));
        l_add_emp.setBounds(480, 24, 442, 35);
        add(l_add_emp);

//     For IMAGE..
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(460, 80, 480, 410);
        add(image);

        Fetch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String S = c_emp.getSelectedItem();
                    String id = S.substring(S.indexOf("[")+1, S.indexOf("]"));
                    
                    conn c = new conn();
                    String str = "select * from employee where aadhar = '"+id+"'";

                    ResultSet rs = c.s.executeQuery(str);
                    while (rs.next()) {
                        t_age.setText(rs.getString("age"));
                        t_salary.setText(rs.getString("salary"));
                        t_phone.setText(rs.getString("phone"));
                        t_email.setText(rs.getString("email"));
                        t_aadhar.setText(rs.getString("aadhar"));
                        t_name.setText(rs.getString("name"));
                        c1.setSelectedItem(rs.getString("job"));
                        String gender= rs.getString("gender");
                        if(gender.equals("male")){
                                male.setSelected(true);
                        }
                        else if(gender.equals("female")){
                                Female.setSelected(true);
                        }
                        else{
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
                    try {
                        String S = c_emp.getSelectedItem();
                        String id = S.substring(S.indexOf("[")+1, S.indexOf("]"));
                        
                        conn c = new conn();
                        String str = "delete from employee where aadhar = '"+id+"'";
    
                        c.s.executeUpdate(str);

                        JOptionPane.showMessageDialog(null, "Employee successfully removed");

                        try {
                            c_emp.removeAll();
                            ResultSet rs = c.s.executeQuery("select * from employee");
                            while (rs.next()) {
                                c_emp.add(rs.getString("name")+" ["+rs.getString("aadhar")+"]");
                            }
                        } catch (Exception e) {
                        }
    
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.toString());
                    }
                }
            });
        

        Update.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    String S = c_emp.getSelectedItem();
                    String id = S.substring(S.indexOf("[")+1, S.indexOf("]"));
                    String name = t_name.getText();
                    String age = t_age.getText();
                    String salary = t_salary.getText();
                    String phone = t_phone.getText();
                    String aadhar = t_aadhar.getText();
                    String email = t_email.getText();
    
                    String gender = null;
    
                    if (male.isSelected()) {
                        gender = "male";
    
                    } else if (Female.isSelected()) {
                        gender = "female";
                    }
    
    //                          To get the Job type..
                    String job = (String) c1.getSelectedItem();
    
                    try {
                        conn c = new conn();
                        String str = "update employee set name = '"+name+"', age= '"+age+"', salary= '"+salary+"', phone= '"
                        +phone+"', aadhar= '"+aadhar+"', email= '"+email+"', gender= '"+gender+"', job='"+job+"' where aadhar= '"+id+"'";
    
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null, "Employee Data Updated");
    
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    

        Back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                        dispose();
                        parent.setVisible(true);
                }
            });

        setSize(900, 600);
        setVisible(true);
        setLocation(400, 100);

    }
}
