package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import setup.appium.AppiumSessionFactory;

import java.io.File;


public class Setup {
    public AppiumDriver<MobileElement> driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("sessionJson")
    public void deveriaInicializarASessaoAndroid(@Optional("default") String sessionJson, ITestContext context) {

        driver = new AppiumSessionFactory(new File(sessionJson)).getSession();
        context.setAttribute("AppiumDriver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void finalizaSessao() {
        driver.quit();
    }

}
