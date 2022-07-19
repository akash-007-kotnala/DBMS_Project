/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ashirbad
 */
public class CustomerInfo extends JFrame {

    Connection conn = null;
    private JPanel contentPane;
    private JLabel l_id;
    private JLabel l_id_type;
    private JLabel l_id_number;
    private JLabel lNewLabel;
    private JLabel lGender;
    private JTable table;
    private JLabel lCountry;
    private JLabel lRoom;
    private JLabel lStatus;
    private JLabel lDeposit,lPending,lDate;
    JTextField t_search;

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
    public CustomerInfo(Reception parent) throws SQLException {
        //conn = Javaconnect.getDBConnection();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 80, 1120, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Search Customer Details");

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });
        btnExit.setBounds(450, 620, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JButton btnLoadData = new JButton("Load All");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    conn c = new conn();

                    String displayCustomersql = "select c.id_type,c.id_number,c.name,c.gender,c.address,c.room_number,c.deposit,"+
                                                "(r.price*c.no_of_days)-c.deposit as pending,c.check_in_date,date_add(check_in_date,INTERVAL no_of_days day) as check_out_date from Customer c, Room r where c.room_number=r.room_number";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(300, 620, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        t_search = new JTextField();
        t_search.setBounds(200, 10, 400, 27);
        add(t_search);

        JButton b_search = new JButton("Search");
        b_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    conn c = new conn();

                    String displayCustomersql = "select c.id_type,c.id_number,c.name,c.gender,c.address,c.room_number,c.deposit,"+
                                                "(r.price*c.no_of_days)-c.deposit as pending,c.check_in_date,date_add(check_in_date,INTERVAL no_of_days day) as check_out_date"
                                                +" from Customer c, Room r where c.room_number=r.room_number "
                                                +"and (c.name like '%"+t_search.getText()+"%' or c.id_number like '%"
                                                +t_search.getText()+"%' or c.id_type like '%"+t_search.getText()+"%' )";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        b_search.setBounds(610, 10, 120, 27);
        b_search.setBackground(Color.BLACK);
        b_search.setForeground(Color.WHITE);
        contentPane.add(b_search);

        l_id = new JLabel("________________ID_______________");
        l_id.setBounds(10, 65, 300, 14);
        contentPane.add(l_id);

        l_id_type = new JLabel("TYPE");
        l_id_type.setBounds(31, 80, 46, 14);
        contentPane.add(l_id_type);

        l_id_number = new JLabel("Number");
        l_id_number.setBounds(150, 80, 46, 14);
        contentPane.add(l_id_number);

        lNewLabel = new JLabel("Name");
        lNewLabel.setBounds(270, 80, 65, 14);
        contentPane.add(lNewLabel);

        lGender = new JLabel("Gender");
        lGender.setBounds(360, 80, 46, 14);
        contentPane.add(lGender);

        table = new JTable();
        table.setBounds(0, 100, 1115, 480);
        contentPane.add(table);

        lCountry = new JLabel("Address");
        lCountry.setBounds(480, 80, 46, 14);
        contentPane.add(lCountry);

        lRoom = new JLabel("Room");
        lRoom.setBounds(600, 80, 46, 14);
        contentPane.add(lRoom);

        

        lDeposit = new JLabel("Deposit");
        lDeposit.setBounds(680, 80, 100, 14);
        contentPane.add(lDeposit);

        lPending = new JLabel("Pending");
        lPending.setBounds(800, 80, 100, 14);
        contentPane.add(lPending);

        lDate = new JLabel("Check-in date");
        lDate.setBounds(900, 80, 100, 14);
        contentPane.add(lDate);

        lStatus = new JLabel("Check-out date");
        lStatus.setBounds(1005, 80, 100, 14);
        contentPane.add(lStatus);

        getContentPane().setBackground(Color.WHITE);
    }
}
