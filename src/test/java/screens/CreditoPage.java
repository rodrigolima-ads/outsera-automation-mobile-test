package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditoPage extends BasePage {
    public CreditoPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10L);
    }

    // Acessa Crédito
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(accessibility = "Crédito")
    public MobileElement credito;
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nova simulação']")
    public MobileElement novaSimuacao;

    // Financiamento de Veículos
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Financiamento de veículos leves']")
    public MobileElement financiamentoDeVeiculo;
    @iOSXCUITFindBy(accessibility = "Crédito")
    @AndroidFindBy(id = "vab_button")
    public MobileElement nextButton;
    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "ok_button")
    public MobileElement btnOk;
    @iOSXCUITFindBy(accessibility = "Carro")
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Carro']")
    public MobileElement tipoveiculoCarro;
    @iOSXCUITFindBy(accessibility = "Novo (0 Km)")
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Novo (0 Km)']")
    public MobileElement modeloZeroKm;
    @iOSXCUITFindBy(accessibility = "Estado onde será emplacado")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingPreview_StatesTis")
    public MobileElement estadoEmplacado;
    @iOSXCUITFindBy(accessibility = "Paraná (PR)")
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Paraná (PR)']")
    public MobileElement estadoPR;
    @iOSXCUITFindBy(accessibility = "Preço de compra")
    @AndroidFindBy( id = "br.com.app.app.internal:id/carfinancing_vehicle_data_buy_value_edit_text")
    public MobileElement precoCompra;
    @iOSXCUITFindBy(accessibility = "Avançar")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingPreSimulation_btNext")
    public MobileElement avancaDados;
    @iOSXCUITFindBy(accessibility = "Buscar marca")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingFindVehicleModel_tietBrand")
    public MobileElement marcaCarro;
    @iOSXCUITFindBy(accessibility = "Buscar marca")
    @AndroidFindBy( id = "br.com.app.app.internal:id/auto_complete_text_selection_brand")
    public MobileElement carroInsere;
    @iOSXCUITFindBy(accessibility = "Buscar modelo e versão")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingFindVehicleModel_btNext")
    public MobileElement avancaModelo;
    @iOSXCUITFindBy(accessibility = "Avançar")
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingCheckoutSimulation_btNext")
    public MobileElement avancaSimulacao;
    @AndroidFindBy( id = "br.com.app.app.internal:id/autocomplete_item_text")
    public MobileElement carroClique;
    @AndroidFindBy( id = "br.com.app.app.internal:id/aCarFinancingFindVehicleModel_tietModelYear")
    public MobileElement modeloCarro;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Conheça o seguro tranquilidade financeira']")
    public MobileElement successMessage;

}
