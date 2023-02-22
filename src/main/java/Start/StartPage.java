package Start;
import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;
public class StartPage extends JPanel {
    public LoginPanel loginPanel;
    public SignupPanel signupPanel;

    public StartPage() {

        loginPanel = new LoginPanel(this);
        signupPanel = new SignupPanel(this);
        this.setBackground(new Color(230, 126, 34));
        this.setLayout(new GridBagLayout());
        this.add(loginPanel.formPanel);
        this.setVisible(true);
    }

    public void SwitchPanel(JPanel formPanel) {
        this.removeAll();
        this.add(formPanel);
        this.revalidate();
        this.repaint();
    }
}
