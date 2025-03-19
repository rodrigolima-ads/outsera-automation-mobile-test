package utils;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONUtils {

    public static Map fromJSONToMap(File jsonPath) {
        JSONParser jsonParser = new JSONParser();

        try {
            return (Map) jsonParser.parse(new FileReader(jsonPath));

        } catch (ParseException | IOException e) {

            throw new RuntimeException("Invalid path to Capabilities JSON or failed to parse file: " + (e).getMessage());
        }
    }
}
