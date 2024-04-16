import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CheckHotels extends JFrame implements ActionListener {
    private JComboBox<String> optionsDropdown;
    private JButton btnDhaka, btnRajshahi, btnSylhet, btnChittagong, btnKhulna, btnBarishal, btnRangpur, btnMymensingh, btnClear, btnBack;
    private JLabel label;
    private JPanel buttonPanel, bottomPanel, topPanel;

    private Map<String, Map<String, String[]>> cityHotelMap;

    private Timer timer;
    private int imageIndex;

    public CheckHotels() {
        setTitle("Check Hotels");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.WHITE);

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(Color.WHITE);

        buttonPanel = new JPanel(new GridLayout(8, 1));
        buttonPanel.setBackground(Color.WHITE);

        bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.WHITE);

        cityHotelMap = new HashMap<>();
        initializeCityHotelMap();

        optionsDropdown = new JComboBox<>();
        optionsDropdown.addActionListener(this);

        topPanel.add(optionsDropdown);

        btnDhaka = createButton("Dhaka");
        btnRajshahi = createButton("Rajshahi");
        btnSylhet = createButton("Sylhet");
        btnChittagong = createButton("Chittagong");
        btnKhulna = createButton("Khulna");
        btnBarishal = createButton("Barishal");
        btnMymensingh = createButton("Mymensingh");
        btnRangpur = createButton("Rangpur");

        buttonPanel.add(btnDhaka);
        buttonPanel.add(btnRajshahi);
        buttonPanel.add(btnSylhet);
        buttonPanel.add(btnChittagong);
        buttonPanel.add(btnKhulna);
        buttonPanel.add(btnBarishal);
        buttonPanel.add(btnMymensingh);
        buttonPanel.add(btnRangpur);

        btnClear = createButton("Clear");
        btnClear.setBackground(Color.BLACK);
        btnClear.setForeground(Color.WHITE);

        btnBack = createButton("Back");
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);

        btnClear.addActionListener(this);
        btnBack.addActionListener(this);

        bottomPanel.add(btnClear);
        bottomPanel.add(btnBack);

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.WEST);
        add(label, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

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
        if (e.getSource() == optionsDropdown) {
            String selectedOption = (String) optionsDropdown.getSelectedItem();
            if (selectedOption != null) {
                String[] split = selectedOption.split(" : ");
                String cityName = split[0].trim();
                String hotelName = split[1].trim();
                displayImages(cityHotelMap.get(cityName).get(hotelName));
            }
        } else if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String cityName = clickedButton.getText();
            if (cityHotelMap.containsKey(cityName)) {
                showHotelOptions(cityName);
            }
            if (clickedButton == btnClear) {
                clearImage();
            } else if (clickedButton == btnBack) {
                dispose();

            }
        }
    }

    private void displayImages(String[] images) {
        imageIndex = 0;
        timer = new Timer(1000, new ActionListener() {
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
        Image image = icon.getImage().getScaledInstance(450, 350, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }

    private void initializeCityHotelMap() {

        Map<String, String[]> dhakaOptions = new HashMap<>();
        dhakaOptions.put("Le Méridien Dhaka", new String[]{"icons/Le Méridien Dhaka.jpg", "icons/bed1.jpg", "icons/bathroom1.jpg", "icons/counter1.jpg", "icons/gym.jpg"});
        dhakaOptions.put("InterContinental Dhaka", new String[]{"icons/InterContinental Dhaka.jpg", "icons/bed2.jpg", "icons/bathroom2.jpg", "icons/counter2.jpg", "icons/pul2.jpg"});
        dhakaOptions.put("Hotel Sarina Dhaka", new String[]{"icons/Hotel Sarina Dhaka.jpg", "icons/bed2.jpg", "icons/bathroom3.jpg", "icons/counter3.jpg", "icons/pul3.jpg"});
        cityHotelMap.put("Dhaka", dhakaOptions);

        Map<String, String[]> rajshahiOptions = new HashMap<>();
        rajshahiOptions.put("Hotel Mukta", new String[]{"icons/Hotel Mukta.jpg", "icons/bed2.jpg", "icons/bathroom2.jpg", "icons/counter3.jpg", "icons/pul2.jpg"});
        rajshahiOptions.put("Royal Raj Hotel", new String[]{"icons/Royal Raj Hotel.jpg", "icons/bed2.jpg", "icons/bathroom3.jpg", "icons/counter2.jpg", "icons/gym.jpg"});
        rajshahiOptions.put("Grand River View Hotel", new String[]{"icons/Grand River View Hotel.jpg", "icons/bed3.jpg", "icons/bathroom2.jpg", "icons/counter2.jpg", "icons/pul3.jpg"});
        cityHotelMap.put("Rajshahi", rajshahiOptions);

        Map<String, String[]> sylhetOptions = new HashMap<>();
        sylhetOptions.put("The Grand Hotel", new String[]{"icons/The Grand Hotel.jpg", "icons/bed3.jpg", "icons/bathroom2.jpg","icons/counter2.jpg","icons/pul3.jpg"});
        sylhetOptions.put("Hotel Noorjahan Grand", new String[]{"icons/Hotel Noorjahan Grand.jpg", "icons/bed2.jpg", "icons/bathroom1.jpg","icons/counter3.jpg","icons/pul2.jpg"});
        sylhetOptions.put("Rose View Hotel", new String[]{"icons/Rose View Hotel.jpg", "icons/bed1.jpg", "icons/bathroom3.jpg","icons/counter1.jpg","icons/gym.jpg"});
        cityHotelMap.put("Sylhet", sylhetOptions);

        Map<String, String[]> chittagongOptions = new HashMap<>();
        chittagongOptions.put("Hotel Diamond Park", new String[]{"icons/bed1.jpg", "icons/bathroom1.jpg","icons/counter1.jpg","icons/gym.jpg"});
        chittagongOptions.put("Golden Inn Chattogram Limited", new String[]{"icons/Golden Inn Chattogram Limited.jpg", "icons/bed3.jpg", "icons/bathroom2.jpg","icons/counter2.jpg","icons/pul3.jpg"});
        chittagongOptions.put("Radisson Blu Hotel", new String[]{"icons/Radisson Blu Hotel.jpg","icons/bed2.jpg", "icons/bathroom3.jpg","icons/counter1.jpg","icons/gym.jpg"});
        cityHotelMap.put("Chittagong", chittagongOptions);

        Map<String, String[]> khulnaOptions = new HashMap<>();
        khulnaOptions.put("Hotel DS Palace", new String[]{"icons/Hotel DS Palace.jpg", "icons/bed1.jpg", "icons/bathroom1.jpg","icons/counter1.jpg","icons/gym.jpg"});
        khulnaOptions.put("Hotel Ambassador", new String[]{"icons/Hotel Ambassador.jpg", "icons/bed3.jpg", "icons/bathroom2.jpg","icons/counter2.jpg","icons/pul3.jpg"});
        khulnaOptions.put("Hotel Golden City Int", new String[]{"icons/Hotel Golden City Int.jpg","icons/bed2.jpg", "icons/bathroom3.jpg","icons/counter3.jpg","icons/pul2.jpg"});
        cityHotelMap.put("Khulna", khulnaOptions);

        Map<String, String[]> barishalOptions = new HashMap<>();
        barishalOptions.put("Hotel Grand Park Barisal", new String[]{"icons/Hotel Grand Park Barisal.jpg", "icons/bed2.jpg", "icons/bathroom3.jpg","icons/counter2.jpg","icons/pul3.jpg"});
        barishalOptions.put("Hotel Sedona International", new String[]{"icons/Hotel Sedona International.jpg","icons/bed3.jpg", "icons/bathroom1.jpg","icons/counter2.jpg","icons/gym.jpg"});
        barishalOptions.put("Hotel Arena", new String[]{"icons/Hotel Arena.jpg","icons/bed1.jpg", "icons/bathroom2.jpg","icons/counter1.jpg","icons/pul2.jpg"});
        cityHotelMap.put("Barishal", barishalOptions);


        Map<String, String[]> rangpurOptions = new HashMap<>();
        rangpurOptions.put("Caspia The Home", new String[]{"icons/Caspia The Home.png", "icons/bed2.jpg", "icons/bathroom3.jpg","icons/counter3.jpg","icons/pul2.jpg"});
        rangpurOptions.put("Sky View Hotel", new String[]{"icons/sky-view-inn.jpg","icons/bed3.jpg", "icons/bathroom2.jpg","icons/counter1.jpg","icons/pul3.jpg"});
        rangpurOptions.put("The Park Residential Hotel", new String[]{"icons/The Park Residential Hotel.jpg", "icons/bed1.jpg", "icons/bathroom2.jpg","icons/counter1.jpg","icons/gym.jpg"});
        cityHotelMap.put("Rangpur", rangpurOptions);

        Map<String, String[]> mymensinghOptions = new HashMap<>();
        mymensinghOptions.put("Hotel Amir International", new String[]{"icons/Hotel Amir International.jpg", "icons/bed3.jpg", "icons/bathroom3.jpg","icons/counter3.jpg","icons/gym.jpg"});
        mymensinghOptions.put("Silver Castle Resort", new String[]{"icons/Silver Castle Resort.jpg", "icons/bed2.jpg", "icons/bathroom1.jpg","icons/counter1.jpg","icons/pul2.jpg"});
        mymensinghOptions.put("Hotel Le Marian", new String[]{"icons/Hotel Le Marian.jpg", "icons/bed2.jpg", "icons/bathroom3.jpg","icons/counter2.jpg","icons/gym.jpg"});
        cityHotelMap.put("Mymensingh", mymensinghOptions);


    }

    private void showHotelOptions(String cityName) {
        optionsDropdown.removeAllItems();
        Map<String, String[]> hotelOptions = cityHotelMap.get(cityName);
        if (hotelOptions != null) {
            for (String hotelName : hotelOptions.keySet()) {
                optionsDropdown.addItem(cityName + " : " + hotelName);
            }
        }
    }

    private void clearImage() {
        label.setIcon(new ImageIcon());
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckHotels::new);
    }
}
