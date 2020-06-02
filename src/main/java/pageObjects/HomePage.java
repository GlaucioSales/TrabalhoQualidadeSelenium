package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.Teste;

import java.util.List;

import static org.junit.Assert.*;

public class HomePage extends Teste {
    WebDriver driver;

    @FindBy(how = How.CSS, using = ".pic-gov")
    private WebElement buttonHomeGov;

    @FindBy(how = How.CSS, using = ".list-item>a")
    private List<WebElement> buttonsGov;

    @FindBy(how = How.CSS, using = ".site-title.m-0.notranslate.titulo-normal")
    private WebElement buttonLogoHome;

    @FindBy(how = How.CSS, using = "#amenu")
    private WebElement buttonMenu;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean verificaBotaoHomeGov(){
        if (buttonHomeGov.isDisplayed()){
            buttonHomeGov.click();
            return !driver.getTitle().equals("UFSM – Universidade Federal de Santa Maria");
        }else{
            return  false;
        }
    }
    public boolean verificaItensDaBarraGov(){
        for (int i = 0; i < buttonsGov.size() ; i++) {
            if (!buttonsGov.get(i).isDisplayed()){
                System.out.println(buttonsGov.get(i).getText());
                return false;
            }
        }
        return true;
    }

    public boolean verificaLogoBotaoHome(){
        if (buttonLogoHome.isDisplayed()){
            buttonLogoHome.click();
            if (buttonHomeGov.getText().equals("UFSM – Universidade Federal de Santa Maria")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }




}
