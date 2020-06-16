package pageObjects;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.Teste;

import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class HomePage extends Teste {
    WebDriver driver;

    @FindBy(how = How.CSS, using = ".pic-gov")
    private WebElement buttonHomeGov;
    //ja fiz

    @FindBy(how = How.CSS, using = ".list-item>a")
    private List<WebElement> buttonsGov;
    //ja fiz

    @FindBy(how = How.CSS, using = ".site-title.m-0.notranslate.titulo-normal")
    private WebElement buttonLogoHome;
    //ja fiz

    @FindBy(how = How.CSS, using = "#amenu")
    private WebElement buttonMenu;

    @FindBy(how = How.CSS, using = "#abusca")
    private WebElement caixaDeBusca;



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
        Collator collator = Collator.getInstance(new Locale("pt","BR"));
        for (int i = 0; i < buttonsGov.size() ; i++) {
            if (!buttonsGov.get(i).isDisplayed()) {
                return false;
            }
            if (collator.equals(buttonsGov.get(i).getText(),"ÓRGÃOS DO GOVERNO")){
                buttonsGov.get(i).click();
                List<WebElement> botoesOrgaosDoGoverno = driver.findElements(By.cssSelector(".orgao-barra>a"));
                esperaXSegundos(3);
                for(int j = 0; j < botoesOrgaosDoGoverno.size(); j++) {
                    if (!botoesOrgaosDoGoverno.get(j).isDisplayed()) {
                        return false;
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
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

    public boolean verificaMenuPrincipal(){
        return false;
    }

    public String verificaBarraDeBusca(){

        caixaDeBusca.click();
        caixaDeBusca.sendKeys("Ciência da Computação");
        caixaDeBusca.submit();
        esperaXSegundos(4);
        return driver.getTitle();



    }
    public boolean estaPaginaHome(WebDriver driver){
        esperaXSegundos(5);
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle().equals("UFSM – Universidade Federal de Santa Maria"));
        System.out.println(" ");
        return driver.getTitle().equals("UFSM – Universidade Federal de Santa Maria");
    }

    private boolean botaoExiste(WebElement elemento){
        return elemento.isDisplayed();
    }




}
