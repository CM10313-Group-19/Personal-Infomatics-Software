package program.MainProgram;

import program.MainFrame;

import javax.swing.*;
import java.awt.*;

//import java.time.*;

public class Sleep extends JPanel {

    private final JTextField sleepTimeTextField;
    private final JTextField wakeUpTextField;

    static int calculateSleep(String timeString1, String timeString2){
        try {
            int timeInteger1 = Integer.parseInt(timeString1);
            int timeInteger2 = Integer.parseInt(timeString2);

            return timeInteger2 - timeInteger1;
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }


    //private final JTextField sleepTimeTextField;
    public Sleep(MainPage mainPage, MainFrame mainFrame) {

        this.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94), 3));

        this.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon backArrowIcon = new ImageIcon("src/main/resources/back-arrow.png");
        Image backArrowImage = backArrowIcon.getImage();
        Image newBackArrowImage = backArrowImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon backArrow = new ImageIcon(newBackArrowImage);
        JButton backButton = new JButton(backArrow);
        topPanel.add(backButton);

        this.add(topPanel, BorderLayout.NORTH);
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 100 , 100, 100));


        JLabel sleepLabel = new JLabel("Sleep");
        sleepLabel.setFont(new Font("Arial", Font.BOLD, 25));
        sleepLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(sleepLabel, c);

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

        submitButton.addActionListener(e -> {
            String sleepTimeValue = sleepTimeTextField.getText();
            String wakeTimeValue = wakeUpTextField.getText();
            System.out.println(sleepTimeValue);
            System.out.println(wakeTimeValue);
            JOptionPane.showMessageDialog(null, "Details Submitted.\nTime Slept: " + calculateSleep(sleepTimeValue, wakeTimeValue));
        });


        //If back button is clicked, loginPanel will be displayed
        //backButton.addActionListener(e -> Menu.SwitchPanel(Menu.menu));
    }
}
