package program.MainProgram;
import program.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {
    public JPanel mainPagePanel;
    public Exercise exercisePanel;
    public Food foodPanel;
    public Sleep sleepPanel;

    /**
     * Main page of the program
     */
    public MainPage(MainFrame mainFrame) {
        exercisePanel = new Exercise(this, mainFrame);
        foodPanel = new Food(this, mainFrame);
        sleepPanel = new Sleep(this, mainFrame);
        Menu menu = new Menu(this, mainFrame);
        this.setBackground(new Color(230, 126, 34));
        this.setLayout(new GridBagLayout());
        this.add(menu.formPanel);
        this.setVisible(true);
        }

        /**
         * Removes the panel StartPage is currently displaying and replaces it with the JPanel passed in
         * @param formPanel is the JPanel that will be displayed
         */
    public void SwitchPanel(JPanel formPanel) {
        this.removeAll();
        this.add(formPanel);
        this.revalidate();
        this.repaint();
    }


}
