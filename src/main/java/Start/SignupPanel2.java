package Start;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class SignupPanel2 extends JPanel {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel dateOfBirthLabel;
    private JDateChooser datePicker;

    private JLabel weightLabel;
    private JTextField weightTextField;
    private JButton signUpButton;
    public JPanel formPanel;

    public SignupPanel2(StartPage startPage){

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 50, 100, 50)));

        //set layout to gridbaglayout
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        nameLabel = new JLabel("Name");
        formPanel.add(nameLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        nameTextField = new JTextField();
        formPanel.add(nameTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        dateOfBirthLabel = new JLabel("Date of Birth");
        formPanel.add(dateOfBirthLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        datePicker = new JDateChooser();
        formPanel.add(datePicker, c);

        c.gridx = 0;
        c.gridy = 4;
        weightLabel = new JLabel("Weight");
        formPanel.add(weightLabel, c);

        c.gridx = 0;
        c.gridy = 5;
        weightTextField = new JTextField();
        formPanel.add(weightTextField, c);

        c.gridx = 0;
        c.gridy = 6;
        signUpButton = new JButton("Sign Up");
        formPanel.add(signUpButton, c);

        //

    }
}
