package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.PaginaDeBusca;
import setup.Driver;
import setup.InicializadoresFinalizadores;
import static org.junit.Assert.*;

public class BarraDeBusca implements InicializadoresFinalizadores {

    WebDriver driver;

    @Before
    public void criandoDriver(){
        Driver driver = new Driver();
        this.driver = driver.criarDriver();
    }

    @Test
    public void TesteBarraBusca(){
        String minhaBusca = "Ciência da Computação";
        String tituloPaginaUFSM = "UFSM – Universidade Federal de Santa Maria";
        HomePage homePage = new HomePage(driver);
        assertNotEquals(homePage.utilizadorDaBarraDeBusca(minhaBusca),tituloPaginaUFSM);
        assertFalse(homePage.estaPaginaHome(driver));
        PaginaDeBusca paginaDeBusca = new PaginaDeBusca(driver);
        assertTrue( paginaDeBusca.nomeDoCursoBuscado(minhaBusca));
    }


    @After
    public void fechandoDrives(){
        driver.close();
        driver.quit();
    }
}
