import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    JButton pay,back;
    Payment(){
        setBounds(500,200,800,600);
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);


        pay=new JButton("Pay");
        pay.setBounds(0,0,80,40);
        pay.addActionListener(this);
        pay.setFont(new Font("Arial", Font.BOLD, 14));
        pay.setForeground(Color.WHITE);
        pay.setBackground(Color.BLACK);
        image.add(pay);

        back=new JButton("Back");
        back.setBounds(705,0,80,40);
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae ){
     if(ae.getSource()==pay){

         setVisible(false);
         new Pay();
     }else {
         setVisible(false);
     }
    }

    public  static void main(String[]args) {
    new Payment();
    }
}

