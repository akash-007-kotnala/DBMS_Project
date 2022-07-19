package hotel.management;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ashirbad
 */
public class Room extends JFrame {

    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lAvailability;
    private JLabel lCleanStatus;
    private JLabel lCost;
    private JLabel lBedType;
    private JLabel lRoomNumber;

    public Room(Reception parent) throws SQLException {
        //conn = Javaconnect.getDBConnection();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/room.jpg"));
        Image i3 = i1.getImage().getScaledInstance(512, 288, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 0, 600, 600);
        add(l1);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String displayCustomersql = "select * from room";
                    //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(100, 470, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setBounds(290, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        lAvailability = new JLabel("Availability");
        lAvailability.setBounds(119, 15, 69, 14);
        contentPane.add(lAvailability);

        lCleanStatus = new JLabel("Clean Status");
        lCleanStatus.setBounds(216, 15, 76, 14);
        contentPane.add(lCleanStatus);

        lCost = new JLabel("Price");
        lCost.setBounds(330, 15, 46, 14);
        contentPane.add(lCost);

        lBedType = new JLabel("Bed Type");
        lBedType.setBounds(417, 15, 76, 14);
        contentPane.add(lBedType);

        lRoomNumber = new JLabel("Room Number");
        lRoomNumber.setBounds(12, 15, 90, 14);
        contentPane.add(lRoomNumber);

        getContentPane().setBackground(Color.WHITE);
    }
}
