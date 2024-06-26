import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Dashboard  extends JFrame implements ActionListener {
    String username;
    JButton addpersonalDetails,viewpersonalDetails,updatepersonalDetails,
            cheekpackage,bookpackage,bookhotel,viewbookedhotel,payment,
            viewpackage,viewhotels,destination,calculators,notepad,about,
            deletepersonalDetails;
    Dashboard(String username){
        this.username=username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addpersonalDetails = new JButton("Add personal Details");
        addpersonalDetails.setBounds(0,0,300,50);
        addpersonalDetails.setBackground(new Color(0,0,102));
        addpersonalDetails.setForeground(Color.WHITE);
        addpersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addpersonalDetails.setMargin(new Insets(0,0,0,57));
        addpersonalDetails.addActionListener(this);
        p2.add(addpersonalDetails);


        updatepersonalDetails = new JButton("Update personal Details");
        updatepersonalDetails.setBounds(0,50,300,50);
        updatepersonalDetails.setBackground(new Color(0,0,102));
        updatepersonalDetails.setForeground(Color.WHITE);
        updatepersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatepersonalDetails.setMargin(new Insets(0,0,0,30));
        updatepersonalDetails.addActionListener(this);
        p2.add(updatepersonalDetails);


        viewpersonalDetails = new JButton("View Details");
        viewpersonalDetails.setBounds(0,100,300,50);
        viewpersonalDetails.setBackground(new Color(0,0,102));
        viewpersonalDetails.setForeground(Color.WHITE);
        viewpersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpersonalDetails.setMargin(new Insets(0,0,0,130));
        viewpersonalDetails.addActionListener(this);
        p2.add(viewpersonalDetails);


        deletepersonalDetails = new JButton("Delete personal Details");
        deletepersonalDetails.setBounds(0,150,300,50);
        deletepersonalDetails.setBackground(new Color(0,0,102));
        deletepersonalDetails.setForeground(Color.WHITE);
        deletepersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletepersonalDetails.setMargin(new Insets(0,0,0,38));
        deletepersonalDetails.addActionListener(this);
        p2.add(deletepersonalDetails);


        cheekpackage = new JButton("Check Package");
        cheekpackage.setBounds(0,200,300,50);
        cheekpackage.setBackground(new Color(0,0,102));
        cheekpackage.setForeground(Color.WHITE);
        cheekpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        cheekpackage.setMargin(new Insets(0,0,0,110));
        cheekpackage.addActionListener(this);
        p2.add(cheekpackage);

        bookpackage = new JButton("Book Package ");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackage.setMargin(new Insets(0,0,0,116));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);


        viewpackage = new JButton("View Package ");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage.setMargin(new Insets(0,0,0,118));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);


        destination = new JButton("Destination");
        destination.setBounds(0,350,300,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,147));
        destination.addActionListener(this);
        p2.add(destination);


        viewhotels = new JButton("View Hotels ");
        viewhotels.setBounds(0,400,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,133));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);


        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,450,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,150));
        bookhotel.addActionListener(this);
        p2.add(bookhotel );

        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0,500,300,50);
        viewbookedhotel.setBackground(new Color(0,0,102));
        viewbookedhotel.setForeground(Color.WHITE);
        viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedhotel.setMargin(new Insets(0,0,0,77));
        viewbookedhotel.addActionListener(this);
        p2.add(viewbookedhotel);



        calculators = new JButton("Calculator");
        calculators.setBounds(0,550,300,50);
        calculators.setBackground(new Color(0,0,102));
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculators.setMargin(new Insets(0,0,0,155));
        calculators.addActionListener(this);
        p2.add(calculators);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,600,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,170));
        notepad.addActionListener(this);
        p2.add(notepad);

        payment = new JButton("Payment");
        payment.setBounds(0,650,300,50);
        payment.setBackground(new Color(0,0,102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Tahoma",Font.PLAIN,20));
        payment.setMargin(new Insets(0,0,0,170));
        payment.addActionListener(this);
        p2.add(payment);

        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,197));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image) ;

        JLabel text = new JLabel("Travel and Tourism Management system");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway",Font.PLAIN,55));
        image.add(text);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addpersonalDetails){
            new AddCustomer(username);
        }
        else if (ae.getSource() == viewpersonalDetails){
           new Viewcustomer(username);
        } else if(ae.getSource() == updatepersonalDetails) {
            new UpdateCustomer(username);
        } else if(ae.getSource() == cheekpackage){
            new Checkpackage();
        } else if (ae.getSource() == bookpackage){
            new Bookpackage(username);
        }else if(ae.getSource()==viewpackage){
            new ViewPackage(username);

        }else if(ae.getSource()==viewhotels){
            new CheckHotels();
        }else if(ae.getSource()==destination){
            new Destination();
        }else if(ae.getSource()==bookhotel){
            new BookHotel(username);
        }else if(ae.getSource()==viewbookedhotel){
            new ViewBookHotel(username);
        }else if(ae.getSource()==payment){
            new Payment();
        }else if(ae.getSource()==calculators){
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==about){
            new About();
        }else if(ae.getSource()==deletepersonalDetails){
            new DeleteDetails(username);
        }


    }
    public  static  void main(String[] args){

        new Dashboard("");
    }


}