package Start;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPasswordField passwordField;
    private JCheckBox showPasswordBox;
    private JButton loginButton;
    private JButton createAccountButton;
    public JPanel formPanel;

    public LoginPanel() {

        formPanel = new JPanel();
        formPanel.setBackground(new Color(236, 240, 241, 180));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 50, 100, 50)));

        //When the showpassword box is ticked, passwordField will unredact what has been typed in the password field
        showPasswordBox.addActionListener(e -> {
            if (showPasswordBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });
    }

}
