package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import listeners.Report;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.HomePage;



public class HomeAction extends HomePage {

    private final WebDriverWait wait;

    public HomeAction(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10L);
    }

    public HomeAction acessarMenuCredito() {
        wait.until(ExpectedConditions.elementToBeClickable(closeIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(this.ativEntendi)).click();
        wait.until(ExpectedConditions.elementToBeClickable(this.mainMenuBtn)).click();
        new Report().generateReport("Menu Credito","Selecionar menu do credito");
        return new HomeAction(this.driver);
    }
    public CreditoAction gerarFinanciamento() {
        wait.until(ExpectedConditions.elementToBeClickable(closeIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(this.ativEntendi)).click();
        wait.until(ExpectedConditions.elementToBeClickable(this.mainMenuBtn)).click();
        new Report().generateReport("Gerar Financiamento","Concluir financiamento");
        return new CreditoAction(this.driver);
    }
}
