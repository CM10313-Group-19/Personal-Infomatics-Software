package program.MainProgram;

import program.MainFrame;
import program.Start.StartPage;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public Menu(MainPage mainPage, MainFrame mainFrame){

        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 100, 100, 100)));
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        //set layout to gridbaglayout
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        //add button to take you to the exercise page, food page and sleep page
        JButton exerciseButton = new JButton("Exercise");
        exerciseButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.exercisePanel));
        mainPanel.add(exerciseButton, c);

        JButton foodButton = new JButton("Food");
        foodButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.foodPanel));
        mainPanel.add(foodButton, c);

        JButton sleepButton = new JButton("Sleep");
        sleepButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.sleepPanel));
        mainPanel.add(sleepButton, c);
        this.add(mainPanel, BorderLayout.CENTER);

        c.gridx = 1;
        c.gridy = 1;
        JButton weightButton = new JButton("Weight tracker");
        weightButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.weightPanel));
        mainPanel.add(weightButton, c);

        c.gridy = 2;
        JButton goalsButton = new JButton("Goals");
        goalsButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.goalsPanel));
        mainPanel.add(goalsButton, c);

        //insert an empty row
        c.gridy = 3;
        mainPanel.add(new JLabel(), c);

        c.gridx = 1;
        c.gridy = 4;
        JButton logOutButton = new JButton("Log out");
        logOutButton.addActionListener(e -> mainFrame.SwitchPanel(mainFrame.startPage));
        mainPanel.add(logOutButton, c);
        this.add(mainPanel, BorderLayout.CENTER);

    }
}

