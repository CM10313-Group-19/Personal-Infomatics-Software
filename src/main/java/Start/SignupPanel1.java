package Start;
import javax.swing.*;
import java.awt.*;

public class SignupPanel1 extends JPanel {

    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordField;
    private JCheckBox showPasswordBox;
    private JButton signUpButton;
    public JPanel formPanel;

    public SignupPanel1(StartPage startPage){

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 100 , 100, 100)));

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
        confirmPasswordLabel = new JLabel("Confirm Password");
        formPanel.add(confirmPasswordLabel, c);

        c.gridx = 0;
        c.gridy = 5;
        confirmPasswordField = new JPasswordField();
        formPanel.add(confirmPasswordField, c);

        c.gridx = 0;
        c.gridy = 6;
        showPasswordBox = new JCheckBox("Show Password");
        formPanel.add(showPasswordBox, c);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        signUpButton = new JButton("Sign Up");
        formPanel.add(signUpButton, c);

        //When the showpassword box is ticked, passwordField will unredact what has been typed in the password field
        showPasswordBox.addActionListener(e -> {
            if (showPasswordBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        //If signup button is clicked, signup panel 1 will be displayed
        signUpButton.addActionListener(e -> {
            System.out.println(formPanel.getSize());
            startPage.SwitchPanel(startPage.signupPanel2.formPanel);
        });

    }
}
