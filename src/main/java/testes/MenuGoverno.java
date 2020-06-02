package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import setup.Driver;
import setup.InicializadoresFinalizadores;
import setup.Teste;

public class MenuGoverno extends Teste  implements InicializadoresFinalizadores {

    WebDriver driver;

    @Before
    public void criarDriver(){
        Driver driverDriver = new Driver();
        driver = driverDriver.criarDriver();
    }

    @Test
    public void testeMenuGoverno(){
        HomePage homePage = new HomePage(driver);

    }

    @After
    public void fecharDrives(){
        driver.close();
        driver.quit();
    }
}
