package com.mycompany.admcaixa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {

    public static Connection obterConexao(String nomeBanco) throws SQLException {
        String url = "jdbc:h2:~/" + nomeBanco;
        String usuario = "sa";
        String senha = "";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        return conexao;
    }

}
