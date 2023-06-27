package com.mycompany.admcaixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conecta {

    public static Connection obterConexao(String nomeBanco) throws SQLException {
        // Configurações de conexão com o banco de dados
        String url = "jdbc:h2:~/" + nomeBanco;
        String usuario = "sa";
        String senha = "";

        // Estabelece a conexão com o banco de dados
        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        return conexao;
    }

}
