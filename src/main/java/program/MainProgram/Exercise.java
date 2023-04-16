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

public class Exercise extends Subpage {

    private final JTextField sleepTimeTextField;
    private final JTextField wakeUpTextField;

    //private final JTextField sleepTimeTextField;
    public Exercise(MainPage mainPage, MainFrame mainFrame) {
        super();

        JLabel exerciseLabel = new JLabel("Exercise");
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

        c.gridx = 0;
        c.gridy = 1;
        JLabel sleepTimeLabel = new JLabel("Enter Sleep Time: ");
        mainPanel.add(sleepTimeLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        sleepTimeTextField = new JTextField();
        sleepTimeTextField.setPreferredSize(new Dimension(200, 20));
        mainPanel.add(sleepTimeTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        JLabel wakeUpLabel = new JLabel("Enter Wake Up Time: ");
        mainPanel.add(wakeUpLabel, c);

        c.gridx = 0;
        c.gridy = 4;
        wakeUpTextField = new JTextField();
        wakeUpTextField.setPreferredSize(new Dimension(200, 20));
        mainPanel.add(wakeUpTextField, c);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        mainPanel.add(buttonPanel, c);

        this.add(mainPanel, BorderLayout.CENTER);

        //If back button is clicked, loginPanel will be displayed
        backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
