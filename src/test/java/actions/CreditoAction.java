package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import listeners.Report;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.CreditoPage;


public class CreditoAction extends CreditoPage {

    private final WebDriverWait wait;

    public CreditoAction(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10L);
    }

    public CreditoAction acessaCredito(){
        wait.until(ExpectedConditions.elementToBeClickable(credito)).click();
        wait.until(ExpectedConditions.elementToBeClickable(novaSimuacao)).click();
        return this;
    }

    public CreditoAction preencherFormulario(){
        // Financiamento de veículos
        wait.until(ExpectedConditions.elementToBeClickable(financiamentoDeVeiculo)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tipoveiculoCarro)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(modeloZeroKm)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(estadoEmplacado)).click();
        wait.until(ExpectedConditions.elementToBeClickable(estadoPR)).click();
        wait.until(ExpectedConditions.elementToBeClickable(precoCompra)).sendKeys("4000000");
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(avancaDados));
        wait.until(ExpectedConditions.visibilityOfAllElements(avancaDados));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(marcaCarro)).click();
        wait.until(ExpectedConditions.elementToBeClickable(carroInsere)).sendKeys("Ford");
        wait.until(ExpectedConditions.elementToBeClickable(carroClique)).click();
        wait.until(ExpectedConditions.elementToBeClickable(modeloCarro)).click();
        wait.until(ExpectedConditions.elementToBeClickable(carroInsere)).sendKeys("Ka 1.0 S TiVCT Flex 5p");
        wait.until(ExpectedConditions.elementToBeClickable(carroClique)).click();
        wait.until(ExpectedConditions.elementToBeClickable(avancaModelo)).click();
        new Report().generateReport("Formulario","Realizar preenchimento do formulario");
        wait.until(ExpectedConditions.elementToBeClickable(avancaSimulacao)).click();
        return this;
    }

    public void gerarFinancVeiculos(){
        wait.until(ExpectedConditions.elementToBeClickable(btnOk)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        new Report().generateReport("Gerar Financiamento","Concluir financiamento");
    }

    public Boolean shouldElement(String expectedMensagem) {
        scrollToText(expectedMensagem);
        new Report().generateReport("Sucesso","Validar mensagem de sucesso ao finalizar");
        return successMessage.getText().contains(expectedMensagem);


    }

}
