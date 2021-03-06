package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import setup.Driver;
import setup.InicializadoresFinalizadores;

import static org.junit.Assert.*;

public class MenuGoverno implements InicializadoresFinalizadores {

    WebDriver driver;

    @Before
    public void criandoDriver(){
        Driver driver = new Driver();
        this.driver = driver.criarDriver();
    }

    @Test
    public void testeBotaoHomeMenuGoverno(){
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.verificaBotaoHomeGov());
    }
    @Test
    public void testeItensMenuGov(){
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.verificaItensDaBarraGov());
    }

    @After
        public void fechandoDrives(){
        driver.close();
        driver.quit();
    }
}
