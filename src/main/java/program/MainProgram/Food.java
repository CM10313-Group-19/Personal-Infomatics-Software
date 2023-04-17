package program.MainProgram;

import program.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;


//import java.time.*;

public class Food extends Subpage {

    //private final JTextField sleepTimeTextField;
    public Food(MainPage mainPage, MainFrame mainFrame) {
        super();

        JLabel exerciseLabel = new JLabel("Food");
        exerciseLabel.setFont(new Font("Arial", Font.BOLD, 25));
        exerciseLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(exerciseLabel, c);

        this.add(mainPanel, BorderLayout.CENTER);

        //If back button is clicked, loginPanel will be displayed
        backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
