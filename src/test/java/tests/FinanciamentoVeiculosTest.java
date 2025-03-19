package tests;


import actions.CreditoAction;
import actions.LoginAction;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

public class FinanciamentoVeiculosTest extends Setup {

    @Test(groups = {"financiamento"})
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
