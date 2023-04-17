package program.MainProgram;

import program.MainFrame;

import javax.swing.*;
import java.awt.*;


//import java.time.*;

public class Sleep extends Subpage {

    private final JTextField sleepTimeTextField;
    private final JTextField wakeUpTextField;

    //private final JTextField sleepTimeTextField;
    public Sleep(MainPage mainPage, MainFrame mainFrame) {
        super();

        JLabel sleepLabel = new JLabel("Sleep");
        sleepLabel.setFont(new Font("Arial", Font.BOLD, 25));
        sleepLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(sleepLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        JLabel sleepTimeLabel = new JLabel("Enter sleep time: ");
        mainPanel.add(sleepTimeLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        sleepTimeTextField = new JTextField();
        sleepTimeTextField.setPreferredSize(new Dimension(200, 20));
        mainPanel.add(sleepTimeTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        JLabel wakeUpLabel = new JLabel("Enter wake up time: ");
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

        submitButton.addActionListener(e -> {
            String sleepTimeValue = sleepTimeTextField.getText(); // values of user input from text fields
            String wakeTimeValue = wakeUpTextField.getText();

            if (sleepTimeValue.equals("") || wakeTimeValue.equals("")){ // empty fields
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            }
            else if (!(Validation.validateTimeInput(sleepTimeValue)) || !(Validation.validateTimeInput(wakeTimeValue))){ // wrong time format
                JOptionPane.showMessageDialog(null, "Invalid time format. Please put time in the 24HR time format.\nFormat: HH:MM");
            }
            else{
                System.out.println(sleepTimeValue);
                System.out.println(wakeTimeValue);
                JOptionPane.showMessageDialog(null, "Details Submitted.\nTime Slept: " + Validation.calculateTimeDifference(sleepTimeValue, wakeTimeValue));
            }

        });

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
