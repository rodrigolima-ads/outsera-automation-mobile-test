package setup.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class AppiumDriverResolver  {
    private final List<DriverRule> drivers = new ArrayList();

    public AppiumDriver getSessionDriver(DesiredCapabilities capabilities) throws URISyntaxException, MalformedURLException {

        return new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);

    }

}