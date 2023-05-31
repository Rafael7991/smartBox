
package com.mycompany.admcaixa;

public class Admin {
    public String login;
    public String senha;
    public String nome;
    public String sobrenome;
    public int priv;
    
    public Admin(String login, String senha, String nome, String sobrenome){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.priv = 0;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getPriv() {
        return priv;
    }
    
    
}
