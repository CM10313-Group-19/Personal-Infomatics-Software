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

    // private final JTextField sleepTimeTextField;
    public Food(MainPage mainPage, MainFrame mainFrame) {
        super();

        JLabel exerciseLabel = new JLabel("Food");
        exerciseLabel.setFont(new Font("Arial", Font.BOLD, 25));
        exerciseLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // create and format 5ADLabel
        JLabel fiveADLabel = new JLabel("5 a day");
        fiveADLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        fiveADLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fiveADLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // create and format buttons
        JButton[] buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(50, 50));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        // set layout to gridbaglayout and add components
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(exerciseLabel, c);

        c.gridy = 1;
        mainPanel.add(fiveADLabel, c);

        for (int i = 0; i < 5; i++) {
            c.gridx = i;
            c.gridy = 2;
            mainPanel.add(buttons[i], c);
        }

        this.add(mainPanel, BorderLayout.CENTER);

        // If back button is clicked, loginPanel will be displayed
        backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
