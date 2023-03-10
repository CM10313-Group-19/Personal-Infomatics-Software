package program.MainProgram;

import program.MainFrame;

import java.awt.*;

import javax.swing.*;


public class Food extends JPanel {
    private final JTextField emailTextField;
    private final JPasswordField passwordField;
    private final JCheckBox showPasswordBox;

    public Food(MainPage mainPage, MainFrame mainFrame) {

        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(100, 100, 100, 100)));
        
        JLabel titleLabel = new JLabel("Personal Infomatics System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        //set layout to gridbaglayout and add components
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        this.add(titleLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        JLabel emailLabel = new JLabel("Email");
        this.add(emailLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(200, 20));
        this.add(emailTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        JLabel passwordLabel = new JLabel("Password");
        this.add(passwordLabel, c);

        c.gridx = 0;
        c.gridy = 4;
        passwordField = new JPasswordField();
        this.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 5;
        showPasswordBox = new JCheckBox("Show Password");
        this.add(showPasswordBox, c);

        JPanel buttonPanel = new JPanel();
        // buttonPanel.setLayout(new GridLayout(1,2));
        JButton FiveADay1 = new JButton("1");
        FiveADay1.setActionCommand("done");
        FiveADay1.setPreferredSize(new Dimension(40,40));
        FiveADay1.setBackground(Color.green);
        buttonPanel.add(FiveADay1);
        JButton signUpButton = new JButton("Sign Up");
        buttonPanel.add(signUpButton);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        this.add(buttonPanel, c);
        


        //Once signup button is clicked, next stage of signup will be shown
        // signUpButton.addActionListener(e -> startPage.SwitchPanel(startPage.signupPanel1));

        //Only allow login if email and password are valid
        // loginButton.addActionListener(e -> {
        //     if (startPage.Login(emailTextField.getText(), new String(passwordField.getPassword()))) {
        //         mainFrame.SwitchPanel(mainFrame.mainPage);
        //     } else {
        //         //If email or password is invalid, show error message in a popup
        //         JOptionPane.showMessageDialog(null, "Invalid email or password");
        //     }
        // });

    }
    // public void actionPerformed(ActionEvent e){
    //     if ("done".equals(e.getActionCommand())){
    //         e.setEnabled(false);
    //     }
    // }


}
