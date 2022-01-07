package br.com.alura.leilao;

import br.com.alura.leilao.pageobject.CadastroLeiloesPage;
import br.com.alura.leilao.pageobject.LeiloesPage;
import br.com.alura.leilao.pageobject.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;
    private CadastroLeiloesPage paginaCadastro;

    @BeforeEach
    public void beforeEach() {
        LoginPage loginPage = new LoginPage();
        paginaDeLeiloes = loginPage.efetuarLoginComUsuarioSenhaPdarao();
        paginaCadastro = paginaDeLeiloes.abrirFormularioNovoLeilao();
    }

    @AfterEach
    public void afterEach() {
        paginaDeLeiloes.fechar();
    }

    @Test
    public void deveCadastrarNovoLeilao() {
        String nomeLeilao = "Leilão " + System.currentTimeMillis();
        BigDecimal valor = new BigDecimal("10.00");
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        paginaDeLeiloes = paginaCadastro.cadastrarLeilao(nomeLeilao, valor, data);

        assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nomeLeilao, valor, data));

    }

}
