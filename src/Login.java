
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener  {
    JButton login,signup,password;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JPanel p1= new JPanel();


        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);



        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        p2.add(lblusername);


        JTextField tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);


        JLabel lblPassword =new JLabel("Password");
        lblPassword.setBounds(60,110,100,25);
        lblPassword.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        p2.add(lblPassword);


        JTextField tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);


        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground( Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233 )));
        login.addActionListener(this);
        p2.add(login);


        signup = new JButton("Sign up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233 )));
        signup.addActionListener(this);
        p2.add(signup);


        password = new JButton("Forget Password");
        password.setBounds(130,250,130,30);
        password.setBackground(Color.BLACK);
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133,193,233 )));
        password.addActionListener(this);
        p2.add(password);


        JLabel text = new JLabel("Trouble is login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {


        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();

        }else{
            setVisible(false);
            new ForgetPassword();
        }

    }
    public static void main(String[]args){
        new Login();
    }


}
