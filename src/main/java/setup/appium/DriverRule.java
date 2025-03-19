package setup.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverRule {
        AppiumDriver getDriver(DesiredCapabilities var1);

        boolean verifyPlatform(String var1);
    }

