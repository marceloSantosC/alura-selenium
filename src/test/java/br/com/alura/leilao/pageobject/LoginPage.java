package br.com.alura.leilao.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    public static final String URL_LOGIN = "http://localhost:8080/login";
    public static final String URL_ERRO_LOGIN = URL_LOGIN + "?error";
    public static final String USERNAME_PADRAO = "fulano";
    public static final String SENHA_PADRAO = "pass";


    public LoginPage() {
        super(URL_LOGIN);
    }

    public boolean isNavegadorNaPaginaDeLogin() {
        return isUrlAtualIgual(URL_LOGIN);
    }

    public boolean isNavegadorNaPaginaDeErroDeLogin() {
        return isUrlAtualIgual(URL_ERRO_LOGIN);
    }

    public void navegarParaPaginaDeLeiloes() {
        navegarPara("http://localhost:8080/leiloes/2");
    }

    public LeiloesPage efetuarLogin(String username, String senha) {
        browser.findElement(By.id(("username"))).sendKeys(username);
        browser.findElement(By.id(("password"))).sendKeys(senha);
        browser.findElement(By.id("submit-login")).click();
        return new LeiloesPage(browser);
    }

    public LeiloesPage efetuarLoginComUsuarioSenhaPdarao() {
        return this.efetuarLogin(USERNAME_PADRAO, SENHA_PADRAO);
    }

    public String obterNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

}
