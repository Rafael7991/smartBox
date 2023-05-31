package com.mycompany.admcaixa;

import java.util.*;
import java.sql.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import entities.*;
import java.util.Date;
//import java.sql.Timestamp;

public class AdmCaixa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String cod = "0";
            int estoque = 0;
            int tipo = 0;
            String nome = "";
            int qtd = 0;
            float preco = 0;
            int id = 0;

            String url = "jdbc:h2:~/smartbox"; // URL de conexão do H2
            String user = "sa"; // Nome de usuário do banco de dados
            String password = ""; // Senha do banco de dados (se aplicável)
            
            Connection conexao = DriverManager.getConnection(url, user, password);
            
            
            
            Venda venda = new Venda(new Timestamp(new Date().getTime()));

            while (true) {
                String sql1 = "SELECT * FROM users";
                PreparedStatement ps = conexao.prepareStatement(sql1);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                   
                    System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome"));

                }
                System.out.println("Digite o codigo: ");
                cod = sc.next();
                if (cod.equals("9999")) {
                    break;
                }
                String sql = "SELECT * FROM produtos where id = ?";

                //PreparedStatement ps = conexao.prepareStatement(sql);

                //ps.setString(1, cod);

                //ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    tipo = rs.getInt("tipo");
                    estoque = rs.getInt("estoque");
                    nome = rs.getString("nome");
                    id = Integer.parseInt(cod);
                    preco = rs.getFloat("preco");
                    System.out.println("ID: " + cod + ", Nome: " + nome + " Estoque " + estoque);

                }
                switch (tipo) {
                    case 1:
                        System.out.println("Digite o preço: ");
                        preco = sc.nextFloat();
                        ProdutoFrac PFrac = new ProdutoFrac(id, nome, preco);
                        venda.addItem(PFrac.valorTotal(), 1);
                        break;
                    case 2:
                        System.out.println("Digite a quantidade: ");
                        qtd = sc.nextInt();
                        ProdutoInt PInt = new ProdutoInt(id, nome, qtd, preco);
                        venda.addItem(PInt.valorTotal(), qtd);
                        break;
                    default:
                        System.out.println("Valor invalido");
                        break;
                }
                
                venda.setTotal(venda.getTotalParcial());
                sql = "INSERT INTO vendas (dataHora, idprodutos, quantidade, total) VALUES (?, ?, ?, ?)";
                ps = conexao.prepareStatement(sql);               
                ps.setTimestamp(1, venda.getDataHoraAtual());
                ps.setInt(2, id);
                if (tipo == 1) {
                    ps.setFloat(4, preco);
                    ps.setInt(3, 0);
                } else if (tipo == 2) {
                    ps.setFloat(4, qtd * preco);
                    ps.setInt(3, qtd);
                }
                
                                
                int linhasAfetadas = ps.executeUpdate();
                
                if (linhasAfetadas > 0) {
                    System.out.println("Inserção realizada com sucesso.");
                } else {
                    System.out.println("Não foi possível realizar a inserção.");
                }
            }
            System.out.println("Total: " + venda.getTotal());
            System.out.println("Metodo de pagamento? 0 = Dinheiro, 1 = Cartão");
                int metodo = sc.nextInt();
                
                switch(metodo){
                    case 0:
                        System.out.println("Valor que o cliente deu:");
                        float entrada = sc.nextFloat();
                        PagaDinheiro pagamentoCash = new PagaDinheiro(entrada, venda.getTotal());
                        
                        System.out.println("Troco: R$" + pagamentoCash.calculaTroco());
                        break;
                    case 1:
                        PagaCartao pagamentoCard = new PagaCartao(venda.getTotal());
                        System.out.println("Troco: R$" + pagamentoCard.calculaTroco());
                        break;
                }
            
        }  catch (SQLException e) {
             e.printStackTrace();
        }
    }
}
