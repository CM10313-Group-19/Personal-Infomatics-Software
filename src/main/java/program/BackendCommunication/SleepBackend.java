package program.BackendCommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import program.DataTypes.SleepData;

import java.util.*;

import static program.BackendCommunication.Requests.get_request;
import static program.BackendCommunication.Requests.post_request;

public class SleepBackend {

    /**
     * Records a new sleep record
     * @param user_id The id of the user
     * @param start_time The start time of the sleep, in the format H:m:s
     * @param end_time End time of the sleep, in format H:m:s
     * @param sleep_date Date of the sleep, in format Y-m-d
     * @return A boolean relating to if the recording was successful
     */
    public static boolean record_sleep(String user_id, String start_time, String end_time, String sleep_date) {
        // Create the form data
        Dictionary<String, String> form_data = new Hashtable<String, String>();
        form_data.put("user_id", user_id);
        form_data.put("start_time", start_time);
        form_data.put("end_time", end_time);
        form_data.put("sleep_date", sleep_date);

        try {
            // Attempt the post request
            var response = post_request("/sleep", form_data);

            return response.isSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets all sleep records for the user
     * @param user_id  Id of the user
     * @return A list of sleepData
     */
    public static List<SleepData> get_sleeps(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/sleep", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                return Arrays.asList(mapper.readValue(Objects.requireNonNull(response.body()).string(), SleepData[].class));
            } else return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
