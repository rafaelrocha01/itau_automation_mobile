# language: pt
Funcionalidade: login do aplicativo 

  Cenario: validar login com sucesso
    Dado que eu possuo um usuario cadastrado
    Quando eu abrir o aplicativo
    E eu informar usuario "44966917875" e senha "141629" cadastrados
    E eu clicar em entrar
    Entao eu devo ver a tela de boas vindas

  Cenario: validar login com dados invalidos
    Quando eu abrir o aplicativo
    E eu informar um usuario invalido "44966917876" e uma senha invalida "141628"
    E eu clicar em entrar
    Entao eu devo ver uma mensagem de aviso, de dados invalidos

  Cenario: validar numero minimo de caracteres no campo senha
    Quando eu abrir o aplicativo
    E eu informar um usuario "44966917876" e uma senha menor que seis caracteres "14162"
    E eu clicar em entrar
    Entao eu devo ver uma mensagem de aviso, que campo precisa de no minimo seis caracteres