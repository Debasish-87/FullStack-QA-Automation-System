package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class JsonUtils {

    public static Map<String, Object> readJson(String filePath) {
        try {
            return new ObjectMapper().readValue(new File(filePath), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }
}
