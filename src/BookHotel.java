import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood, cdivision;
    JTextField tfpersons, tfdays;
    String username;
    JButton checkprice, bookpackage, back;

    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;

    BookHotel(String username) {
        this.username = username;
        setBounds(350, 180, 1100, 620);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Book Hotel");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(40, 10, 200, 30);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(40, 50, 200, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,50,200,20);
        add(labelusername);

        JLabel lblDivision = new JLabel("Select Division");
        lblDivision.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDivision.setBounds(40, 90, 150, 20);
        add(lblDivision);

        cdivision = new Choice();
        cdivision.setBounds(250, 90, 200, 20);
        cdivision.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    loadHotels();
                }
            }
        });
        add(cdivision);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT DISTINCT division FROM hotel");
            while (rs.next()) {
                cdivision.add(rs.getString("division"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 130, 150, 20);
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 130, 200, 20);
        add(chotel);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 170, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 170, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40, 210, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 210, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/Non AC");
        lblac.setBounds(40, 250, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 250, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 290, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 290, 200, 20);
        add(cfood);

        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 330, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 330, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 370, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 370, 200, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 410, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 410, 200, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 450, 150, 25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 450, 200, 25);
        labelprice.setForeground(Color.RED);
        add(labelprice);

        try {
            Conn conn = new Conn();
            String query = "Select * from customer where username ='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 500, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 500, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 500, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);

        // Load hotels based on the initially selected division
        loadHotels();

        setVisible(true);
    }

    private void loadHotels() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM hotel WHERE division = '" + cdivision.getSelectedItem() + "'");
            chotel.removeAll();
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT * FROM hotel WHERE name='" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodinclude"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;

                        labelprice.setText(total + " Tk");

                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid number");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookhotel VALUES('" + labelusername.getText() + "','" + cdivision.getSelectedItem() + "'," +
                        "'" + chotel.getSelectedItem() + "','" + tfpersons.getText() + "','" + tfdays.getText() + "','" + cac.getSelectedItem() + "'," +
                        "'" + cfood.getSelectedItem() + "','" + labelid.getText() + "','" + labelnumber.getText() + "','" + labelphone.getText() + "'," +
                        "'" + labelprice.getText() + "')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("");
    }
}
