package br.com.alura.leilao.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageObject {

    protected final WebDriver browser;

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    protected PageObject(String urlInicial) {
        this.browser = new ChromeDriver();
        navegarPara(urlInicial);
    }

    protected PageObject(WebDriver browser) {
        this.browser = browser;
    }

    public String urlAtual() {
        return browser.getCurrentUrl();
    }

    public boolean isUrlAtualIgual(String url) {
        return urlAtual().equalsIgnoreCase(url);
    }

    public boolean paginaContemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public void navegarPara(String url) {
        browser.navigate().to(url);
    }
    
    public void fechar() {
        browser.quit();
    }
}
