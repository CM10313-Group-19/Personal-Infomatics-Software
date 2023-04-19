package program;
import program.MainProgram.MainPage;
import program.Start.StartPage;
import javax.swing.*;
import java.awt.*;

/**
 * Class extends JFrame and is where StartPage and MainPage JPanel's are added to
 */
public class MainFrame extends JFrame {
    public MainPage mainPage;
    public StartPage startPage;

    public MainFrame() {

        //Setting up the main frame
        this.setTitle(Main.NAME);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximizes the frame on startup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 620));
        ImageIcon frameIcon = new ImageIcon("src/main/resources/logo.png");
        this.setIconImage(frameIcon.getImage());
        mainPage = new MainPage(this);
        startPage = new StartPage(this);
        this.add(startPage);
        this.setVisible(true);

    }

    /**
     * Method to switch between the StartPage and MainPage JPanel's
     * @param panel The panel to be added to the frame
     */
    public void SwitchPanel(JPanel panel){
        this.getContentPane().removeAll(); //Removes all components from the frame
        this.add(panel); //Adds the panel passed in to the frame
        this.revalidate();
        this.repaint(); //Refreshes the frame
    }
}


