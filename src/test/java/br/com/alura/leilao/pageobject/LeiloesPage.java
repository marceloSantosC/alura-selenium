package br.com.alura.leilao.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class LeiloesPage extends PageObject {

    public LeiloesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CadastroLeiloesPage abrirFormularioNovoLeilao() {
        this.browser.findElement(By.id("novo_leilao_link")).click();
        return new CadastroLeiloesPage(browser);
    }

    public boolean isLeilaoCadastrado(String nome, BigDecimal valor, String data) {
        List<WebElement> linhas = this.browser.findElements(By.cssSelector("#tabela-leiloes tbody tr"));
        Collections.reverse(linhas);

        return linhas.stream().anyMatch(linha -> {
            List<WebElement> colunas = linha.findElements(By.tagName("td"));
            return nome.equals(colunas.get(0).getText()) && valor.equals(new BigDecimal(colunas.get(2).getText()))
                    && data.equals(colunas.get(1).getText());
        });
    }
}
