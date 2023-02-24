package program;

import program.Start.LoginPanel;
import program.Start.SignupPanel1;
import program.Start.SignupPanel2;

import javax.swing.*;
import java.awt.*;

public class MainGUIPanel extends JPanel {
    public MainGUIPanel(MainFrame mainFrame) {
        this.setBackground(new Color(230, 126, 34));
        this.setLayout(new GridBagLayout());
        this.setVisible(true);
    }
    public void SwitchPanel(JPanel formPanel) {
        this.removeAll();
        this.add(formPanel);
        this.revalidate();
        this.repaint();
    }
}
