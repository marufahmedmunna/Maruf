import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Destination extends JFrame implements ActionListener {
    private JButton btnDhaka, btnRajshahi, btnSylhet, btnChittagong, btnKhulna, btnBarishal, btnRangpur, btnMymensingh;
    private JButton clearButton, backButton;
    private JLabel label;
    private JPanel buttonPanel, bottomPanel;


    private String[] dhakaImages = {"icons/dhaka.jpg", "icons/dhaka2.jpg", "icons/dhaka3.jpg"};
    private String[] rajshahiImages = {"icons/raj.jpg", "icons/raj2.jpg", "icons/raj3.jpg"};
    private String[] sylhetImages = {"icons/s.jpg", "icons/s2.jpg", "icons/s3.jpg"};
    private String[] chittagongImages = {"icons/c.jpg", "icons/c2.jpg", "icons/c3.jpg"};
    private String[] khulnaImages = {"icons/k.jpg", "icons/k2.jpg", "icons/k3.jpg"};
    private String[] barishalImages = {"icons/b.jpg", "icons/b2.jpg", "icons/b3.jpg"};
    private String[] rangpurImages = {"icons/r.jpg","icons/r2.jpg"};
    private String[] mymensinghImages = { "icons/m.jpg","icons/m2.jpg"};


    public Destination() {
        setTitle("Destination Viewer");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.WHITE);

        buttonPanel = new JPanel(new GridLayout(8, 1));
        buttonPanel.setBackground(Color.BLACK);


        bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.WHITE);

        btnDhaka = createButton("Dhaka");
        btnRajshahi = createButton("Rajshahi");
        btnSylhet = createButton("Sylhet");
        btnChittagong = createButton("Chittagong");
        btnKhulna = createButton("Khulna");
        btnBarishal = createButton("Barishal");
        btnMymensingh = createButton("Mymensingh");
        btnRangpur = createButton("Rangpur");

        clearButton = createButton("Clear");
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);

        backButton = createButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);

        buttonPanel.add(btnDhaka);
        buttonPanel.add(btnRajshahi);
        buttonPanel.add(btnSylhet);
        buttonPanel.add(btnChittagong);
        buttonPanel.add(btnKhulna);
        buttonPanel.add(btnBarishal);
        buttonPanel.add(btnMymensingh);
        buttonPanel.add(btnRangpur);

        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(clearButton);
        bottomPanel.add(Box.createHorizontalStrut(250));
        bottomPanel.add(backButton);

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        add(buttonPanel, BorderLayout.WEST);
        add(label, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        btnMymensingh.addActionListener(this);
        btnRangpur.addActionListener(this);

        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.PLAIN, 17));
        button.setPreferredSize(new Dimension(150, 35));
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDhaka) {
            displayImages(dhakaImages);
        } else if (e.getSource() == btnRajshahi) {
            displayImages(rajshahiImages);
        } else if (e.getSource() == btnSylhet) {
            displayImages(sylhetImages);
        } else if (e.getSource() == btnChittagong) {
            displayImages(chittagongImages);
        } else if (e.getSource() == btnKhulna) {
            displayImages(khulnaImages);
        } else if (e.getSource() == btnBarishal) {
            displayImages(barishalImages);
        } else if (e.getSource() == btnMymensingh) {
            displayImages(mymensinghImages);
        } else if (e.getSource() == btnRangpur) {
            displayImages(rangpurImages);
        } else if (e.getSource() == clearButton) {
            clearImages();
        } else if (e.getSource() == backButton) {
            dispose();
        }
    }

    private void clearImages() {
        label.setIcon(null);
        if (timer != null) {
            timer.stop();
        }
    }


    private Timer timer;
    private int imageIndex;

    private void displayImages(String[] images) {
        imageIndex = 0;
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imageIndex < images.length) {
                    loadImage(images[imageIndex]);
                    imageIndex++;
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    private void loadImage(String imageName) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imageName));
        Image image = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Destination::new);
    }
}
