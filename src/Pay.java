import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay extends JFrame implements ActionListener {
    Pay() {
        setBounds(500, 200, 800, 600);
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try {
            pane.setPage( "https://www.w3schools.com/" );
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>could not load,Error 500 </html>");
        }
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        JButton back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new Pay();
    }
}
