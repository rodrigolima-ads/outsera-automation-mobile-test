package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CreditoPage extends BasePage {
    public CreditoPage(AppiumDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Acessa Crédito
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(accessibility = "Crédito")
    public AppiumBy credito;
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nova simulação']")
    public AppiumBy novaSimuacao;

    // Financiamento de Veículos
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Financiamento de veículos leves']")
    public AppiumBy financiamentoDeVeiculo;
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(id = "vab_button")
    public AppiumBy nextButton;
    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "ok_button")
    public AppiumBy btnOk;
    @iOSXCUITFindBy(accessibility = "Carro")
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Carro']")
    public AppiumBy tipoveiculoCarro;
    @iOSXCUITFindBy(accessibility = "Novo (0 Km)")
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Novo (0 Km)']")
    public AppiumBy modeloZeroKm;
    @iOSXCUITFindBy(accessibility = "Estado onde será emplacado")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingPreview_StatesTis")
    public AppiumBy estadoEmplacado;
    @iOSXCUITFindBy(accessibility = "Paraná (PR)")
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Paraná (PR)']")
    public AppiumBy estadoPR;
    @iOSXCUITFindBy(accessibility = "Preço de compra")
    @AndroidFindBy( id = "br.com.app.app.internal:id/carfinancing_vehicle_data_buy_value_edit_text")
    public AppiumBy precoCompra;
    @iOSXCUITFindBy(accessibility = "Avançar")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingPreSimulation_btNext")
    public WebElement avancaDados;
    @iOSXCUITFindBy(accessibility = "Buscar marca")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingFindVehicleModel_tietBrand")
    public AppiumBy marcaCarro;
    @iOSXCUITFindBy(accessibility = "Buscar marca")
    @AndroidFindBy( id = "br.com.app.app.internal:id/auto_complete_text_selection_brand")
    public AppiumBy carroInsere;
    @iOSXCUITFindBy(accessibility = "Buscar modelo e versão")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingFindVehicleModel_btNext")
    public AppiumBy avancaModelo;
    @iOSXCUITFindBy(accessibility = "Avançar")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingCheckoutSimulation_btNext")
    public AppiumBy avancaSimulacao;
    @AndroidFindBy( id = "br.com.app.app.internal:id/autocomplete_item_text")
    public AppiumBy carroClique;
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingFindVehicleModel_tietModelYear")
    public AppiumBy modeloCarro;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Conheça o seguro tranquilidade financeira']")
    public WebElement successMessage;

}
