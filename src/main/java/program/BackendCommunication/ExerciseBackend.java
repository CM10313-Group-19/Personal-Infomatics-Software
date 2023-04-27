package program.BackendCommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import program.DataTypes.ExerciseData;

import java.util.*;

import static program.BackendCommunication.Requests.get_request;
import static program.BackendCommunication.Requests.post_request;

public class ExerciseBackend {
    /**
     * Records new exercise
     * @param user_id The id of the user
     * @param duration The duration of the exercise, in format H:m:s
     * @param distance The Distance traveled in the exercise, float
     * @param exercise_type Type of exercise
     * @param exercise_date The date of the exercise
     * @return A boolean relating if the recording was successful
     */
    public static boolean record_exercise(String user_id, String duration, String distance, String exercise_type, String exercise_date) {
        Dictionary<String, String> form_data = new Hashtable<>();
        form_data.put("user_id", user_id);
        form_data.put("duration", duration);
        form_data.put("distance", distance);
        form_data.put("exercise_type", exercise_type);
        form_data.put("exercise_date", exercise_date);

        try {
            var response = post_request("/exercise", form_data);
            return response.isSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets all exercise data for a user
     * @param user_id The id of the user
     * @return A list of ExerciseData
     */
    public static List<ExerciseData> get_exercise(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("user_id", user_id);

        try {
            var response = get_request("/weight", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                return Arrays.asList(mapper.readValue(Objects.requireNonNull(response.body()).string(), ExerciseData[].class));
            } else return null;

        } catch (Exception e) {
            return null;
        }
    }
}
