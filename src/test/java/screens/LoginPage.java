package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "br.com.app.internal:id/user")
    @iOSXCUITFindBy(accessibility = "usuario")
    public AppiumBy user;
    @AndroidFindBy(id = "password")
    @iOSXCUITFindBy(accessibility = "senha")
    public AppiumBy password;
    @AndroidFindBy(id = "br.com.app.internal:id/navbar_end_icon")
    @iOSXCUITFindBy(accessibility = "Entrar")
    public AppiumBy btnenter;


    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
}
