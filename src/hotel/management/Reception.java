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

public class Reception extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        //new Reception();
    }

    public Reception(Dashboard parent, Login l) {
        setBounds(350, 150, 850, 570);
        Reception curr_obj = this;
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Reception");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/reception.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250, 30, 500, 470);
        add(l1);

        JButton btnNewCustomerForm = new JButton("Add Customer");
        btnNewCustomerForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddCustomer custom = new AddCustomer(curr_obj);
                    custom.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewCustomerForm.setBounds(10, 30, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        contentPane.add(btnNewCustomerForm);

        JButton btnUpdateCustomer = new JButton("Update Customer");
        btnUpdateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateCustomer custom = new UpdateCustomer(curr_obj);
                    custom.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnUpdateCustomer.setBounds(10, 75, 200, 30);
        btnUpdateCustomer.setBackground(Color.BLACK);
        btnUpdateCustomer.setForeground(Color.WHITE);
        contentPane.add(btnUpdateCustomer);

        JButton btnNewButton = new JButton("Room");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Room room = new Room(curr_obj);
                    room.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(10, 120, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);

        contentPane.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("All Employee Info");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    EmployeeInfo em = new EmployeeInfo(curr_obj);
                    em.setVisible(true);
                    setVisible(false);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton_2.setBounds(10, 165, 200, 30);
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Search Customer Details");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CustomerInfo customer = new CustomerInfo(curr_obj);
                    customer.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_3.setBounds(10, 210, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_3);

        JButton btnManagerInfo = new JButton("Manager Info");
        btnManagerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ManagerInfo mana = new ManagerInfo(curr_obj);
                    mana.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnManagerInfo.setBounds(10, 255, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);

        contentPane.add(btnManagerInfo);

        JButton btnNewButton_4 = new JButton("Check Out");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckOut check;
                try {
                    check = new CheckOut(curr_obj);
                    check.setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_4.setBounds(10, 300, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Update Check Status");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateCheckStatus update = new UpdateCheckStatus(curr_obj);
                    update.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_5.setBounds(10, 345, 200, 30);
        btnNewButton_5.setBackground(Color.BLACK);
        btnNewButton_5.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("Update Room Status");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateRoomStatus room = new UpdateRoomStatus(curr_obj);
                    room.setVisible(true);
                    setVisible(false);
                } catch (Exception s) {
                    s.printStackTrace();
                }
            }
        });
        btnNewButton_6.setBounds(10, 390, 200, 30);
        btnNewButton_6.setBackground(Color.BLACK);
        btnNewButton_6.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_6);

        JButton btnSearchRoom = new JButton("Search Room");
        btnSearchRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchRoom search = new SearchRoom(curr_obj);
                    search.setVisible(true);
                    setVisible(false);
                } catch (Exception ss) {
                    ss.printStackTrace();
                }
            }
        });
        btnSearchRoom.setBounds(10, 435, 200, 30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);

        contentPane.add(btnSearchRoom);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
}
