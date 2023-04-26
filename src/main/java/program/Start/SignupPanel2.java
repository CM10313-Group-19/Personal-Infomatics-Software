package program.Start;
import com.toedter.calendar.JDateChooser;
import program.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignupPanel2 extends JPanel {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel dateOfBirthLabel;
    private JDateChooser datePicker;

    private JLabel weightLabel;
    private JTextField weightTextField;
    private JButton signUpButton;
    private JButton backButton;

    public SignupPanel2(StartPage startPage, MainFrame mainFrame){

        this.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94), 3));
        this.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon backArrowIcon = new ImageIcon("src/main/resources/back-arrow.png");
        Image backArrowImage = backArrowIcon.getImage();
        Image newBackArrowImage = backArrowImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon backArrow = new ImageIcon(newBackArrowImage);
        backButton = new JButton(backArrow);
        topPanel.add(backButton);
        this.add(topPanel, BorderLayout.NORTH);

        //set layout to gridbaglayout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(50, 100 , 100, 100));
        bottomPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        nameLabel = new JLabel("Name");
        bottomPanel.add(nameLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(180, 20));
        bottomPanel.add(nameTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        dateOfBirthLabel = new JLabel("Date of Birth");
        bottomPanel.add(dateOfBirthLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        datePicker = new JDateChooser();
        bottomPanel.add(datePicker, c);

        c.gridx = 0;
        c.gridy = 4;
        weightLabel = new JLabel("Weight (kg)");
        bottomPanel.add(weightLabel, c);

        c.gridx = 0;
        c.gridy = 5;
        weightTextField = new JTextField();

        //Only allow up to 3 digits before the decimal point and 2 digits after
        weightTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    e.consume();
                } else if (c == '.' && weightTextField.getText().contains(".")) {
                    e.consume();
                } else if (Character.isDigit(c) && weightTextField.getText().indexOf('.') != -1
                        && weightTextField.getText().substring(weightTextField.getText().indexOf('.')).length() == 3) {
                    e.consume();
                } else if (weightTextField.getText().length() >= 6) {
                    e.consume();
                }
            }
        });
        bottomPanel.add(weightTextField, c);

        c.gridx = 0;
        c.gridy = 6;
        signUpButton = new JButton("Sign Up");
        bottomPanel.add(signUpButton, c);

        this.add(bottomPanel, BorderLayout.CENTER);

        //If back button is clicked, loginPanel will be displayed
        backButton.addActionListener(e -> {
            startPage.SwitchPanel(startPage.signupPanel1);
        });

        signUpButton.addActionListener(e -> {;
            if (nameTextField.getText().equals("") || datePicker.getDate() == null || weightTextField.getText().equals("") || Integer.parseInt(weightTextField.getText()) <= 0){
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            }
            else if(Integer.parseInt(weightTextField.getText()) > 635){
                JOptionPane.showMessageDialog(null, "Please enter a valid weight");
            }
            else {
                startPage.createAccount(startPage.signupPanel1.getEmail(), startPage.signupPanel1.getPassword(), nameTextField.getText(), datePicker.getDate(), Integer.parseInt(weightTextField.getText()));
                mainFrame.SwitchPanel(mainFrame.mainPage);
            }
        });

    }
}
