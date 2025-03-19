package utils;


import enviroment.EnvironmentValidatorConsumer;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

public class JSONUtils {
    private JSONUtils() {
        throw new IllegalStateException("");
    }

    public static Map<String, Object> fromJSONToMap(File jsonPath) {
        JSONParser parser = new JSONParser();

        try {
            Map<String, Object> jsonMap = (Map) parser.parse(new FileReader(jsonPath));
            changeMapValueToObjectFromEnvironmentVariableString(jsonMap);
            return jsonMap;
        } catch (ParseException | IOException e) {
            throw new RuntimeException("Invalid path to Capabilities JSON or failed to parse file: " + (e).getMessage());
        }
    }


    private static void changeMapValueToObjectFromEnvironmentVariableString(Map<String, Object> jsonMap) {
        Consumer<Map.Entry<String, Object>> envVariableConsumer = new EnvironmentValidatorConsumer();
        jsonMap.entrySet().stream().filter((map) -> map.getValue().toString().contains("{") && map.getValue().toString().contains("}")).forEach(envVariableConsumer);
    }

}
