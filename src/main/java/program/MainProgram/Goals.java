package program.MainProgram;

import com.toedter.calendar.JDateChooser;
import program.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

public class Goals extends Subpage{

    private JTextField weightTextField;
    private JDateChooser datePicker;

    private class Goal{
        private String goalDescription;
        private Date dueDate;
        private boolean isCompleted; ;
        public JPanel goalPanel;

        public Goal(String goalDescription, Date dueDate) {
            this.goalDescription = goalDescription;
            this.dueDate = dueDate;
            this.isCompleted = false;

            goalPanel = new JPanel();
            goalPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(10, 10, 10, 10);
            c.gridx = 0;
            c.gridy = 0;

            JTextArea goalDescriptionBox = new JTextArea(goalDescription);
            JLabel goalDateLabel = new JLabel(dueDate.toString());
            JButton completeButton = new JButton("Complete");
            JButton deleteButton = new JButton("Delete");
            goalPanel.add(deleteButton,c);
            c.gridx = 1;
            goalPanel.add(goalDateLabel,c);
            c.gridx = 2;
            //set goalDescriptionLabel to be wider
            goalDescriptionBox.setPreferredSize(new Dimension(200, 50));
            //make the text in goalDescriptionLabel span multiple lines
            goalDescriptionBox.setLineWrap(true);

            goalPanel.add(goalDescriptionBox,c);
            c.gridx = 3;
            goalPanel.add(completeButton,c);

            completeButton.addActionListener(e -> {
                isCompleted = true;
                goalPanel.setBackground(Color.GREEN);
            });

            deleteButton.addActionListener(e -> {
                mainPanel.remove(goalPanel);
                mainPanel.revalidate();
            });
        }
    }

    JButton addGoalButton;

    public Goals(MainPage mainPage, MainFrame mainFrame) {super();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        addGoalButton = new JButton("Add Goal");
        mainPanel.add(addGoalButton, c);
        final int[] y = {1};

        //when add goal button is clicked, a new goal is added
        addGoalButton.addActionListener(e -> {
            System.out.println("Add goal button clicked");
            Goal goal = new Goal("goalDescription", new Date("2020/12/12"));
            c.gridy = y[0];
            mainPanel.add(goal.goalPanel, c);
            y[0]++;
            mainPanel.revalidate();
        });

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
