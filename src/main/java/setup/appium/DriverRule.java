package setup.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverRule {
        AppiumDriver<MobileElement> getDriver(DesiredCapabilities var1);

        boolean verifyPlatform(String var1);
    }

