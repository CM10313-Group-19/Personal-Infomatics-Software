package program.BackendCommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import program.DataTypes.WeightData;

import java.util.*;

import static program.BackendCommunication.Requests.get_request;
import static program.BackendCommunication.Requests.post_request;

public class WeightBackend {

    /**
     * Adds a new weight record for the user
     * @param user_id UserId of the user
     * @param day_measured The day the weight was measured, in the format Y-m-d
     * @param value The value the weight was measured at
     * @return A boolean relating to if the recording was successful
     */
    public static Boolean record_weight(String user_id, String day_measured, String value) {
        // Create the form data
        Dictionary<String, String> weight_data = new Hashtable<String, String>();
        weight_data.put("user_id", user_id);
        weight_data.put("day_measured", day_measured);
        weight_data.put("value", value);

        try {
            // Attempt the post request
            var response = post_request("/weight", weight_data);

            return response.isSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the most recent recorded weight
     * @param user_id The id of the user
     * @return The most recent recorded weight
     */
    public static WeightData get_weight(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/weight", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(Objects.requireNonNull(response.body()).string(), WeightData.class);
            } else return null;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets all weight readings for a user
     * @param user_id The id of the user
     * @return An array of weight data
     */
    public static List<WeightData> get_weights(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/weights", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                return Arrays.asList(mapper.readValue(Objects.requireNonNull(response.body()).string(), WeightData[].class));
            } else return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
