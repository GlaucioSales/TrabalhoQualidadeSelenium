package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import setup.Driver;
import setup.InicializadoresFinalizadores;

public class MenuPrincipal implements InicializadoresFinalizadores {
    WebDriver driver;

    @Before
    public void criandoDriver(){
        Driver driver = new Driver();
        this.driver = driver.criarDriver();
    }

    @Test
    public void testaMenuPrincipal(){

    }


    @After
    public void fechandoDrives(){
        driver.close();
        driver.quit();
    }

}
