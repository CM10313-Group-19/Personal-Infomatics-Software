package program.Start;
import program.BackendCommunication.WeightBackend;
import program.MainFrame;
import program.MainGUIPanel;
import program.BackendCommunication.LoginBackend;
import program.NonGUIElements.Validation;

import java.io.IOException;
import java.util.Date;

/**
 * StartPage is the class that is instantiated to allow the user to login, or to create a new account. It contains the GUI elements for logging in and signing up,
 * and should contain the logic elements for validating login and creating a new account.
 */

public class StartPage extends MainGUIPanel {
    public LoginPanel loginPanel;
    public SignupPanel1 signupPanel1;
    public SignupPanel2 signupPanel2;
    public String user_id;

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
    protected boolean login(String email, String password) {
        var user_id = LoginBackend.login_user(email, password);

        if(user_id != -1) {
            this.user_id = String.valueOf(user_id);
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
    protected String validateEmailAndPassword(String email, String password, String confirmPassword) throws IOException {
        if (!checkEmailIsValidFormat(email)) return "invalid email";
        else if (checkEmailInUse(email)) return "email in use";
        else if (!password.equals(confirmPassword)) return "passwords do not match";
        else if (!checkPasswordSecureEnough(password)) return "invalid password";
        else if (email.equals("") || password.equals("") || confirmPassword.equals("")) return "empty fields";
            return "success";
        }

    /**
     * Checks if the email is already in use
     * @param email is the email entered by a new user to create an account
     * @return a boolean value indicating if the email is already in use
     */
    private boolean checkEmailInUse(String email) throws IOException {
        //Implement method to check if the email is already in use
        return LoginBackend.check_email_in_use(email);
    }

    public String getUserID() {
        return user_id;
    }

    /**
     * Checks if the email is in a valid format
     * @param email is the email entered by a new user to create an account
     * @return a boolean value indicating if the email is in a valid format
     */

    public static boolean checkEmailIsValidFormat(String email) {
        int counter = 0;
        for(int i = 0; i < email.length(); i++){
            if (email.charAt(i)=='@'){
                counter++;
            }
        }
        if(counter != 1){
            return false;
        }
        // Split the string into the local part and the domain.
        String[] split_email = email.split("@");
        // Check if local part is of the valid length
        if (split_email[0].length() <= 1  || split_email[0].length() >= 64){
            return false;
        }
        // Check if local part contains consecutive periods
        String prohibitedChars = "\"(),:;<>@[\\]";
        for (int i = 0; i < split_email[0].length()-1; i++) {
            if (split_email[0].contains(Character.toString(prohibitedChars.charAt(i)))){
                return false;
            }
            if ( i >= 1 && split_email[0].charAt(i)=='.' && split_email[0].charAt(i)==(split_email[0].charAt(i-1))) {
                return false;
            }
        }
        //Check if domain is of valid format
        int dot_counter = 0;
        for(int i = 0; i < split_email[1].length(); i++){
            if (split_email[1].charAt(i)=='.'){
                dot_counter++;
            }
        }
        if(dot_counter == 0){
            return false;
        }
        if (split_email[1].length() <= 1  || split_email[1].length() >= 255){
            return false;
        }
        return split_email[1].matches("[a-zA-Z0-9\\.]+");
    }

    /**
     * Checks if the password is secure enough
     *
     * @param password is the password entered by a new user to create an account
     * @return a string value indicating if the password is not secure enough
     */
    public static boolean checkPasswordSecureEnough(String password) {
        //Implement method to check the password meets certain conditions to make sure it is strong enough
        String special_characters = "~!@#$%^*–_=+[{]}/;:,.?";
        boolean special_character_present = false;
        //Check if password is long enough
        if (password.length() < 8) {
            return false;
        }
        for (int i = 0; i < special_characters.length(); i++) {
            if (password.contains(Character.toString(special_characters.charAt(i)))) {
                special_character_present = true;
                break;
            }
        }
        //Check if password contains special character
        if (!special_character_present) {
            return false;
        }
        //Check if password contains at least one lower and upper case character
        return password.matches("^(?=.*[a-z])(?=.*[A-Z]).*$");
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

    protected void createAccount(String email, String password, String name, Date dateOfBirth, double weight){
        if (LoginBackend.signup_user(email, password, Validation.dateToyyyymmddDash(dateOfBirth))){
            user_id= String.valueOf(LoginBackend.login_user(email, password));
            WeightBackend.record_weight(user_id, Validation.dateToyyyymmddDash(new Date()), String.valueOf(weight));
        }
    }
}

