package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

public class HomePage {
    WebDriver driver;

    @FindBy(how = How.CSS, using = ".pic-gov")
    private WebElement buttonHomeGov;

    @FindBy(how = How.CSS, using = ".list-item>a")
    private WebElement buttonGov;

    @FindBy(how = How.CSS, using = ".site-title.m-0.notranslate.titulo-normal")
    private WebElement buttonHome;

    @FindBy(how = How.CSS, using = "#amenu")
    private WebElement buttonMenu;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickMenuGoverno(){
        assertTrue(buttonHomeGov.isDisplayed());

    }

}
