package program.BackendCommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import program.DataTypes.FoodData;

import java.util.*;

import static program.BackendCommunication.Requests.get_request;
import static program.BackendCommunication.Requests.post_request;

public class FoodBackend {
    /**
     * Records a food record for a user
     * @param user_id The id of the user
     * @param meal_name The name of the meal
     * @param date_eaten Date the meal was eaten, in format Y-m-d
     * @param calories The number of calories in the meal
     * @return A boolean relating to if storing was successful
     */
    public static boolean record_food(String user_id, String meal_name, String date_eaten, String calories) {
        Dictionary<String, String> form_data = new Hashtable<>();
        form_data.put("user_id", user_id);
        form_data.put("meal_name", meal_name);
        form_data.put("date_eaten", date_eaten);
        form_data.put("calories", calories);

        try {
            var response = post_request("/food", form_data);
            return response.isSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets All food data for the user
     * @param user_id The id of the user
     * @return A list of FoodData
     */
    public static List<FoodData> get_food(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/food", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                return Arrays.asList(mapper.readValue(Objects.requireNonNull(response.body()).string(), FoodData[].class));
            } else return null;

        } catch (Exception e) {
            return null;
        }
    }
}
