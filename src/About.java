import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

         String s="About project     \n"+
                "\n" +
                "The objective of the Travel and Tourism Management Systemproject is to develop a system that automates the process and activities of a traveland the purpose is to design a system using which one can perform all operations related to travel.\n"+
                "\n" +
                "Advantage of Project:\n"+
                 "\n"+
                "1.Gives accurate information.\n"+
                "2.Simplifies the manual work.\n"+
                "3.Provides up to date information.\n"+
                "4.Travelers details can be provided.\n"+
                "5.Booking confirmation notification.";

        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new About();
    }
}
