package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import setup.appium.AppiumDriverResolver;
import setup.appium.CapabilitiesConfig;

import java.io.File;
import java.util.Map;

public class JSONCapabilitiesProvider {
    private final File jsonPath;
    Map<String, Object> capabilitiesMap;

    public JSONCapabilitiesProvider(File jsonPath) {
        this.jsonPath = jsonPath;
    }
    public AppiumDriver<MobileElement> returnSessionConfiguration() {
        this.capabilitiesMap = JSONUtils.fromJSONToMap(this.jsonPath);
        DesiredCapabilities capability = (new CapabilitiesConfig()).setCapabilities(this.capabilitiesMap);
        return (new AppiumDriverResolver()).getSessionDriver(capability);
    }

}
