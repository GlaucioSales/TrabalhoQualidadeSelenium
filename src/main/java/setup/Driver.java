package setup;

import org.junit.After;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private WebDriver driver;

    public WebDriver criarDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Glaucio Sales Santo\\Desktop\\Glaucio\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ufsm.br/");
        assertEquals("UFSM – Universidade Federal de Santa Maria", driver.getTitle());
        return driver;
    }

}
