package program.BackendCommunication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    /**
     * Converts a JSON string to a Jackson JsonNode
     *
     * @param json The Json String to parse
     * @return The json string converted to a JsonNode
     */
    public static JsonNode parse_json(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
