package program.MainProgram;
import program.MainFrame;
import program.MainGUIPanel;
import program.Start.StartPage;

public class MainPage extends MainGUIPanel {
    public Exercise exercisePanel;
    public Food foodPanel;
    public Sleep sleepPanel;
    public Menu menuPanel;
    public StartPage startPage;
    public Weight weightPanel;
    public Goals goalsPanel;
    public Steps stepsPanel;



    /**
     * Main page of the program
     */
    public MainPage(MainFrame mainFrame) {
        super(mainFrame);
        exercisePanel = new Exercise(this, mainFrame);
        foodPanel = new Food(this, mainFrame);
        sleepPanel = new Sleep(this, mainFrame);
        menuPanel = new Menu(this, mainFrame);
        weightPanel = new Weight(this, mainFrame);
        goalsPanel = new Goals(this, mainFrame);
        startPage = mainFrame.startPage;
        stepsPanel = new Steps(this, mainFrame);

        this.add(menuPanel);
        }
}
