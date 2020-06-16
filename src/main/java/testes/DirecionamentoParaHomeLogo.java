package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import setup.Driver;
import setup.InicializadoresFinalizadores;
import static org.junit.Assert.*;

public class DirecionamentoParaHomeLogo implements InicializadoresFinalizadores {
    WebDriver driver;

    @Before
    public void criandoDriver() {
        Driver driver = new Driver();
        this.driver = driver.criarDriver();
    }

    @Test
    public void testeLogoBotaoHome(){
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.verificaLogoBotaoHome());
    }

    @After
    public void fechandoDrives(){
        driver.close();
        driver.quit();
    }


}
