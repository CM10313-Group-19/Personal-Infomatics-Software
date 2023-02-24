package program.Start;
import program.MainFrame;
import program.MainGUIPanel;
import java.util.Date;


/**
 * StartPage is the class that is instantiated to allow the user to login, or to create a new account. It contains the GUI elements for logging in and signing up,
 * and should contain the logic elements for validating login and creating a new account.
 */

public class StartPage extends MainGUIPanel {
    public LoginPanel loginPanel;
    public SignupPanel1 signupPanel1;
    public SignupPanel2 signupPanel2;

    public StartPage(MainFrame mainFrame) {
        super(mainFrame);
        loginPanel = new LoginPanel(this, mainFrame);
        signupPanel1 = new SignupPanel1(this);
        signupPanel2 = new SignupPanel2(this, mainFrame);
        this.add(loginPanel);
    }

    /**
     * Takes an email and password and validates if the user has entered valid account information to allow them to login.
     * @param email is the email entered by an existing user to login
     * @param password is the password entered by an existing user
     * @return A boolean value indicating successful login
     */
    protected boolean Login(String email, String password) {

        //TEMPORARY CODE:
        if (email.equals("test") && password.equals("test")) {
            System.out.println("Login Successful");
            return true;
        }
        return false;
    }

    /**
     * Takes an email and password and validates if the user has entered valid account information to allow them to create a new account.
     * @param email is the email entered by a new user to create an account
     * @param password is the password entered by a new user to create an account
     * @param confirmPassword is the password entered by a new user to confirm their password
     * @return a string value indicating the result of the attempt to create an account. If the account was created successfully, the string "valid" is returned. If the email is already in use, the string "Email already in use" is returned. If the passwords do not match, the string "Passwords do not match" is returned. If the password is not secure enough, the string "Password not secure enough" is returned.
     */
    protected String validateEmailAndPassword(String email, String password, String confirmPassword) {
        if (!checkEmailIsValidFormat(email)) return "Email is not in a valid format";
        else if (checkEmailInUse(email)) return "Email already in use";
        else if (!password.equals(confirmPassword)) return "Passwords do not match";
        else if (!checkPasswordSecureEnough(password).equals("success")) return checkPasswordSecureEnough(password);
        else if (email.equals("") || password.equals("") || confirmPassword.equals("")) return "empty fields";
            return "success";
        }

    /**
     * Checks if the email is already in use
     * @param email is the email entered by a new user to create an account
     * @return a boolean value indicating if the email is already in use
     */
    private boolean checkEmailInUse(String email) {
        //Implement method to check if the email is already in use
        return false;
    }

    /**
     * Checks if the email is in a valid format
     * @param email is the email entered by a new user to create an account
     * @return a boolean value indicating if the email is in a valid format
     */

    private boolean checkEmailIsValidFormat(String email) {
        //Implement method to check if the email is in a valid format
        return true;
    }

    /**
     * Checks if the password is secure enough
     * @param password is the password entered by a new user to create an account
     * @return a string value indicating if the password is not secure enough
     */
    private String checkPasswordSecureEnough(String password) {
        //Implement method to check the password meets certain conditions to make sure it is strong enough

        return "success";
    }

    /**
     * Function that passes information to the database to create a new account
     * @param email is the email entered by a new user to create an account
     * @param password is the password entered by a new user to create an account
     * @param name is the name entered by a new user to create an account
     * @param dateOfBirth is the date of birth entered by a new user to create an account
     * @param weight is the weight entered by a new user to create an account
     * @return a boolean value indicating if the account was created successfully
     */
    protected void createAccount(String email, String password, String name, Date dateOfBirth, int weight){
        //store the account information in the database
        //Print account information to the console
        System.out.println("Account created and should be stored in the database");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Weight: " + weight);
    }
}

