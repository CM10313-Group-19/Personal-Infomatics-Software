package program.MainProgram;
import program.MainFrame;
import program.MainGUIPanel;
public class MainPage extends MainGUIPanel {
    public Exercise exercisePanel;
    public Food foodPanel;
    public Sleep sleepPanel;
    public Menu menuPanel;

    /**
     * Main page of the program
     */
    public MainPage(MainFrame mainFrame) {
        super(mainFrame);
        exercisePanel = new Exercise(this, mainFrame);
        foodPanel = new Food(this, mainFrame);
        sleepPanel = new Sleep(this, mainFrame);
        menuPanel = new Menu(this, mainFrame);
        this.add(menuPanel);
        }

}
