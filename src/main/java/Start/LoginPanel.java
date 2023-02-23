package Start;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JPasswordField passwordField;
    private JCheckBox showPasswordBox;
    private JButton loginButton;
    private JButton signUpButton;
    public JPanel formPanel;

    public LoginPanel(StartPage startPage){

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 80, 100, 80)));

        //set layout to gridbaglayout
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        emailLabel = new JLabel("Email");
        formPanel.add(emailLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        emailTextField = new JTextField();
        formPanel.add(emailTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        passwordLabel = new JLabel("Password");
        formPanel.add(passwordLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        passwordField = new JPasswordField();
        formPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 4;
        showPasswordBox = new JCheckBox("Show Password");
        formPanel.add(showPasswordBox, c);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        signUpButton = new JButton("Sign Up");
        buttonPanel.add(signUpButton);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        formPanel.add(buttonPanel, c);

        //When the showpassword box is ticked, passwordField will unredact what has been typed in the password field
        showPasswordBox.addActionListener(e -> {
            if (showPasswordBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        //Once signup button is clicked, next stage of signup will be shown
        signUpButton.addActionListener(e -> {
            System.out.println(formPanel.getSize());
            startPage.SwitchPanel(startPage.signupPanel1.formPanel);
        });

        //Only allow login if email and password are valid
        loginButton.addActionListener(e -> {
            if (startPage.Login(emailTextField.getText(), new String(passwordField.getPassword()))) {
                System.out.println("Login successful");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or password");
            }
        });

    }
}