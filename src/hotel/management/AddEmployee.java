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

public class AddEmployee extends JFrame {
//This is Third Frame

    JTextField t_name, t_age, textField_2, t_salary, t_phone, t_aadhar, t_email;
    JComboBox c1;

    public AddEmployee(Admin parent) {
//         The Title At the top.. Background of the Image...
        getContentPane().setForeground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

//            TextField for the NAME..
        JLabel l_name = new JLabel("NAME");
        l_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_name.setBounds(60, 30, 150, 27);
        add(l_name);

        t_name = new JTextField();
        t_name.setBounds(200, 30, 150, 27);
        add(t_name);

//            Save Button ..
        JButton Save = new JButton("SAVE");
        Save.setBounds(80, 440, 150, 30);
        Save.setBackground(Color.BLACK);
        Save.setForeground(Color.WHITE);
        add(Save);

        JButton Back = new JButton("BACK");
        Back.setBounds(250, 440, 150, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        add(Back);

//            For Age..
        JLabel Age = new JLabel("AGE");
        Age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Age.setBounds(60, 80, 150, 27);
        add(Age);

        t_age = new JTextField();
        t_age.setBounds(200, 80, 150, 27);
        add(t_age);

//            For Gender..
        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);

        JRadioButton male = new JRadioButton("MALE");
        male.setBackground(Color.WHITE);
        male.setBounds(200, 120, 70, 27);
        add(male);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 120, 90, 27);
        add(Female);

//        For JOB...    
        JLabel Job = new JLabel("JOB");
        Job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Job.setBounds(60, 170, 150, 27);
        add(Job);

        String course[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 170, 150, 30);
        add(c1);

//For Salary..            
        JLabel Salary = new JLabel("SALARY");
        Salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Salary.setBounds(60, 220, 150, 27);
        add(Salary);

        t_salary = new JTextField();
        t_salary.setBounds(200, 220, 150, 27);
        add(t_salary);

//            For phone number..
        JLabel l_phone = new JLabel("PHONE");
        l_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_phone.setBounds(60, 270, 150, 27);
        add(l_phone);

        t_phone = new JTextField();
        t_phone.setBounds(200, 270, 150, 27);
        add(t_phone);

//	For adhar card ID..
        JLabel l_aadhar = new JLabel("AADHAR");
        l_aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l_aadhar.setBounds(60, 320, 150, 27);
        add(l_aadhar);

        t_aadhar = new JTextField();
        t_aadhar.setBounds(200, 320, 150, 27);
        add(t_aadhar);

//           For email.. 
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        t_email = new JTextField();
        t_email.setBounds(200, 370, 150, 27);
        add(t_email);

        setVisible(true);

//            Heading at the top of the Image..
        JLabel l_add_emp = new JLabel("ADD EMPLOYEE DETAILS");
        l_add_emp.setForeground(Color.BLACK);
        l_add_emp.setFont(new Font("Tahoma", Font.PLAIN, 31));
        l_add_emp.setBounds(450, 24, 442, 35);
        add(l_add_emp);

//     For IMAGE..
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        add(image);

        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
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
                String s6 = (String) c1.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + s6 + "', '" + salary + "', '" + phone + "','" + aadhar + "', '" + email + "')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Employee Added");

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
