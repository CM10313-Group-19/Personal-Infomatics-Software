package program.BackendCommunication;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

import static program.BackendCommunication.Json.parse_json;
import static program.BackendCommunication.Requests.post_request;

public class Weight {

    public static Boolean record_weight(String user_id, String day_measured, String value) {
        // Create the form data
        Dictionary<String, String> weight_data = new Hashtable<String, String>();
        weight_data.put("user_id", user_id);
        weight_data.put("day_measured", day_measured);
        weight_data.put("value", value);

        try {
            // Attempt the post request
            var response = post_request("/weight", weight_data);

            // Check it returned successfully
            if (response.isSuccessful()) {
                // Parse to json
                var json = parse_json(Objects.requireNonNull(response.body()).string());

                // Return the value of the `success field`, there is also a `message` field which gives error messages
                assert json != null;
                return json.get("success").asBoolean();
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
