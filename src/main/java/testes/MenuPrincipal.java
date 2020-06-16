package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import setup.Driver;
import setup.InicializadoresFinalizadores;
import static org.junit.Assert.*;

public class MenuPrincipal implements InicializadoresFinalizadores {

    WebDriver driver;

    @Before
    public void criandoDriver(){
        Driver driver = new Driver();
        this.driver = driver.criarDriver();
    }

    @Test
    public void TesteBarraBusca(){
        HomePage homePage = new HomePage(driver);
        assertNotEquals(homePage.verificaBarraDeBusca(),"UFSM – Universidade Federal de Santa Maria");
        assertFalse(homePage.estaPaginaHome(driver));
    }


    @After
    public void fechandoDrives(){
        driver.close();
        driver.quit();
    }
}
