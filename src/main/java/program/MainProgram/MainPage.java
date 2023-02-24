package program.MainProgram;

import program.MainFrame;
import program.Start.LoginPanel;
import program.Start.SignupPanel1;
import program.Start.SignupPanel2;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {
    public JPanel mainPagePanel;

    /**
     * Main page of the program
     */
    public MainPage(MainFrame mainFrame) {
        Exercise exercisePanel = new Exercise(this, mainFrame);
        Food foodPanel = new Food(this, mainFrame);
        Sleep sleepPanel = new Sleep(this, mainFrame);
        Menu menu = new Menu(this, mainFrame, exercisePanel, foodPanel, sleepPanel);
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
