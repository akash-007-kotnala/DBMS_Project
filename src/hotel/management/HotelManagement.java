package hotel.management;

import java.awt.*;
//to make the desktop applications..
import javax.swing.*;
import java.awt.event.*;

public class HotelManagement extends JFrame implements ActionListener {

    HotelManagement() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 50, 1365, 721);

//        To set the background image.. Classloader to get the imgage from our disk ..
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/first.jpeg"));
//      To put image on the frame.. and to set image within the frame..
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1365, 721);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management App");
//        to set the frame..
        l2.setBounds(20, 20, 1000, 90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));
        l1.add(l2);

//        To create the Button ..
        JButton b1 = new JButton("NEXT");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("TAHOMA", Font.BOLD, 18));
        b1.setBounds(1100, 575, 150, 50);
        b1.addActionListener(this);
        l1.add(b1);

//        So setLayout is used for custom modification..
        setLayout(null);
//        To make frame visible..
        setVisible(true);

//        For functionality of the Dripper..
        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
//For working of the button..

    public void actionPerformed(ActionEvent ae) {
        new Login(this).setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        new HotelManagement().setVisible(true);
    }
}
