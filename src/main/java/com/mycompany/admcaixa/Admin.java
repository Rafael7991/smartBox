package com.mycompany.admcaixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    public void cadastraUser(String DB) {
        try {
            Connection conexao = Conecta.obterConexao(DB);
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
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    @Override
    public void cadastraProd(String DB) {

        try {
            Connection conexao = Conecta.obterConexao(DB);
            String sql = "INSERT INTO produtos (nome, preco, tipo, estoque, unidade, cod) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, CadastraProd.fieldNome.getText());
            ps.setInt(3, CadastraProd.tipoBox.getSelectedIndex());
            if (CadastraProd.tipoBox.getSelectedIndex() == 0) {
                ps.setNull(2, java.sql.Types.FLOAT);
                ps.setNull(4, java.sql.Types.FLOAT);
            } else if (CadastraProd.tipoBox.getSelectedIndex() == 1) {
                ps.setFloat(2, Float.parseFloat(CadastraProd.fieldPreco.getText()));
                ps.setFloat(4, Float.parseFloat(CadastraProd.fieldStock.getText()));
            } else {
                if (CadastraProd.fieldPreco.getText().isEmpty()) {
                    ps.setNull(2, java.sql.Types.FLOAT);
                } else {
                    ps.setFloat(2, Float.parseFloat(CadastraProd.fieldPreco.getText()));
                }

                if (CadastraProd.fieldStock.getText().isEmpty()) {
                    ps.setNull(4, java.sql.Types.FLOAT);
                } else {
                    ps.setFloat(4, Float.parseFloat(CadastraProd.fieldStock.getText()));
                }

            }
            ps.setString(5, (String) CadastraProd.unidBox.getSelectedItem());
            ps.setString(6, CadastraProd.fieldCod.getText());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

    }

}
