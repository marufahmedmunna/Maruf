import  javax.swing.*;
import java.awt.*;

public class Checkpackage  extends JFrame {


    Checkpackage() {
        setBounds(450, 200, 900, 600);

     String[] package1= {"GOLD PACKAGE","5 Days and 6 Nights", "Airport Assistance","Full Day 3 Island Cruise","Daily Buffet","Soft Drinks Free","English Speaking Guide","Full day 3 Island Cruise","winter Special","Book Now","22000 Tk","Package1.jpg"};
     String[] package2= {"SILVER PACKAGE","4 Days and 5 Nights","Toll Free","Entrance Free Ticket","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Safari","Cruise with dinner","Summer Special","Book Now","18000 Tk","Package2.jpg"};
     String[] package3= {"BRONZE PACKAGE","2 Days and 3 Nights","Return Airfare","Free Clubing,Horse Riding","Soft Drinks Free","Free Lunch and Dinner","BBQ Dinner","River Rafting","Spring Special","Book Now","14000 Tk","Package3.jpg"};


     JTabbedPane tab = new JTabbedPane();
       JPanel p1= createpackage(package1);
       tab.addTab("Package 1" ,null,p1);

     JPanel p2= createpackage(package2);
     tab.addTab("package 2",null,p2);

     JPanel p3= createpackage(package3);
     tab.addTab("package 3",null,p3);


        add(tab);

        setVisible(true);
    }

    public  JPanel  createpackage(String[] pack){
     JPanel p1 = new JPanel();
     p1.setLayout(null);
     p1.setBackground(Color.WHITE);

     JLabel l1 = new JLabel (pack[0]);
     l1.setBounds(50,5,300,30);
     l1.setForeground(Color.ORANGE);
     l1.setFont(new Font("Tahona",Font.BOLD,30));
     p1.add(l1);

     JLabel l2 = new JLabel (pack[1]);
     l2.setBounds(50,50,300,30);
     l2.setForeground(Color.RED);
     l2.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l2);

     JLabel l3 = new JLabel (pack[2]);
     l3.setBounds(50,100,300,30);
     l3.setForeground(Color.BLUE);
     l3.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l3);

     JLabel l4 = new JLabel (pack[3]);
     l4.setBounds(50,160,300,30);
     l4.setForeground(Color.BLUE);
     l4.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l4);

     JLabel l5 = new JLabel (pack[4]);
     l5.setBounds(50,210,300,30);
     l5.setForeground(Color.BLUE);
     l5.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l5);


     JLabel l6 = new JLabel (pack[5]);
     l6.setBounds(50,260,300,30);
     l6.setForeground(Color.BLUE);
     l6.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l6);


     JLabel l7 = new JLabel (pack[6]);
     l7.setBounds(50,310,300,30);
     l7.setForeground(Color.BLUE);
     l7.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l7);

     JLabel l8 = new JLabel (pack[7]);
     l8.setBounds(50,360,300,30);
     l8.setForeground(Color.BLUE);
     l8.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l8);

     JLabel l9 = new JLabel (pack[8]);
     l9.setBounds(50,415,300,30);
     l9.setForeground(Color.MAGENTA);
     l9.setFont(new Font("Tahoma",Font.BOLD,25));
     p1.add(l9);

     JLabel l10 = new JLabel (pack[9]);
     l10.setBounds(50,470,300,30);
     l10.setForeground(Color.magenta);
     l10.setFont(new Font("Tahoma",Font.BOLD,25));
     p1.add(l10);

     JLabel l11 = new JLabel (pack[10]);
     l11.setBounds(500,480,300,30);
     l11.setForeground(Color.BLUE);
     l11.setFont(new Font("Tahoma",Font.BOLD,25));
     p1.add(l11);


     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
     Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
     ImageIcon i3= new ImageIcon(i2);
     JLabel l12 = new JLabel(i3);
     l12.setBounds(350,20,500,300);
     p1.add(l12);

   return  p1;
    }



    public static void main(String[] args) {

     new Checkpackage();
    }
}