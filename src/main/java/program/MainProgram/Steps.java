package program.MainProgram;

import com.toedter.calendar.JDateChooser;
import program.MainFrame;
import program.NonGUIElements.DataSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Steps extends Subpage{

    private JTextField stepsTextField;
    private JDateChooser datePicker;
    private TimeChart stepsChart;
    private List<DataSet.DataPoint> dataPoints;

    public Steps(MainPage mainPage, MainFrame mainFrame) {super();

        JLabel stepsLabel = new JLabel("Step Tracker");
        stepsLabel.setFont(new Font("Arial", Font.BOLD, 25));
        stepsLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(stepsLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(new JLabel("Enter daily steps:"), c);

        c.gridx = 0;
        c.gridy = 2;
        stepsTextField = new JTextField();
        stepsTextField.setPreferredSize(new Dimension(200, 20));
        stepsTextField.setText("Number of steps:");
        mainPanel.add(stepsTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(new JLabel("Enter date that step count was recorded on:"), c);

        c.gridx = 0;
        c.gridy = 4;
        datePicker = new JDateChooser();
        mainPanel.add(datePicker, c);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        c.gridx = 0;
        c.gridy = 5;
        mainPanel.add(buttonPanel, c);

        this.add(mainPanel, BorderLayout.CENTER);

        stepsTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (stepsTextField.getText().equals("Number of steps:")) {
                    stepsTextField.setText("");
                }
            }
        });
        stepsTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (stepsTextField.getText().length() >= 6) {
                    e.consume();
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        submitButton.addActionListener(e -> {

            if(datePicker.getDate() == null){
                JOptionPane.showMessageDialog(null, "Please enter a number of steps and date");
            }
            else{
                dataPoints.add(new DataSet.DataPoint(datePicker.getDate(), Double.parseDouble(stepsTextField.getText())));
            }
        });

        c.gridx = 0;
        c.gridy = 6;
        JButton chartButton = new JButton("Display steps chart");
        mainPanel.add(chartButton, c);

        dataPoints = new ArrayList<>();

        //if chart button is clicked, chart will be displayed
        chartButton.addActionListener(e -> {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //close all JFrames apart from main frame
                    if(stepsChart != null) stepsChart.dispose();
                    List<DataSet> dataSets = new ArrayList<>();
                    dataSets.add(new DataSet(dataPoints, "Number of steps you took that day"));
                    stepsChart = new TimeChart(dataSets, "Steps over time", "Steps", "Date",10);
                }
            });
        });

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
