package program.MainProgram;

import javax.swing.*;

public class MainPage extends JPanel {
    public JPanel mainPagePanel;

    public MainPage() {
        mainPagePanel = new JPanel();
        mainPagePanel.setLayout(new BoxLayout(mainPagePanel, BoxLayout.Y_AXIS));
        mainPagePanel.add(new Sleep());
        mainPagePanel.add(new Food());
        mainPagePanel.add(new Exercise());
        this.add(mainPagePanel);
    }

}
