


import javax.swing.*;
import java.awt.*;

public class Loading  extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;
    public void run (){
        try {
            for(int i = 1; i<= 101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();

                if(value<max) {
                    bar.setValue(bar.getValue() +1);
                }
                else {
                    setVisible(false);
                }
                Thread.sleep(50);

            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    Loading (String username) {
        this.username = username;
        t = new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setFont(new Font("Raleway",Font.BOLD,32));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel Loading  = new JLabel("Loading,please wait...");
        Loading.setBounds(230,130,150,30);
        Loading.setFont(new Font("Raleway",Font.BOLD,20));
        add(Loading);

        JLabel iblusername = new JLabel("Welcome" + username);
        iblusername.setBounds(20,310,400,40);
        iblusername.setFont(new Font("Raleway",Font.BOLD,25));
        add(iblusername);


        t.start();
        setVisible(true);

    }

    public static  void main(String[] args ){
        new Loading("");
    }
}



