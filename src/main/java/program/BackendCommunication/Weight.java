package program.BackendCommunication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import program.DataTypes.WeightData;

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

    public static WeightData get_weight(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/weight", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();

                WeightData weight = mapper.readValue(response.body().string(), WeightData.class);
                System.out.println("weight_id " + weight.weight_id);
                System.out.println("date_taken " + weight.day_measured);
                System.out.println("value " + weight.value);

                return weight;
            } else return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // DOES NOT WORK AT THE MOMENT
    /*
    public static WeightData[] get_weights(String user_id) {
        Dictionary<String, String> params = new Hashtable<>();
        params.put("id", user_id);

        try {
            var response = get_request("/weights", params);

            if (response.isSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                ArrayList<WeightData> weights = new ArrayList<WeightData>();

                JsonNode weightJson = Json.parse_json(response.body().string());

                assert weightJson != null;
                for (JsonNode node: weightJson) {
                    if (!node.isNull()) {
                        System.out.println(node);
                        weights.add(mapper.readValue(node.asText(), WeightData.class));
                    } else break;
                }

                for (WeightData w: weights
                     ) {
                    System.out.println("weight_id " + w.weight_id);
                    System.out.println("date_taken " + w.day_measured);
                    System.out.println("value " + w.value);
                }

                return weights.toArray(new WeightData[]{});
            } else return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     */
}
