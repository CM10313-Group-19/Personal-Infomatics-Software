import Start.StartPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame extends JFrame {
    public MainFrame() {

        //Setting up the main frame
        this.setTitle("Main Frame");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximizes the frame on startup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes the program when the frame is closed
        this.setLayout(new CardLayout()); //Sets the layout to CardLayout so that the panels can be switched out
        this.setMinimumSize(new Dimension(360, 380));

        StartPage startPage = new StartPage();
        this.add(startPage);

        this.setVisible(true);

    }



}


