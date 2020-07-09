package org.br.itau.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.br.itau.core.AppiumLib;
import org.br.itau.core.BasePage;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'CPF']")
    private MobileElement editCpf;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Senha']")
    private MobileElement editSenha;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Entrar']")
    private MobileElement btnEntrar;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Boas-vindas!']")
    private List<MobileElement> txtBoasVindas;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Usuário e/ou senha inválidos']")
    private List<MobileElement> txtUsuarioInvalido;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Deve conter no mínimo 6 caracteres']")
    private List<MobileElement> txtNumeroMinimoCaracters;


    public LoginPage(AppiumDriver driver) {
        appiumLib = new AppiumLib(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preencherCpf(String cpf) {
        appiumLib.write(editCpf, cpf);
    }

    public void preencherSenha(String senha) {
        appiumLib.write(editSenha, senha);
    }

    public void clicarBotaoEntrar() {
        appiumLib.click(btnEntrar);
    }

    public boolean verificarMensagemDeBoasVindas() {
        return appiumLib.verifyExistsElement(txtBoasVindas);
    }

    public boolean verificarMensagemDeUsuarioInvalido() {
        return appiumLib.verifyExistsElement(txtUsuarioInvalido);
    }

    public boolean verificarMensagemDeNumeroMinimoDeCaractresDeSenha() {
        return appiumLib.verifyExistsElement(txtNumeroMinimoCaracters);
    }
}
