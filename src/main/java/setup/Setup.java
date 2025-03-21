package setup;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.appium.AppiumSessionFactory;

import java.io.File;


public class Setup {
    public AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void deveriaInicializarASessaoAndroid(ITestContext context) {

         driver = new AppiumSessionFactory().getSession(new File("src/test/resources/capabilities-android-local.json"));

        context.setAttribute("AppiumDriver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void finalizaSessao() {
        driver.quit();
    }

}
