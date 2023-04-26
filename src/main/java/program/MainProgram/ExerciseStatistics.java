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
    public ExerciseStatistics(MainPage mainPage, MainFrame mainFrame) {super();

        JLabel stepsLabel = new JLabel("Step Tracker");
        stepsLabel.setFont(new Font("Arial", Font.BOLD, 25));
        stepsLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        //set layout to gridbaglayout and add components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
