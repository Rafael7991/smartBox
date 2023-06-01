
package com.mycompany.admcaixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastraProd extends javax.swing.JFrame {
    
    private final Connection conexao;
    
    public CadastraProd(Connection conexao) {
        initComponents();
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCadastProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        precoLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tipoBox = new javax.swing.JComboBox<>();
        unidBox = new javax.swing.JComboBox<>();
        cadastBotao = new javax.swing.JButton();
        fieldPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgCadastProd.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome");

        precoLabel.setForeground(new java.awt.Color(255, 0, 0));
        precoLabel.setText("Preço");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Unidade");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Tipo");

        tipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - Fracionário", "1 - Inteiro" }));
        tipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBoxActionPerformed(evt);
            }
        });

        unidBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "u", "g", "Kg" }));

        cadastBotao.setText("Cadastrar");
        cadastBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastBotaoActionPerformed(evt);
            }
        });

        fieldPreco.setEnabled(false);
        fieldPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPrecoActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Estoque");

        javax.swing.GroupLayout bgCadastProdLayout = new javax.swing.GroupLayout(bgCadastProd);
        bgCadastProd.setLayout(bgCadastProdLayout);
        bgCadastProdLayout.setHorizontalGroup(
            bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCadastProdLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(precoLabel)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldNome)
                    .addComponent(fieldPreco)
                    .addComponent(fieldStock, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cadastBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unidBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        bgCadastProdLayout.setVerticalGroup(
            bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCadastProdLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoLabel)
                    .addComponent(jLabel3)
                    .addComponent(unidBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cadastBotao))
                .addContainerGap(288, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCadastProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCadastProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastBotaoActionPerformed
        // Cadastrar Produto

        try {
            /*-String url = "jdbc:h2:~/smartbox";
            Connection conexao = DriverManager.getConnection(url, "sa", "");*/
            String sql = "INSERT INTO produtos (nome, preco, tipo, estoque, unidade) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, fieldNome.getText());
            ps.setFloat(2, Float.parseFloat(fieldPreco.getText()));
            ps.setInt(3, tipoBox.getSelectedIndex());
            ps.setFloat(4, Float.parseFloat(fieldPreco.getText()));
            ps.setString(5, (String) unidBox.getSelectedItem());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cadastBotaoActionPerformed

    private void fieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPrecoActionPerformed


    private void tipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBoxActionPerformed
        // TODO add your handling code here:
        if(tipoBox.getSelectedIndex() == 0){
            fieldPreco.setEnabled(false);
            fieldStock.setEnabled(false);
        } else {
            fieldPreco.setEnabled(true);
            fieldStock.setEnabled(true);
        }
    }//GEN-LAST:event_tipoBoxActionPerformed

    
    public static void main(String args[]) {
        String url = "jdbc:h2:~/smartbox";
        try (Connection conexao = DriverManager.getConnection(url, "sa", "")) 
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CadastraProd(conexao).setVisible(true);
                    
                }
                
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgCadastProd;
    private javax.swing.JButton cadastBotao;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldPreco;
    private javax.swing.JTextField fieldStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel precoLabel;
    private javax.swing.JComboBox<String> tipoBox;
    private javax.swing.JComboBox<String> unidBox;
    // End of variables declaration//GEN-END:variables
}
