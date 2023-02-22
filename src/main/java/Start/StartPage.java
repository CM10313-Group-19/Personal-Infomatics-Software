package Start;
import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;
public class StartPage extends JPanel {
    public LoginPanel loginPanel;
    public StartPage() {

        loginPanel = new LoginPanel();
        this.setBackground(new Color(230, 126, 34));
        this.setLayout(new GridBagLayout());
        this.add(loginPanel.formPanel);
        this.setVisible(true);
    }
}
