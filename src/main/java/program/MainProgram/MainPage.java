package program.MainProgram;
import program.MainFrame;
import program.MainGUIPanel;
public class MainPage extends MainGUIPanel {
    public Exercise exercisePanel;
    public Food foodPanel;
    public Sleep sleepPanel;

    /**
     * Main page of the program
     */
    public MainPage(MainFrame mainFrame) {
        super(mainFrame);
        exercisePanel = new Exercise(this, mainFrame);
        foodPanel = new Food(this, mainFrame);
        sleepPanel = new Sleep(this, mainFrame);
        Menu menu = new Menu(this, mainFrame);
        this.add(menu.formPanel);
        }

        /**
         * Removes the panel StartPage is currently displaying and replaces it with the JPanel passed in
         * @param formPanel is the JPanel that will be displayed
         */

}
