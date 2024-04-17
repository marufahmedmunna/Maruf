import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay extends JFrame implements ActionListener {

    private JTextField cardNumberField;
    private JPasswordField passwordField;
    private JTextField amountField;
    private JButton payButton;
    private JButton backButton;

    public Pay() {
        setTitle("Payment Form");
        setSize(650, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.BOLD, 14);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setFont(labelFont);
        cardNumberField = new JTextField(20);
        cardNumberField.setFont(fieldFont);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordField = new JPasswordField(20);
        passwordField.setFont(fieldFont);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(labelFont);
        amountField = new JTextField(20);
        amountField.setFont(fieldFont);

        mainPanel.add(cardNumberLabel, gbc);
        mainPanel.add(cardNumberField, gbc);
        mainPanel.add(passwordLabel, gbc);
        mainPanel.add(passwordField, gbc);
        mainPanel.add(amountLabel, gbc);
        mainPanel.add(amountField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        payButton = new JButton("Pay");
        backButton = new JButton("Back");

        payButton.setFont(new Font("Arial", Font.BOLD, 14));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(Color.BLACK);

        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);

        buttonPanel.add(payButton);
        buttonPanel.add(backButton);

        mainPanel.add(buttonPanel, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

        add(mainPanel, BorderLayout.WEST);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/card2.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(140, 20, 240, 150);
        add(image);
        setVisible(true);

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String enteredPassword = new String(passwordField.getPassword());
                if (enteredPassword.isEmpty()) {

                    JOptionPane.showMessageDialog(Pay.this, "Please enter your password.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                JOptionPane.showMessageDialog(Pay.this, "Payment successful!");
                dispose();
            }
        });

        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
            new Payment();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pay());
    }
}
