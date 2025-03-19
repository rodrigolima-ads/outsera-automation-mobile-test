package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10L);
    }

    @AndroidFindBy(id = "br.com.app.internal:id/aHome_lTabMenu")
    public MobileElement menuPrincipal;
    @AndroidFindBy(id = "navbar_end_icon")
    public MobileElement closeIcon;
    @AndroidFindBy(id = "br.com.app.internal:id/navbar_end_icon")
    @iOSXCUITFindBy(accessibility = "Fechar")
    public MobileElement fechar;
    @AndroidFindBy(id = "br.com.app.internal:id/aDSFeedback_bPrimary")
    @iOSXCUITFindBy(accessibility = "Entendi")
    public MobileElement ativEntendi;
    @AndroidFindBy(id = "fHomeDashboard_blMenuShortcut")
    @iOSXCUITFindBy(accessibility = " Menu")
    public MobileElement mainMenuBtn;
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Crédito']")
    public MobileElement menuCredits;


}
