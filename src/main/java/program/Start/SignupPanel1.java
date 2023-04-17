package program.Start;
import javax.swing.*;
import java.awt.*;

public class SignupPanel1 extends JPanel {
    private final JTextField emailTextField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;
    private final JCheckBox showPasswordBox;

    public SignupPanel1(StartPage startPage){

        this.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94), 3));
        this.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon backArrowIcon = new ImageIcon("src/main/resources/back-arrow.png");
        Image backArrowImage = backArrowIcon.getImage();
        Image newBackArrowImage = backArrowImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon backArrow = new ImageIcon(newBackArrowImage);
        JButton backButton = new JButton(backArrow);
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
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setPreferredSize(new Dimension(200, 20));
        bottomPanel.add(emailLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        emailTextField = new JTextField();
        bottomPanel.add(emailTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        JLabel passwordLabel = new JLabel("Password");
        bottomPanel.add(passwordLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        passwordField = new JPasswordField();
        bottomPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 4;
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        bottomPanel.add(confirmPasswordLabel, c);

        c.gridx = 0;
        c.gridy = 5;
        confirmPasswordField = new JPasswordField();
        bottomPanel.add(confirmPasswordField, c);

        c.gridx = 0;
        c.gridy = 6;
        showPasswordBox = new JCheckBox("Show Password");
        bottomPanel.add(showPasswordBox, c);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        JButton signUpButton = new JButton("Sign Up");
        bottomPanel.add(signUpButton, c);
        this.add(bottomPanel, BorderLayout.CENTER);

        //When the showPassword box is ticked, passwordField will un-redact what has been typed in the password field
        showPasswordBox.addActionListener(e -> {
            System.out.println(this.getSize());
            if (showPasswordBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
                confirmPasswordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
                confirmPasswordField.setEchoChar('*');
            }
        });

        //If signup button is clicked, signup panel 2 will be displayed if the passwords match and the email is valid and not already in use and all fields are filled. do checks in a method in startpage
        signUpButton.addActionListener(e -> {
            String attemptCreateAccount = (startPage.validateEmailAndPassword(emailTextField.getText(), passwordField.getText(), confirmPasswordField.getText()));
            System.out.println(attemptCreateAccount);
            switch (attemptCreateAccount) {
                case "success" -> startPage.SwitchPanel(startPage.signupPanel2);
                case "passwords do not match" -> JOptionPane.showMessageDialog(null, "Passwords do not match");
                case "email in use" -> JOptionPane.showMessageDialog(null, "Email already in use");
                case "invalid email" -> JOptionPane.showMessageDialog(null, "Invalid email");
                case "empty fields" -> JOptionPane.showMessageDialog(null, "Please fill in all fields");
                case "invalid password" -> JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and a special character");
            }
        });


        //If back button is clicked, loginPanel will be displayed
        backButton.addActionListener(e -> startPage.SwitchPanel(startPage.loginPanel));

    }
    public String getEmail() {
        return emailTextField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }
}
