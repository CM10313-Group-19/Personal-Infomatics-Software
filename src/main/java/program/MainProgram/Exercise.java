package program.MainProgram;

import com.toedter.calendar.JDateChooser;
import program.MainFrame;
import program.NonGUIElements.DataSet;
import program.NonGUIElements.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exercise extends Subpage {

    private JTextField startTimeTextField;
    private JTextField endTimeTextField;
    //create a textfield that only accepts numbers for distance
    private JTextField distanceTextField;
    private String type;
    private String exerciseTime;
    private String distance; //in km, to 2 dp
    private int duration;
    private String elevationGain; //in metres, to 2 dp
    private JDateChooser datePicker;
    private List<DataSet> distanceDataSets;
    private DataSet RunningDistanceDataSet;
    private DataSet CyclingDistanceDataSet;
    private DataSet SwimmingDistanceDataSet;
    private DataSet CombinedDistanceDataSet;

    //Dropdown menu to pick between activity types
    private final JComboBox<String> activityType = new JComboBox<>(new String[]{"Running", "Cycling", "Swimming"});

    public Exercise(MainPage mainPage, MainFrame mainFrame) {super();

        distanceDataSets = new ArrayList<>();
        //set up the data sets for the different types of exercise
        RunningDistanceDataSet = new DataSet(new ArrayList<>(), "Running Distance");
        CyclingDistanceDataSet = new DataSet(new ArrayList<>(), "Cycling Distance");
        SwimmingDistanceDataSet = new DataSet(new ArrayList<>(), "Swimming Distance");
        CombinedDistanceDataSet = new DataSet(new ArrayList<>(), "Combined Distance");
        distanceDataSets.add(RunningDistanceDataSet);
        distanceDataSets.add(CyclingDistanceDataSet);
        distanceDataSets.add(SwimmingDistanceDataSet);
        distanceDataSets.add(CombinedDistanceDataSet);

        JLabel exerciseLabel = new JLabel("Exercise");
        exerciseLabel.setFont(new Font("Arial", Font.BOLD, 25));
        exerciseLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(exerciseLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(new JLabel("Select Activity type: "), c);

        c.gridx = 0;
        c.gridy = 2;
        activityType.setPreferredSize(new Dimension(200, 20));
        mainPanel.add(activityType, c);

        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(new JLabel("Enter exercise start time: "), c);

        c.gridx = 0;
        c.gridy = 4;
        startTimeTextField = new JTextField();
        startTimeTextField.setPreferredSize(new Dimension(200, 20));
        startTimeTextField.setText("HH:MM");
        mainPanel.add(startTimeTextField, c);

        c.gridx = 0;
        c.gridy = 5;
        mainPanel.add(new JLabel("Enter exercise end time: "), c);

        c.gridx = 0;
        c.gridy = 6;
        endTimeTextField = new JTextField();
        endTimeTextField.setPreferredSize(new Dimension(200, 20));
        endTimeTextField.setText("HH:MM");
        mainPanel.add(endTimeTextField, c);

        c.gridx = 0;
        c.gridy = 7;
        mainPanel.add(new JLabel("Enter distance: "), c);
        c.gridx = 0;
        c.gridy = 8;
        distanceTextField = new JTextField();
        distanceTextField.setPreferredSize(new Dimension(200, 20));
        distanceTextField.setText("distance in km");
        mainPanel.add(distanceTextField, c);

        c.gridx = 0;
        c.gridy = 9;
        mainPanel.add(new JLabel("Enter elevation gain: "), c);
        c.gridx = 0;
        c.gridy = 10;
        JTextField elevationTextField = new JTextField();
        elevationTextField.setPreferredSize(new Dimension(200, 20));
        elevationTextField.setText("Elevation gain in m");
        mainPanel.add(elevationTextField, c);

        c.gridx = 0;
        c.gridy = 11;
        mainPanel.add(new JLabel("Enter date that exercise was recorded on:"), c);

        c.gridx = 0;
        c.gridy = 12;
        datePicker = new JDateChooser();
        mainPanel.add(datePicker, c);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);

        c.gridx = 0;
        c.gridy =13;
        c.gridwidth = 2;
        mainPanel.add(buttonPanel, c);

        //Add a button that creates a graph
        c.gridx = 0;
        c.gridy = 14;
        JButton exerciseStatisticsButton = new JButton("View exercise statistics");
        mainPanel.add(exerciseStatisticsButton, c);

        exerciseStatisticsButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.exerciseStatistics));

        this.add(mainPanel, BorderLayout.CENTER);

        datePicker.addPropertyChangeListener(e -> {
            //check not null
            if(datePicker.getDate() != null){
                if(datePicker.getDate().after(new java.util.Date())){
                    datePicker.setDate(new java.util.Date());
                }
            }
        });

        //only let user enter numbers in the distance textfield, and only up to 2dp
        distanceTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD))) {
                    e.consume();
                }
                if (distanceTextField.getText().contains(".") && c == KeyEvent.VK_PERIOD) {
                    e.consume();
                }
                if (distanceTextField.getText().length() > 4) {
                    e.consume();
                }
            }
        });

        //if text fileds are clicked, clear the text
        startTimeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startTimeTextField.setText("");
            }
        });

        endTimeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endTimeTextField.setText("");
            }
        });

        distanceTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                distanceTextField.setText("");
            }
        });

        //make sure elevation gain is only numbers and only up to 2dp
        elevationTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD))) {
                    e.consume();
                }
                if (elevationTextField.getText().contains(".") && c == KeyEvent.VK_PERIOD) {
                    e.consume();
                }
                if (elevationTextField.getText().length() > 4) {
                    e.consume();
                }
            }
        });

        elevationTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elevationTextField.setText("");
            }
        });

        //if swimming is selected, elevation gain is not required
        activityType.addActionListener(e -> {
            if (activityType.getSelectedItem().equals("Swimming")){
                elevationTextField.setText("N/A");
                elevationTextField.setEditable(false);
            }
            else{
                elevationTextField.setText("Elevation gain in m");
                elevationTextField.setEditable(true);
            }
        });

        submitButton.addActionListener(e -> {

            if (startTimeTextField.getText().equals("") || endTimeTextField.getText().equals("")){ // empty fields
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            }
            else if (!(Validation.validateTimeInput(startTimeTextField.getText())) || !(Validation.validateTimeInput(endTimeTextField.getText()))){ // wrong time format
                JOptionPane.showMessageDialog(null, "Invalid time format. Please put time in the 24HR time format.\nFormat: HH:MM");
            }
            else if(!(Validation.validateDistanceInput(distanceTextField.getText()))){
                JOptionPane.showMessageDialog(null, "Invalid distance format. Please put distance in the format: 0.0");
            }
            else if (Validation.calculateTimeDifference(startTimeTextField.getText(), endTimeTextField.getText()).equals("00:00")){ // start time is after end time
                JOptionPane.showMessageDialog(null, "Start time cannot be after end time");
            }
            else{

                //CONNECT TO DATABASE HERE
                exerciseTime = Validation.calculateTimeDifference(startTimeTextField.getText(), endTimeTextField.getText());
                duration =  Validation.calculateMinutes(exerciseTime);
                distance = distanceTextField.getText();
                elevationGain = elevationTextField.getText();
                type = activityType.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null, "Details Submitted.\nExercise duration: " + Validation.calculateTimeDifference(startTimeTextField.getText(), endTimeTextField.getText()) + "\nDistance: " + distanceTextField.getText() + "km"+ "\nElevation gain: " + elevationTextField.getText() + "m");
                updateDateSets(distanceDataSets, type, datePicker.getDate(), Double.parseDouble(distanceTextField.getText()));
            }

        });

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
    private List<DataSet> updateDateSets(List<DataSet> dataSet, String type, Date date, double value){

        switch (type){
            case "Running":
                dataSet.get(0).getDataPoints().add(new DataSet.DataPoint(date, value));
                break;
            case "Cycling":
                dataSet.get(1).getDataPoints().add(new DataSet.DataPoint(date, value));
                break;
            case "Swimming":
                dataSet.get(2).getDataPoints().add(new DataSet.DataPoint(date, value));
                break;
        }
        //if any exercise on that date already exists, add distance in dataSet.get(3) to the new distance, if not add new distance
        if (dataSet.get(3).checkForDuplicate(date)){
            DataSet.DataPoint oldDataPoint = dataSet.get(3).getDataPoint(date);
            dataSet.get(3).getDataPoints().add(new DataSet.DataPoint(date, oldDataPoint.getValue() + value));
        }
        else {
            dataSet.get(3).getDataPoints().add(new DataSet.DataPoint(date, value));
        }

        return dataSet;
    }
    protected List<DataSet> getDataSets(String choice){
        switch (choice){
            case "distance":
                return distanceDataSets;
        }
        return null;
    }
}
