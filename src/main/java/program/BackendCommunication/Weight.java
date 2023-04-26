package program.BackendCommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import program.NonGUIElements.DataSet;

import java.util.*;

import static program.BackendCommunication.Requests.get_request;
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

            return response.isSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    public static DataSet.DataPoint get_weight(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/weight", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                DataSet.DataPoint weight = mapper.readValue(response.body().string(), DataSet.DataPoint.class);
                System.out.println("weight_id " + weight.getDataID());
                System.out.println("date_taken " + weight.getDate());
                System.out.println("value " + weight.getValue());

                return weight;
            } else return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // DOES NOT WORK AT THE MOMENT
    /*
    public static DataSet get_weights(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/weights", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                DataSet weights = mapper.readValue(response.body().string(), DataSet.class);

                JsonNode weightJson = Json.parse_json(response.body().string());

                assert weightJson != null;
                for (JsonNode node: weightJson) {
                    if (!node.isNull()) {
                        System.out.println(node);
                        weights.getDataPoints().add(mapper.readValue(node.asText(), DataSet.DataPoint.class));
                    } else break;
                }

                for (DataSet.DataPoint w: weights.getDataPoints()) {
                    System.out.println("weight_id " + w.getDataID());
                    System.out.println("date_taken " + w.getDate());
                    System.out.println("value " + w.getValue());
                }

                return weights;
            } else return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     */
}
