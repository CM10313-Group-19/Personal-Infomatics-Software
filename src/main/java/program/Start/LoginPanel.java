package program.Start;

import program.MainFrame;

import javax.swing.*;
import java.awt.*;
public class LoginPanel extends JPanel {
    private final JTextField emailTextField;
    private final JPasswordField passwordField;
    private final JCheckBox showPasswordBox;
    public JPanel formPanel;

    public LoginPanel(StartPage startPage, MainFrame mainFrame){

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 100, 100, 100)));

        JLabel titleLabel = new JLabel("Personal Infomatics");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        formPanel.add(titleLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        JLabel emailLabel = new JLabel("Email");
        formPanel.add(emailLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(200, 20));
        formPanel.add(emailTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        JLabel passwordLabel = new JLabel("Password");
        formPanel.add(passwordLabel, c);

        c.gridx = 0;
        c.gridy = 4;
        passwordField = new JPasswordField();
        formPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 5;
        showPasswordBox = new JCheckBox("Show Password");
        formPanel.add(showPasswordBox, c);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        JButton signUpButton = new JButton("Sign Up");
        buttonPanel.add(signUpButton);

        c.gridx = 0;
        c.gridy = 6;
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
        signUpButton.addActionListener(e -> startPage.SwitchPanel(startPage.signupPanel1.formPanel));

        //Only allow login if email and password are valid
        loginButton.addActionListener(e -> {
            if (startPage.Login(emailTextField.getText(), new String(passwordField.getPassword()))) {
                mainFrame.SwitchPanel(mainFrame.mainPage);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or password");
            }
        });

    }
}
