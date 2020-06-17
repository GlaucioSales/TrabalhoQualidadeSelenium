package pageObjects;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.Teste;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Collator;
import java.util.LinkedList;
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
    //ja fiz

    @FindBy(how = How.CSS, using = "#abusca")
    private WebElement caixaDeBusca;
    //ja fiz

    @FindBy(how = How.CSS, using = ".carousel-control-prev")
    private WebElement botaoCarrosselEsquerda;
    // ja fiz

    @FindBy(how = How.CSS, using = ".carousel-control-next")
    private WebElement botaoCarrosselDireita;
    // ja fiz

    @FindBy(how = How.CSS, using = ".w-100")
    private WebElement carrosselImagem;
    // ja fiz

    @FindBy(how = How.CSS, using = ".fas.fa-pencil-alt")
    private WebElement botaoBasicoTecnico;
    // ja fiz

    @FindBy(how = How.CSS, using = ".fas.fa-pencil-alt")
    private WebElement botaoGraduacao;
    //ja fiz

    @FindBy(how = How.CSS, using = ".fas.fa-pencil-alt")
    private WebElement botaoEspecializacao;
    //ja fiz

    @FindBy(how = How.CSS, using = ".fas.fa-pencil-alt")
    private WebElement botaoMestradoDoutorado;
    //ja fiz

    @FindBy(how = How.CSS, using = ".fas.fa-pencil-alt")
    private WebElement botaoEaD;
    //ja fiz

    @FindBy(how = How.CSS, using = "#main-footer")
    private WebElement footerCompleto;

    @FindBy(how = How.CSS, using = ".footer-widget>p")
    private List<WebElement> endereçosNoFooter;










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
        Collator collator = Collator.getInstance(new Locale("pt","BR"));

        if (buttonLogoHome.isDisplayed()){
            buttonLogoHome.click();
            if (driver.getTitle().equals("UFSM – Universidade Federal de Santa Maria")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean verificabotaoMenuPrincipal(){
        buttonMenu.click();
        esperaXSegundos(3);
        boolean estaDisponivel = driver.findElement(By.cssSelector("#menu-item-43925>a")).isDisplayed();
        buttonMenu.click();
        esperaXSegundos(3);
        return estaDisponivel;
    }

    public String utilizadorDaBarraDeBusca(String nomeDaBusca){

        caixaDeBusca.click();
        caixaDeBusca.sendKeys(nomeDaBusca);
        caixaDeBusca.submit();
        esperaXSegundos(4);
        return driver.getTitle();

    }

    public boolean estaPaginaHome(WebDriver driver){
        esperaXSegundos(5);
        return driver.getTitle().equals("UFSM – Universidade Federal de Santa Maria");
    }

    public boolean verificaFuncionamentoCarrossel(){
        if (botaoCarrosselEsquerda.isDisplayed() && botaoCarrosselDireita.isDisplayed()){
            botaoCarrosselDireita.click();
            esperaXSegundos(3);
            botaoCarrosselEsquerda.click();
            if(!carrosselImagem.isDisplayed()){
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarBotoesInterativosPaginaInicial(){

        if (!botaoExiste(botaoBasicoTecnico) && !verificaConexao(botaoBasicoTecnico.getAttribute("href"))){
            return false;
        }

        if (!botaoExiste(botaoGraduacao) && !verificaConexao(botaoGraduacao.getAttribute("href"))){
            return false;
        }

        if (!botaoExiste(botaoEspecializacao) && !verificaConexao(botaoEspecializacao.getAttribute("href"))){
            return false;
        }

        if (!botaoExiste(botaoMestradoDoutorado) && !verificaConexao(botaoMestradoDoutorado.getAttribute("href"))){
            return false;
        }

        if (!botaoExiste(botaoEaD) && !verificaConexao(botaoEaD.getAttribute("href"))){
            return false;
        }
        return true;

    }

    public boolean verificaFooter(){
        Collator collator = Collator.getInstance(new Locale("pt","BR"));



        if ( footerCompleto.isDisplayed()){

            List retornado = new LinkedList();
            List esperado = new LinkedList();
            esperado.add("Av. Roraima nº 1000\n" +
                    "Cidade Universitária\n" +
                    "Bairro Camobi\n" +
                    "Santa Maria - RS\n" +
                    "CEP: 97105-900\n" +
                    "+55 (55) 3220-8000");
            esperado.add("Linha 7 de Setembro, s/n\n" +
                    "BR 386 Km 40\n" +
                    "Frederico Westphalen - RS\n" +
                    "CEP: 98400-000\n" +
                    "+55 (55) 3744-0600");
            esperado.add("Av. Independência, nº 3751\n" +
                    "Bairro Vista Alegre\n" +
                    "Palmeira das Missões - RS\n" +
                    "CEP: 98300-000\n" +
                    "+55 (55) 3742-8800");
            esperado.add("Rod. Taufik Germano, nº 3013\n" +
                    "Bairro Passo D'Areia\n" +
                    "Cachoeira do Sul - RS\n" +
                    "CEP: 96503-205\n" +
                    "+55 (51) 3724-8400");

            for (int i = 0; i < endereçosNoFooter.size(); i++) {
                retornado.add(endereçosNoFooter.get(i).getText());
            }
            return retornado.equals(esperado);
        }
            return false;
    }


    private boolean verificaConexao(String urlString) {
        boolean isValid = false;
        try {
            URL u = new URL(urlString);
            HttpURLConnection h = (HttpURLConnection) u.openConnection();
            h.setRequestMethod("GET");
            h.connect();
            if (h.getResponseCode() != h.HTTP_NOT_FOUND) { //404 HTTP_OK
                isValid = true;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
        return isValid;
    }

    private boolean botaoExiste(WebElement elemento){
        return elemento.isDisplayed();
    }




}
