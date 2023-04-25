package program.MainProgram;

import com.toedter.calendar.JDateChooser;
import program.MainFrame;
import program.NonGUIElements.Validation;
import program.NonGUIElements.DataSet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Sleep extends Subpage {

    private final JTextField sleepTimeTextField;
    private final JTextField wakeUpTextField;

    private JDateChooser datePicker;
    private TimeChart sleepChart;
    private List<DataSet.DataPoint> dataPoints;
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

        c.gridx = 0;
        c.gridy = 5;
        JLabel dateLabel = new JLabel("Enter date sleep started on: ");
        mainPanel.add(dateLabel, c);

        c.gridx = 0;
        c.gridy = 6;
        datePicker = new JDateChooser();
        mainPanel.add(datePicker, c);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        mainPanel.add(buttonPanel, c);

        this.add(mainPanel, BorderLayout.CENTER);
        dataPoints = new ArrayList<>();

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
                String timeSlept = Validation.calculateTimeDifference(sleepTimeValue, wakeTimeValue);
                Double timeSleptDouble = Double.parseDouble(timeSlept.substring(0,2)) + Double.parseDouble(timeSlept.substring(3,5))/60;

                dataPoints.add(new DataSet.DataPoint(datePicker.getDate(), timeSleptDouble));
            }
        });

        //add button like button in weight class that will display a graph of sleep duration over time
        JButton chartButton = new JButton("Display sleep chart");
        c.gridx = 0;
        c.gridy = 8;
        mainPanel.add(chartButton, c);

        chartButton.addActionListener(e -> {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //close all JFrames apart from main frame
                    if(sleepChart != null) sleepChart.dispose();
                    //Create a new array list with new DataSet as only element
                    List<DataSet> dataSets = new ArrayList<>();
                    dataSets.add(new DataSet(dataPoints, "Amount of hours you slept"));
                    sleepChart = new TimeChart(dataSets, "Sleep duration over time", "Sleep duration", "Date",2);
                }
            });
        });


        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
