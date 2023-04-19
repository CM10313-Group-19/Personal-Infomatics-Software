package program.MainProgram;

import com.toedter.calendar.JDateChooser;
import program.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Goals extends Subpage{

    private JTextField weightTextField;
    private JDateChooser datePicker;

    private static int goalCount = 0;

    private class Goal{
        private String goalDescription;
        private JTextArea goalDescriptionBox;
        private Date dueDate;
        private boolean isCompleted;
        private boolean isOverdue;
        private JPanel goalPanel;

        public Goal() {
            this.goalDescription = null;
            this.dueDate = null;
            this.isCompleted = false;

            goalPanel = new JPanel();
            goalPanel.setBackground(new Color(255, 255, 255));
            goalPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(10, 10, 10, 10);
            c.gridx = 0;
            c.gridy = 0;

            goalDescriptionBox = new JTextArea("Enter your goal here");
            JButton dateButton = new JButton("Click to set date");
            dateButton.setBorder(BorderFactory.createEmptyBorder());
            dateButton.setContentAreaFilled(false);

            ImageIcon tickIcon = new ImageIcon("src/main/resources/tick.png");
            JButton completeButton = new JButton(tickIcon);
            completeButton.setPreferredSize(new Dimension(48, 48));
            completeButton.setBorder(BorderFactory.createEmptyBorder());
            completeButton.setContentAreaFilled(false);
            ImageIcon deleteIcon = new ImageIcon("src/main/resources/delete.png");
            JButton deleteButton = new JButton(deleteIcon);
            deleteButton.setPreferredSize(new Dimension(48, 48));
            deleteButton.setBorder(BorderFactory.createEmptyBorder());
            deleteButton.setContentAreaFilled(false);
            goalPanel.add(deleteButton,c);
            c.gridx = 1;
            goalPanel.add(dateButton,c);

            c.gridx = 2;
            c.gridwidth = 2;
            goalDescriptionBox.setPreferredSize(new Dimension(200, 50));
            goalDescriptionBox.setLineWrap(true);
            goalDescriptionBox.setWrapStyleWord(true);
            goalDescriptionBox.setBackground(new Color(218, 218, 218));
            //set character limit to 100
            goalDescriptionBox.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    if (goalDescriptionBox.getText().length() >= 85) {
                        e.consume();
                    }
                }
            });
            goalDescriptionBox.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    if (goalDescriptionBox.getText().equals("Enter your goal here")) {
                        goalDescriptionBox.setText("");
                    }
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    if (goalDescriptionBox.getText().isEmpty()) {
                        goalDescriptionBox.setText("Enter your goal here");
                    }
                }
            });

            //if date button is clicked, a date picker will appear in a popup and set the date of the goal
            dateButton.addActionListener(e -> {
                datePicker = new JDateChooser();
                JOptionPane.showMessageDialog(null, datePicker, "Select a date", JOptionPane.PLAIN_MESSAGE);
                dueDate = datePicker.getDate();
                isOverdue = false;
                goalPanel.setBackground(new Color(255, 255, 255));
                goalDescriptionBox.setBackground(new Color(218, 218, 218));
                updateDueDate(dateButton, dueDate);
            });
            goalPanel.add(goalDescriptionBox,c);
            c.gridx = 4;
            goalPanel.add(completeButton,c);

            completeButton.addActionListener(e -> {
                isCompleted = !isCompleted;
                if(isCompleted){
                    goalPanel.setBackground(new Color(0, 255, 0));
                    goalDescriptionBox.setBackground(new Color(0, 230, 0));
                }else{
                    goalPanel.setBackground(new Color(255, 255, 255));
                    goalDescriptionBox.setBackground(new Color(218, 218, 218));
                }
            });

            deleteButton.addActionListener(e -> {
                mainPanel.remove(goalPanel);
                goalCount--;
                mainPanel.revalidate();
            });
        }

        private void updateDueDate(JButton dateButton, Date dueDate){
            if(dueDate!=null){
                if(dueDate.before(Calendar.getInstance().getTime())){
                    dueDate=Calendar.getInstance().getTime();
                }
                dateButton.setText(dueDate.getDate()+"/"+(dueDate.getMonth()+1)+"/"+(dueDate.getYear()+1900));

            }
        }

        public Date getDueDate(){
            return dueDate;
        }
        public String getGoalDescription(){
            return goalDescription;
        }
        public boolean getIsCompleted(){
            return isCompleted;
        }
        public void makeOverdue(){
            this.isOverdue = true;
            goalPanel.setBackground(new Color(255, 0, 0));
            goalDescriptionBox.setBackground(new Color(230, 0, 0));
        }
    }

    JButton addGoalButton;

    private void checkForOverdueGoals(ArrayList<Goal> goals){
        Date dueDate;
        boolean isCompleted;
        Goal goal;
        for(int i = 0; i < goals.size(); i++){
            goal = goals.get(i);
            dueDate = goal.getDueDate();
            if(dueDate.before(Calendar.getInstance().getTime())){
                goal.makeOverdue();
            }
        }
    }

    public Goals(MainPage mainPage, MainFrame mainFrame) {super();

        //create an array list of goal objects
        ArrayList<Goal> listOfGoals = new ArrayList<>();

        //LOAD IN GOALS FROM DATABASE

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        addGoalButton = new JButton("Add Goal");
        addGoalButton.setPreferredSize(new Dimension(300, 30));
        mainPanel.add(addGoalButton, c);
        c.gridy = goalCount+1;

        //when add goal button is clicked, a new goal is added
        addGoalButton.addActionListener(e -> {
            //check there is space for another goal
            if(goalCount >= 8){
                return;
            }

            Goal goal = new Goal();
            mainPanel.add(goal.goalPanel, c);
            goalCount++;
            c.gridy = goalCount+1;
            mainPanel.revalidate();
            listOfGoals.add(goal);
        });

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
