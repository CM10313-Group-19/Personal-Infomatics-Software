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

public class Sleep extends JPanel {

    private final JTextField sleepTimeTextField;
    private final JTextField wakeUpTextField;

    private static String calculateSleep(String timeString1, String timeString2){
        /** A bit broken atm cause cant work out time correctly **/
        SimpleDateFormat format24HRS = new SimpleDateFormat("HH:mm");
        try {
            Date timeDate1 = format24HRS.parse(timeString1);
            Date timeDate2 = format24HRS.parse(timeString2);
            System.out.println(timeDate1);
            System.out.println(timeDate2);

            long calculateMS = Math.abs(timeDate2.getTime() - timeDate1.getTime()); // time in milliseconds for conversions
            System.out.println(timeDate2.getTime());
            System.out.println(calculateMS);

            long calculateHours = (calculateMS / (60 * 60 * 1000)) % 24; // hours
            System.out.println(calculateHours);

            long calculateMins = (calculateMS / (60 * 1000)) % 60; // minutes
            System.out.println(calculateMins);

            return calculateHours + ":" + calculateMins;
        }
        catch (ParseException e) {
            return "00:00";
        }
    }

    private static long calculateMinutes(String timeString1, String timeString2){
        SimpleDateFormat format24HRS = new SimpleDateFormat("HH:mm");
        try {
            Date timeDate1 = format24HRS.parse(timeString1);
            Date timeDate2 = format24HRS.parse(timeString2);

            long calculateMS = Math.abs(timeDate2.getTime() - timeDate1.getTime()); // time in milliseconds for conversions
            long calculateMins = (calculateMS / (60 * 1000)) % 60; // minutes

            return calculateMins;
        }
        catch (ParseException e) {
            return 0;
        }
    }


    private boolean validateDateInput(String userTimeInput){
        Pattern timeFormat = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]"); // regex pattern for 24hr time format
        Matcher timeMatcher = timeFormat.matcher(userTimeInput);
        return timeMatcher.matches();
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
            String sleepTimeValue = sleepTimeTextField.getText(); // values of user input from text fields
            String wakeTimeValue = wakeUpTextField.getText();

            if (sleepTimeValue.equals("") || wakeTimeValue.equals("")){ // empty fields
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            }
            else if (!(validateDateInput(sleepTimeValue)) || !(validateDateInput(wakeTimeValue))){ // wrong time format
                JOptionPane.showMessageDialog(null, "Invalid time format. Please put time in the 24HR time format.\nFormat: HH:MM");
            }
            else{
                System.out.println(sleepTimeValue);
                System.out.println(wakeTimeValue);
                JOptionPane.showMessageDialog(null, "Details Submitted.\nTime Slept: " + calculateSleep(sleepTimeValue, wakeTimeValue));
            }

        });

        //If back button is clicked, loginPanel will be displayed
        backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
