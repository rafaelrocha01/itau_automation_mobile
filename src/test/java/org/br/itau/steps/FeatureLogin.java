package org.br.itau.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.br.itau.core.BaseTest;
import org.br.itau.page.LoginPage;
import org.junit.Assert;


public class FeatureLogin extends BaseTest {
    public LoginPage loginPage;

    @Dado("que eu possuo um usuario cadastrado")
    public void queEuPossuoUmUsuarioCadastrado() {
    }

    @Quando("eu abrir o aplicativo")
    public void euAbrirOAplicativo() {
        loginPage = new LoginPage(startTestCase());
    }

    @E("eu informar usuario {string} e senha {string} cadastrados")
    public void euInformarUsuarioESenhaCadastrados(String usuario, String senha) {
        loginPage.preencherCpf(usuario);
        loginPage.preencherSenha(senha);
    }

    @E("eu clicar em entrar")
    public void euClicarEmEntrar() {
        loginPage.clicarBotaoEntrar();
    }

    @Entao("eu devo ver a tela de boas vindas")
    public void oAplicativoDeveraIrParaATelaDeBoasVindas() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.verificarMensagemDeBoasVindas());
        finishTestCase();
    }

    @E("eu informar um usuario invalido {string} e uma senha invalida {string}")
    public void euInformarUmUsuarioInvalidoEUmaSenhaInvalida(String usuario, String senha) {
        loginPage.preencherCpf(usuario);
        loginPage.preencherSenha(senha);
    }

    @Entao("eu devo ver uma mensagem de aviso, de dados invalidos")
    public void oAplicativoDeveraExibirUmaMensagemDeAvisoDeDadosInvalidos() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.verificarMensagemDeUsuarioInvalido());
        finishTestCase();
    }

    @E("eu informar um usuario {string} e uma senha menor que seis caracteres {string}")
    public void euInformarUmUsuarioEUmaSenhaMenorQueSeisCaracteres(String usuario, String senha) {
        loginPage.preencherCpf(usuario);
        loginPage.preencherSenha(senha);
    }

    @Entao("eu devo ver uma mensagem de aviso, que campo precisa de no minimo seis caracteres")
    public void oAplicativoDeveraExibirUmaMensagemDeAvisoQueCampoPrecisaDeNoMinimoSeisCaracteres() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.verificarMensagemDeNumeroMinimoDeCaractresDeSenha());
        finishTestCase();
    }
}
