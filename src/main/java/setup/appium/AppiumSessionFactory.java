package setup.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import static setup.appium.CapabilitiesConfig.setCapabilities;
import static utils.JSONUtils.fromJSONToMap;



public class AppiumSessionFactory {

    Map<String, Object> capabilitiesMap;

    public AppiumDriver getSession(File jsonPath) {
        capabilitiesMap = fromJSONToMap(jsonPath);

        try {
            return new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), setCapabilities(capabilitiesMap));
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}