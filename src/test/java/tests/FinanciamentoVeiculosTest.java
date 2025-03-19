package tests;


import actions.CreditoAction;
import actions.LoginAction;
import listeners.MobileListenerAdapter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.Setup;
@Listeners(MobileListenerAdapter.class)
public class FinanciamentoVeiculosTest extends Setup {

    @Test(groups = {"financiamento"})
    @Parameters(value = "sessionJson")
    public void gerarFinanciamentoComSucesso() {

        new LoginAction(driver)
                .autenticar("usuario123","Minhasenha123")
                .acessarMenuCredito()
                .gerarFinanciamento()
                .acessaCredito()
                .preencherFormulario()
                .gerarFinancVeiculos();

        Assert.assertTrue(new CreditoAction(driver).shouldElement(""));


    }
}
