package com.mycompany.admcaixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Admin implements iUsuario {

    private final String login;
    private final String senha;
    private final String nome;
    private final String sobrenome;
    private final int priv;

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
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
            CadastraUser.nomeField.setText("");
            CadastraUser.sobrenomeField.setText("");
            CadastraUser.loginField.setText("");
            CadastraUser.senhaField.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "o Usuário ja existe");
            CadastraUser.nomeField.setText("");
            CadastraUser.sobrenomeField.setText("");
            CadastraUser.loginField.setText("");
            CadastraUser.senhaField.setText("");
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
            String cod = CadastraProd.fieldCod.getText();
            if(!cod.equals("9")){
                ps.setString(6, CadastraProd.fieldCod.getText());
            } else {
                CadastraProd.fieldNome.setText("");
                CadastraProd.fieldStock.setText("");
                CadastraProd.fieldCod.setText("");
                CadastraProd.fieldPreco.setText("");
                JOptionPane.showMessageDialog(null, "O código escolhido (9) não pode ser utilizado");
                return;
            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
            CadastraProd.fieldNome.setText("");
            CadastraProd.fieldStock.setText("");
            CadastraProd.fieldCod.setText("");
            CadastraProd.fieldPreco.setText("");
        } catch (SQLException e) {
            CadastraProd.fieldNome.setText("");
            CadastraProd.fieldStock.setText("");
            CadastraProd.fieldCod.setText("");
            CadastraProd.fieldPreco.setText("");
            System.out.println("Ocorreu um erro: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Produto NÃO Cadastrado! Possível causa: código ja utilizado");
        }
    }

    @Override
    public void atualizaProd(String DB) {
        try {
            Connection conexao = Conecta.obterConexao(DB);
            String sql = "UPDATE produtos SET estoque = ? WHERE nome = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, Float.parseFloat(EditEstoque.jTextField2.getText()));
            ps.setString(2, EditEstoque.jLabel2.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto atualizado!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro: " + ex.getMessage());
        }
    }

    @Override
    public void deleteUser(String DB) {
        try {
            Connection conexao = Conecta.obterConexao(DB);
            String sql = "DELETE FROM users WHERE login = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, DeleteUser.jLabel4.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro: " + ex.getMessage());
        }
    }

    @Override
    public void deleteProd(String DB) {
        
        try {
            Connection conexao = Conecta.obterConexao(DB);
            String sqlTipo = "SELECT tipo FROM produtos WHERE cod = ?";
            PreparedStatement psTipo = conexao.prepareStatement(sqlTipo);
            psTipo.setString(1, EditEstoque.jLabel5.getText());
            String sql = "DELETE FROM produtos WHERE cod = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, EditEstoque.jLabel5.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "O produto selecionado possui vendas registradas");
        }
    }  
}
