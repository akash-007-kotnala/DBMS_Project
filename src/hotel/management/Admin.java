/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

/**
 *
 * @author akash
 */
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Admin extends JFrame {

    private JPanel contentPane;


    public Admin(Dashboard parent, String username) {
        setBounds(350, 150, 850, 570);
        Admin curr_obj = this;
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/reception.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(300, 50, 500, 470);
        add(l1);

        JLabel l_welcome = new JLabel("Welcome "+username);
        l_welcome.setForeground(Color.BLACK);
        l_welcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
        l_welcome.setBounds(320, 2, 500, 85);
        add(l_welcome);   

        JButton btnNewCustomerForm = new JButton("Add Employee");
        btnNewCustomerForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddEmployee emp = new AddEmployee(curr_obj);
                    emp.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewCustomerForm.setBounds(50, 80, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        contentPane.add(btnNewCustomerForm);

        JButton btnNewButton = new JButton("Update/Remove Employee");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    UpdateEmployee emp_update = new UpdateEmployee(curr_obj);
                    emp_update.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(50, 140, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);

        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Add Room");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddRoom add_room = new AddRoom(curr_obj);
                    add_room.setVisible(true);
                    setVisible(false);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton_1.setBounds(50, 200, 200, 30);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Update/Remove Room");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateRoom update_room = new UpdateRoom(curr_obj);
                    update_room.setVisible(true);
                    setVisible(false);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton_2.setBounds(50, 260, 200, 30);
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Add Application User");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddUser au = new AddUser(curr_obj);
                    au.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_3.setBounds(50, 320, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_3);

        JButton btnManagerInfo = new JButton("Update/Remove App User");
        btnManagerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateUser uu = new UpdateUser(curr_obj);
                    uu.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnManagerInfo.setBounds(50, 380, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);

        contentPane.add(btnManagerInfo);

        JButton btnNewButton_4 = new JButton("Update my details");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateMyDetail umd;
                    umd = new UpdateMyDetail(curr_obj,username);
                    umd.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
            
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_4.setBounds(50, 440, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_4);
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
}
