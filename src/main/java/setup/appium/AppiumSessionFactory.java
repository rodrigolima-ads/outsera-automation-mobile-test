package setup.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static utils.JSONUtils.fromJSONToMap;


public class AppiumSessionFactory {

    Map<String, Object> capabilitiesMap;

    public AppiumDriver getSession(File jsonPath) {

        capabilitiesMap = fromJSONToMap(jsonPath);

        try {
   /*         UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("emulator-5554")
                    .setApp("C:\\Users\\rodrigo_socorro\\projects-sicredi\\automacao-tests\\front-end\\mobile\\outsera-automacao-mobile-test\\app-homolog.apk");

            return new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);*/

            return new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilitiesConfing());

        } catch (MalformedURLException | URISyntaxException e) {

            throw new RuntimeException(e);
        }
    }
    public DesiredCapabilities capabilitiesConfing(){
        DesiredCapabilities capability = new DesiredCapabilities();
        capabilitiesMap.forEach(capability::setCapability);
        return capability;
    }


}