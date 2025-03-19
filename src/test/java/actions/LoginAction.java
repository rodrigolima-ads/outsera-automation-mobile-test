package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import listeners.Report;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.LoginPage;



public class LoginAction extends LoginPage {
    protected AppiumDriver<MobileElement> driver;

    public LoginAction(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public HomeAction autenticar(String associate,String senha) {
        wait.until(ExpectedConditions.elementToBeClickable(this.user)).sendKeys(associate);
        wait.until(ExpectedConditions.elementToBeClickable(this.password)).sendKeys(senha);
        new Report().generateReport("Login","Realizar login");
        wait.until(ExpectedConditions.elementToBeClickable(this.btnenter)).click();
        return new HomeAction(driver);
    }

}
