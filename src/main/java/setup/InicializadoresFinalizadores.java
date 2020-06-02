package setup;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public interface InicializadoresFinalizadores {

    @Before
    public void criarDriver();

    @After
    public void fecharDrives();

}
