package Start;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;

/**
 * StartPage is the class that is instantiated to allow the user to login, or to create a new account. It contains the GUI elements for logging in and signing up,
 * and should contain the logic elements for validating login and creating a new account.
 */

public class StartPage extends JPanel {
    public LoginPanel loginPanel;
    public SignupPanel1 signupPanel1;
    public SignupPanel2 signupPanel2;

    public StartPage() {

        loginPanel = new LoginPanel(this);
        signupPanel1 = new SignupPanel1(this);
        signupPanel2 = new SignupPanel2(this);
        this.setBackground(new Color(230, 126, 34));
        this.setLayout(new GridBagLayout());
        this.add(loginPanel.formPanel);
        this.setVisible(true);
    }

    /**
     * Removes the panel StartPage is currently displaying and replaces it with the JPanel passed in
     * @param formPanel
     */
    public void SwitchPanel(JPanel formPanel) {
        this.removeAll();
        this.add(formPanel);
        this.revalidate();
        this.repaint();
    }

    /**
     * Takes an email and password and validates if the user has entered valid account information to allow them to login.
     * @param email
     * @param password
     * @return A boolean value indicating successful login
     */
    public boolean Login(String email, String password) {

        //TEMPORARY CODE:
        if (email.equals("test") && password.equals("test")) {
            System.out.println("Login Successful");
            return true;
        }
        return false;
    }
}

