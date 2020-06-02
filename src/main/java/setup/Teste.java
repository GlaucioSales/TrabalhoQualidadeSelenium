package setup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import setup.Driver;
import setup.InicializadoresFinalizadores;

import static org.junit.Assert.assertTrue;

public class Teste{

    public void esperaXSegundos(int x){
        try {
            Thread.sleep(x * 1000);
        } catch (InterruptedException ex) {
            assertTrue(false);
        }
    }


}
