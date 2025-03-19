package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "br.com.app.internal:id/user")
    @iOSXCUITFindBy(accessibility = "usuario")
    public MobileElement user;
    @AndroidFindBy(id = "password")
    @iOSXCUITFindBy(accessibility = "senha")
    public MobileElement password;
    @AndroidFindBy(id = "br.com.app.internal:id/navbar_end_icon")
    @iOSXCUITFindBy(accessibility = "Entrar")
    public MobileElement btnenter;


    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
}
