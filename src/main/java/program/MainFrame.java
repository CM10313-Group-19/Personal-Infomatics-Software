package program;
import program.MainProgram.MainPage;
import program.Start.StartPage;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public JPanel mainPanel;

    public MainFrame() {

        //Setting up the main frame
        this.setTitle(Main.NAME);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximizes the frame on startup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes the program when the frame is closed
        this.setMinimumSize(new Dimension(400, 620));
        ImageIcon frameIcon = new ImageIcon("src/main/resources/logo.png");
        this.setIconImage(frameIcon.getImage());
        StartPage startPage = new StartPage(this);
        MainPage mainPage = new MainPage();
        this.add(startPage);
        this.setVisible(true);
    }
    public void SwitchPanel(JPanel panel){
        this.getContentPane().removeAll();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }
}


