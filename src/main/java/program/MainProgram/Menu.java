package program.MainProgram;

import program.MainFrame;
import program.Start.StartPage;

import javax.swing.*;
import java.awt.*;
public class Menu extends JPanel {
    public JPanel formPanel;

    public Menu(MainPage mainPage, MainFrame mainFrame){

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 100, 100, 100)));

        JLabel titleLabel = new JLabel("Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        formPanel.add(titleLabel);

        //set layout to gridbaglayout
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        //add button to take you to the exercise page, food page and sleep page
        JButton exerciseButton = new JButton("Exercise");
        exerciseButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.exercisePanel));
        formPanel.add(exerciseButton, c);

        JButton foodButton = new JButton("Food");
        foodButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.foodPanel));
        formPanel.add(foodButton, c);

        JButton sleepButton = new JButton("Sleep");
        sleepButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.sleepPanel));
        formPanel.add(sleepButton, c);
    }
}

