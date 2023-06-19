package com.mycompany.admcaixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admin implements iUsuario {

    public String login;
    public String senha;
    public String nome;
    public String sobrenome;
    public int priv;

    public Admin(String login, String senha, String nome, String sobrenome) {
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

    @Override
    public void cadastraUser() {
        try {
            String url = "jdbc:h2:~/smartbox";
            Connection conexao = DriverManager.getConnection(url, "sa", "");
            String sql = "INSERT INTO users (nome, sobrenome, login, senha, priv) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, CadastraUser.nomeField.getText());
            ps.setString(2, CadastraUser.sobrenomeField.getText());
            ps.setString(3, CadastraUser.loginField.getText());
            ps.setString(4, CadastraUser.senhaField.getText());
            ps.setInt(5, CadastraUser.privBox.getSelectedIndex());
            ps.execute();
            
            CadastraUser.nomeField.setText("");
            CadastraUser.sobrenomeField.setText("");
            CadastraUser.loginField.setText("");
            CadastraUser.senhaField.setText("");
                                            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
