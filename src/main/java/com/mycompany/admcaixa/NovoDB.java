package com.mycompany.admcaixa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
        jLabel2 = new javax.swing.JLabel();
        disco = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        outroDisco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

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

        jLabel2.setText("Disco onde H2 foi instalado: ");

        disco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C:/", "D:/", "Outro" }));
        disco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discoActionPerformed(evt);
            }
        });

        jLabel3.setText("Informe somente a letra do Disco onde o H2 foi instalado:");

        outroDisco.setEnabled(false);
        outroDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outroDiscoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outroDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(disco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(outroDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // SAIR
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // CRIAR BANCO
        if (!nome.getText().isEmpty()) {
            if (disco.getSelectedIndex() == 2) {
                if (!outroDisco.getText().isEmpty() && outroDisco.getText().length() == 1) {
                    nomeDiretorio = outroDisco.getText() + ":/" + "Users/" + System.getProperty("user.name");
                } else {
                    JOptionPane.showMessageDialog(null, "Informar disco onde H2 foi instalado, somente a letra");
                }
            } else {
                nomeDiretorio = (String) disco.getSelectedItem() + "Users/" + System.getProperty("user.name");
            }
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
                        + "    PRIV INT NOT NULL\n"
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
                
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(NovoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void discoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoActionPerformed
        // TODO add your handling code here:
        if (disco.getSelectedIndex() == 2) {
            jLabel3.setVisible(true);
            outroDisco.setVisible(true);
            outroDisco.setEnabled(true);
        } else {
            jLabel3.setVisible(false);
            outroDisco.setVisible(false);
            outroDisco.setEnabled(false);
        }
    }//GEN-LAST:event_discoActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        jLabel3.setVisible(false);
        outroDisco.setVisible(false);
        outroDisco.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void outroDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outroDiscoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outroDiscoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovoDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoDB().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> disco;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField outroDisco;
    // End of variables declaration//GEN-END:variables
}
