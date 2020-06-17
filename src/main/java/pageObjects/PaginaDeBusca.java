package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.Teste;

import java.util.List;

public class PaginaDeBusca extends Teste {
    WebDriver driver;

    @FindBy(how = How.CSS, using = ".coluna-lista-site>a")
    private WebElement cursoBuscado;

    public PaginaDeBusca(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean nomeDoCursoBuscado(String termoDeBusca){

        return cursoBuscado.getText().contains(termoDeBusca);

    }



}
