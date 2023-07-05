package com.mycompany.admcaixa;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NovoDB extends javax.swing.JFrame {

    String nomeArquivo;
    String nomeDiretorio;

    public NovoDB() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome do Banco");

        jButton1.setText("Criar Banco");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SAIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(85, 85, 85)
                        .addComponent(jButton1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // CRIAR BANCO
        if (!nome.getText().isEmpty()) {
            nomeDiretorio = System.getProperty("user.home");
            nomeArquivo = nome.getText()+ ".mv.db";
            File diretorio = new File(nomeDiretorio);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            File arquivo = new File(diretorio, nomeArquivo);
            try {
                arquivo.createNewFile();
                System.out.println("Arquivo criado com sucesso em: " + arquivo.getAbsolutePath());
                Connection conexao = Conecta.obterConexao(nome.getText());
                String sql = "CREATE TABLE PRODUTOS (\n"
                        + "    ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,\n"
                        + "    NOME VARCHAR(255) NOT NULL,\n"
                        + "    PRECO FLOAT,\n"
                        + "    TIPO INT NOT NULL,\n"
                        + "    ESTOQUE FLOAT,\n"
                        + "    UNIDADE VARCHAR(8), \n"
                        + "    COD INT NOT NULL UNIQUE\n"
                        + ")";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.executeUpdate();

                sql = "CREATE TABLE USERS (\n"
                        + "    ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,\n"
                        + "    NOME VARCHAR(255) NOT NULL,\n"
                        + "    SOBRENOME VARCHAR(255) NOT NULL,\n"
                        + "    LOGIN VARCHAR(255) NOT NULL,\n"
                        + "    SENHA VARCHAR(255) NOT NULL,\n"
                        + "    PRIV INT NOT NULL,\n"
                        + "    CONSTRAINT UK_login UNIQUE (LOGIN)\n "
                        + ")";

                ps = conexao.prepareStatement(sql);
                ps.executeUpdate();

                sql = "CREATE TABLE VENDAS (\n"
                        + "    ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,\n"
                        + "    DATAHORA TIMESTAMP NOT NULL,\n"
                        + "    IDPRODUTOS INT NOT NULL,\n"
                        + "    QUANTIDADE INT,\n"
                        + "    TOTAL FLOAT,\n"
                        + "    NOME VARCHAR(255) NOT NULL,\n"
                        + "    FOREIGN KEY (IDPRODUTOS) REFERENCES PRODUTOS(ID)\n"
                        + ")";

                ps = conexao.prepareStatement(sql);
                ps.executeUpdate();
                
                sql = "INSERT INTO users (nome, sobrenome, login, senha, priv) VALUES ('admin', 'admin', 'admin', 'admin', 0)";
                ps = conexao.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Banco criado com Sucesso!");
                dispose();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(NovoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um nome para o Banco!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoDB().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
}
