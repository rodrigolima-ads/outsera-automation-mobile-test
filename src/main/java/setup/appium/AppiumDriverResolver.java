package setup.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

public class AppiumDriverResolver  {
    private final List<DriverRule> drivers = new ArrayList();

    public AppiumDriver<MobileElement> getSessionDriver(DesiredCapabilities capabilities) {
        String platformName = capabilities.getPlatform().toString().toLowerCase();
        return (AppiumDriver)this.drivers.stream().filter((driver) -> driver.verifyPlatform(platformName)).findFirst().map((driver) -> driver.getDriver(capabilities)).orElseThrow(() -> new WebDriverException("Platform not supported!"));
    }

}