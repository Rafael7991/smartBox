package com.mycompany.admcaixa;

import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class popup extends javax.swing.JFrame {

    private final Connection conexao;
    private int tipo;
    private int countEnter = 0;
    private int id;
    private Venda venda;
    private String nome;
    private Float preco;
    private PreparedStatement ps;
    private int linhasAfetadas = 0;
    private ProdutoFrac PFrac;
    private ProdutoInt PInt;

    public popup(Connection conexao) {
        this.conexao = conexao;
        this.venda = new Venda(new Timestamp(new java.util.Date().getTime()));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Código");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("-");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setBackground(new java.awt.Color(102, 255, 51));
        jButton1.setText("GO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 102, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText(">>>>>");
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
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Botão quantidade/preço acionado
        if (jTextArea1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher com preço ou Quantidade");
        } else {

            switch (tipo) {
                case 0:
                    PFrac = new ProdutoFrac(id, nome, preco);
                    venda.addItem(PFrac.valorTotal(), 1);
                    break;
                case 1:
                    PInt = new ProdutoInt(id, nome, Integer.parseInt(jTextArea2.getText()), preco);
                    venda.addItem(PInt.valorTotal(), Integer.parseInt(jTextArea2.getText()));
                    break;

            }

            venda.setTotal(venda.getTotalParcial());

            try {

                ps = conexao.prepareStatement("INSERT INTO vendas (dataHora, idprodutos, quantidade, total) VALUES (?, ?, ?, ?)");

                ps.setTimestamp(1, venda.getDataHoraAtual());

                ps.setInt(2, id);
                if (tipo == 0) {
                    ps.setInt(3, PFrac.getQtd());
                    ps.setFloat(4, PFrac.valorTotal());

                } else if (tipo == 1) {

                    ps.setInt(3, PInt.getQtd());
                    ps.setFloat(4, PInt.valorTotal());

                }
                linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Inserção realizada com sucesso.");
                } else {
                    System.out.println("Não foi possível realizar a inserção.");
                }

            } catch (SQLException ex) {
                Logger.getLogger(popup.class.getName()).log(Level.SEVERE, null, ex);
            }

            jButton2.setVisible(true);
            jButton2.setEnabled(true);
            jButton1.setVisible(false);
            jButton1.setEnabled(false);
            jTextArea1.setText("");
            jTextArea2.setText("");
            jTextArea1.requestFocus();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Popup foi aberto
        jButton1.setVisible(false);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Botão do código acionado
        if (jTextArea1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher com codigo do Produto");
        } else if (jTextArea1.getText().equals("999")) {

            dispose();
        } else {
            jButton2.setVisible(false);
            jButton2.setEnabled(false);
            jButton1.setVisible(true);
            jButton1.setEnabled(true);
            jTextArea2.requestFocus();
            String cod = jTextArea1.getText();

            try {
                ps = conexao.prepareStatement("SELECT * FROM produtos where id = ?");
                ps.setString(1, cod);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    tipo = rs.getInt("tipo");
                    int estoque = rs.getInt("estoque");
                    nome = rs.getString("nome");
                    id = Integer.parseInt(cod);
                    preco = rs.getFloat("preco");
                    System.out.println("ID: " + cod + ", Nome: " + nome + " Estoque " + estoque);

                }
                if (tipo == 0) {
                    jLabel2.setText("Preço: ");
                } else {
                    jLabel2.setText("Quantidade");
                }

            } catch (SQLException ex) {
                Logger.getLogger(popup.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        String url = "jdbc:h2:~/smartbox";
        try (Connection conexao = DriverManager.getConnection(url, "sa", "")) {
            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    new popup(conexao).setVisible(true);

                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//JOptionPane.showMessageDialog(null, "Preencher com codigo do Produto");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
