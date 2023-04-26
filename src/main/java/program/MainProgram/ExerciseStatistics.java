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

public class ExerciseStatistics extends Subpage{
    private List<DataSet.DataPoint> dataPoints;
    private TimeChart exerciseDistanceChart;
    public ExerciseStatistics(MainPage mainPage, MainFrame mainFrame) {super();

        JLabel stepsLabel = new JLabel("Step Tracker");
        stepsLabel.setFont(new Font("Arial", Font.BOLD, 25));
        stepsLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        JButton exerciseDistanceButton = new JButton("Display Exercise Distance");
        exerciseDistanceButton.addActionListener(e -> {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //close all JFrames apart from main frame
                    if(exerciseDistanceChart != null) exerciseDistanceChart.dispose();
                    List<DataSet> dataSets = new ArrayList<>();
                    dataSets.add(new DataSet(dataPoints, "Your daily exercise distance"));
                    exerciseDistanceChart = new TimeChart(mainPage.exercisePanel.getDataSets("distance"), "Your daily exercise distance", "Distance(km)", "Date",10);
                }
            });
        });
        mainPanel.add(exerciseDistanceButton, c);


        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
