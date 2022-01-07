package br.com.alura.leilao;

import br.com.alura.leilao.pageobject.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        loginPage.fechar();
    }

    @Test
    void deveEfetuarLoginComDadosValidos() {
        loginPage.efetuarLoginComUsuarioSenhaPdarao();
        assertNotEquals(LoginPage.URL_LOGIN, loginPage.urlAtual());
        assertEquals("fulano", loginPage.obterNomeUsuarioLogado());
    }

    @Test
    void naoDeveEfetuarLoginComDadosInvalidos() {
        loginPage.efetuarLogin(" ", " ");
        assertTrue(loginPage.isNavegadorNaPaginaDeErroDeLogin());
        assertTrue(loginPage.paginaContemTexto("Usuário e senha inválidos."));
    }

    @Test
    void naoDeveAbrirPaginaComAcessoRestritosSemEstarLogado() {
        loginPage.navegarParaPaginaDeLeiloes();
        assertTrue(loginPage.isNavegadorNaPaginaDeLogin());
        assertFalse(loginPage.paginaContemTexto("Dados do leilão."));
    }

}
