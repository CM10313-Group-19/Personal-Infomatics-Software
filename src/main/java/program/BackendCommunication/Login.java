package program.BackendCommunication;

import program.NonGUIElements.Validation;

import java.io.IOException;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

import static program.BackendCommunication.Json.parse_json;
import static program.BackendCommunication.Requests.get_request;
import static program.BackendCommunication.Requests.post_request;

public class Login {
    /**
     * Checks if an email exists
     * @param email Email to check
     * @return true if email exists, false if not
     * @throws IOException exception thrown if request failed
     */
    public static Boolean check_email_in_use(String email) throws IOException {
        // Create parameters dictionary
        Dictionary<String, String> parameters = new Hashtable<String, String>();
        parameters.put("email", email);
        var response = get_request("/check_email", parameters);

        // Check if the request was successful
        if (response.isSuccessful()) {
            // Parse the response body into json
            var res = parse_json(Objects.requireNonNull(response.body()).string());
            // Get the `exists` variable from the json response
            assert res != null;
            return res.get("exists").asBoolean();
        } else {
            // If the response failed return null
            throw new IOException("Request was not successful");
        }
    }

    /**
     * Adds a new user
     * @param email         Email of the new user
     * @param password      password of the new user
     * @param date_of_birth Date of birth of the new user, in the form `Y-m-d`
     * @return Returns true or false depending on if the user was created successfully
     */
    public static int signup_user(String email, String password, String date_of_birth, String weight) {
        // Create the form data
        Dictionary<String, String> form_data = new Hashtable<String, String>();
        form_data.put("email", email);
        form_data.put("password", password);
        form_data.put("date_of_birth", date_of_birth);

        try {
            // Attempt the post request
            var response = post_request("/signup", form_data);

            // Check it returned successfully
            if (response.isSuccessful()) {
                // Parse to json
                var json = parse_json(Objects.requireNonNull(response.body()).string());

                Weight.record_weight(json.get("user_id").asText(), Validation.dateToyyyymmdd(new Date()), weight);

                // Return the value of the `success field`, there is also a `message` field which gives error messages
                assert json != null;
                return json.get("user_id").asInt();
            } else return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Logs in a user
     * @param email Email of the user
     * @param password Password of the user
     * @return If the login was successful the user_id of the user, otherwise -1
     */
    public static int login_user(String email, String password) {
        // Create parameter data
        Dictionary<String, String> parameters = new Hashtable<>();
        parameters.put("email", email);
        parameters.put("password", password);

        try {
            // Attempt Request
            var response = get_request("/login", parameters);

            // Check if request is successful
            if(response.isSuccessful()) {
                var json = parse_json(Objects.requireNonNull(response.body()).string());

                assert json != null;
                // Get the user id and return it
                return json.get("user_id").asInt();

                // If something failed return user id of -1
            } else return -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
