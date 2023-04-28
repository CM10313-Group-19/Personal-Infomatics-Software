package program.MainProgram;

import program.MainFrame;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;

//import java.time.*;
public class Food extends Subpage {

    private final JButton[] buttons = new JButton[5];

    public Food(MainPage mainPage, MainFrame mainFrame) {
        super();

        JLabel exerciseLabel = new JLabel("Food");
        exerciseLabel.setFont(new Font("Arial", Font.BOLD, 25));
        exerciseLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JLabel fiveADayLabel = new JLabel("5 A Day");
        fiveADayLabel.setFont(new Font("Arial", Font.BOLD, 20));
        fiveADayLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // set layout to gridbaglayout and add components
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(exerciseLabel, c);

        c.gridy = 1;
        mainPanel.add(fiveADayLabel, c);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 5, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        int buttonStates[] = new int[buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            buttonStates[i] = 0;
            buttons[i] = new JButton("X");
            buttons[i].setPreferredSize(new Dimension(50, 50));
            buttons[i].setBackground(Color.RED);
            buttons[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                int index = -1;
                for (int j = 0; j < buttons.length; j++) {
                    if (button == buttons[j]) {
                        index = j;
                        break;
                    }
                }
                if (index != -1) {
                    if (buttonStates[index] == 0) {
                        button.setBackground(Color.GREEN);
                        button.setText("\u2713");
                        buttonStates[index] = 1;
                        // for (int j = 0; j < buttonStates.length; j++) {
                        // System.out.print(buttonStates[j]);
                        // }
                        // System.out.println();
                    } else {
                        button.setBackground(Color.RED);
                        button.setText("X");
                        buttonStates[index] = 0;
                        // for (int j = 0; j < buttonStates.length; j++) {
                        // System.out.print(buttonStates[j]);
                        // }
                        // System.out.println();
                    }
                }
            });
            buttonsPanel.add(buttons[i]);
        }

        c.gridy = 2;
        mainPanel.add(buttonsPanel, c);
        JLabel addFood = new JLabel("Add Food");
        addFood.setFont(new Font("Arial", Font.BOLD, 20));
        addFood.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        c.gridy = 3;
        mainPanel.add(addFood, c);

        this.add(mainPanel, BorderLayout.CENTER);

        // If back button is clicked, loginPanel will be displayed
        backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));

        JLabel foodNameLabel = new JLabel("Food Name:");
        JTextField foodNameField = new JTextField(20);

        JLabel caloriesLabel = new JLabel("Calories:");
        JTextField caloriesField = new JTextField(5);

        JLabel dateLabel = new JLabel("Date:");

        JButton submitButton = new JButton("Submit");

        JButton foodHistoryButton = new JButton("Food History");

        // add components to the mainPanel using GridBagConstraints

        c.gridy = 4;
        mainPanel.add(foodNameLabel, c);

        c.gridx = 1;
        mainPanel.add(foodNameField, c);

        c.gridx = 0;
        c.gridy = 5;
        mainPanel.add(caloriesLabel, c);

        c.gridx = 1;
        mainPanel.add(caloriesField, c);

        c.gridx = 0;
        c.gridy = 6;
        mainPanel.add(dateLabel, c);

        c.gridx = 1;
        JDateChooser datePicker = new JDateChooser();
        mainPanel.add(datePicker, c);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        mainPanel.add(submitButton, c);

        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        mainPanel.add(foodHistoryButton, c);

        // JLabel foodHistory = new JLabel("History");
        // foodHistory.setFont(new Font("Arial", Font.BOLD, 20));
        // foodHistory.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        // c.gridy = 8;
        // mainPanel.add(foodHistory, c);

        datePicker.addPropertyChangeListener(e -> {
            // check not null
            if (datePicker.getDate() != null) {
                if (datePicker.getDate().after(new java.util.Date())) {
                    datePicker.setDate(new java.util.Date());
                }
            }
        });
    }

}
