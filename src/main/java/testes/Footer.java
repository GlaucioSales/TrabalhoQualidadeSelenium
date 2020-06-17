package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import setup.Driver;
import setup.InicializadoresFinalizadores;
import static org.junit.Assert.*;

public class Footer implements InicializadoresFinalizadores {
    WebDriver driver;

    @Before
    public void criandoDriver() {
        Driver driver = new Driver();
        this.driver = driver.criarDriver();
    }

    @Test
    public void testeFooter(){
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.verificaFooter());
    }

    @After
    public void fechandoDrives(){
        driver.close();
        driver.quit();
    }


}
