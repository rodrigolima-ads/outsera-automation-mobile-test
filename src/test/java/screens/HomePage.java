package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(AppiumDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(id = "br.com.app.internal:id/aHome_lTabMenu")
    public AppiumBy menuPrincipal;
    @AndroidFindBy(id = "navbar_end_icon")
    public AppiumBy closeIcon;
    @AndroidFindBy(id = "br.com.app.internal:id/navbar_end_icon")
    @iOSXCUITFindBy(accessibility = "Fechar")
    public AppiumBy fechar;
    @AndroidFindBy(id = "br.com.app.internal:id/aDSFeedback_bPrimary")
    @iOSXCUITFindBy(accessibility = "Entendi")
    public AppiumBy ativEntendi;
    @AndroidFindBy(id = "fHomeDashboard_blMenuShortcut")
    @iOSXCUITFindBy(accessibility = " Menu")
    public AppiumBy mainMenuBtn;
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Crédito']")
    public AppiumBy menuCredits;


}
