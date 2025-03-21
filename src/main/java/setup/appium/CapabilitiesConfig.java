package setup.appium;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class CapabilitiesConfig {

    public static DesiredCapabilities setCapabilities(Map<String, Object> jsonMap) {
        DesiredCapabilities capability = new DesiredCapabilities();
        jsonMap.forEach(capability::setCapability);
        return capability;
    }
}
