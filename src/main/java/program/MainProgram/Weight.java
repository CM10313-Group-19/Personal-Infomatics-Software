package program.MainProgram;

import com.toedter.calendar.JDateChooser;
import program.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Weight extends Subpage{

    private JTextField weightTextField;
    private JDateChooser datePicker;

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

        //If weight textfield is clicked, text will be cleared
        weightTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                weightTextField.setText("");
            }
        });

        //Only allow numbers and a decimal point with 2 decimal places to be entered into the weight textfield
        weightTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD)))) {
                    e.consume();
                }
            }

        });

        submitButton.addActionListener(e -> {

            if(datePicker.getDate() == null){
                JOptionPane.showMessageDialog(null, "Please enter a weight and date");
            }
            else{
                JOptionPane.showMessageDialog(null, "Details Submitted.\nWeight: " + weightTextField.getText() + "kg" + "\nDate: " + datePicker.getDate());
            }
        });

        //If back button is clicked, menu will be displayed
        this.backButton.addActionListener(e -> mainPage.SwitchPanel(mainPage.menuPanel));
    }
}
