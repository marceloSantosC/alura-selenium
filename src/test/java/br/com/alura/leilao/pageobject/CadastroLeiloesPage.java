package br.com.alura.leilao.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class CadastroLeiloesPage extends PageObject {

    protected CadastroLeiloesPage(WebDriver browser) {
        super(browser);
    }

    public LeiloesPage cadastrarLeilao(String nome, BigDecimal valorInicial, String data) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial.toString());
        this.browser.findElement(By.id("dataAbertura")).sendKeys(data);
        this.browser.findElement(By.id("button-submit")).click();
        return new LeiloesPage(browser);
    }

}
