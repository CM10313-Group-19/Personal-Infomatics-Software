package program.MainProgram;

import com.toedter.calendar.JDateChooser;
import program.BackendCommunication.LoginBackend;
import program.MainFrame;
import program.NonGUIElements.DataSet;
import program.BackendCommunication.WeightBackend;
import program.NonGUIElements.Validation;
import program.Start.StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Weight extends Subpage{

    private JTextField weightTextField;
    private JDateChooser datePicker;
    private TimeChart weightChart;
    private List<DataSet.DataPoint> dataPoints;

    public Weight(MainPage mainPage, MainFrame mainFrame) {super();

        JLabel weightLabel = new JLabel("Weight Tracker");
        weightLabel.setFont(new Font("Arial", Font.BOLD, 25));
        weightLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(weightLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(new JLabel("Enter weight:"), c);

        c.gridx = 0;
        c.gridy = 2;
        weightTextField = new JTextField();
        weightTextField.setPreferredSize(new Dimension(200, 20));
        weightTextField.setText("Enter weight in kg");
        mainPanel.add(weightTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(new JLabel("Enter date that weight was recorded on: "), c);

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

        //Only allow numbers and a decimal point with 2 decimal places to be entered into the weight textfield

        weightTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (weightTextField.getText().equals("Enter weight in kg")) {
                    weightTextField.setText("");
                }
            }
        });
        //Only allow up to 3 digits before the decimal point and 2 digits after
        weightTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    e.consume();
                } else if (c == '.' && weightTextField.getText().contains(".")) {
                    e.consume();
                } else if (Character.isDigit(c) && weightTextField.getText().indexOf('.') != -1
                        && weightTextField.getText().substring(weightTextField.getText().indexOf('.')).length() == 3) {
                    e.consume();
                } else if (weightTextField.getText().length() >= 6) {
                    e.consume();
                }
            }
        });


        submitButton.addActionListener(e -> {

            if(datePicker.getDate() == null){
                JOptionPane.showMessageDialog(null, "Please enter a weight and date");
            }
            else if(weightTextField.getText().equals("Enter weight in kg") || weightTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a weight");
            }
            else{
                //add weight to database
                WeightBackend.record_weight(mainFrame.startPage.getUserID(),Validation.dateToyyyymmddDash(datePicker.getDate()), weightTextField.getText());
                dataPoints.add(new DataSet.DataPoint(datePicker.getDate(), Double.parseDouble(weightTextField.getText())));
            }
        });

        //Display weight chart
        c.gridx = 0;
        c.gridy = 6;
        JButton chartButton = new JButton("Display Weight Chart");
        mainPanel.add(chartButton, c);

        //if chart button is clicked, chart will be displayed
        chartButton.addActionListener(e -> {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {

                    //close all JFrames apart from main frame
                    if(weightChart != null) weightChart.dispose();
                    dataPoints = DataSet.fromWeights(WeightBackend.get_weights(mainFrame.startPage.getUserID()), "weight").getDataPoints();
                    List<DataSet> dataSets = new ArrayList<>();
                    dataSets.add(new DataSet(dataPoints, "Your weight in kg"));
                    weightChart = new TimeChart(dataSets, "Weight over time", "Weight", "Date",10);
                }
            });
        });

        datePicker.addPropertyChangeListener(e -> {
            //check not null
            if(datePicker.getDate() != null){
                if(datePicker.getDate().after(new java.util.Date())){
                    datePicker.setDate(new java.util.Date());
                }
            }
        });

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
