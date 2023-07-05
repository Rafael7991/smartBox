package com.mycompany.admcaixa;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class popup extends javax.swing.JFrame {

    private final Connection conexao;
    private int tipo;
    private int countEnter = 0;
    private int id;
    private String cod;
    private static Venda venda;
    private String nome;
    private Float preco;
    private PreparedStatement ps;
    private PreparedStatement ps2;
    private int linhasAfetadas = 0;
    private ProdutoFrac PFrac;
    private ProdutoInt PInt;
    private Float entrada;
    private Float saida;
    private int qtd;
    private int estoque;
    private int novoEstoque;
    private DecimalFormat formato;

    public popup(Connection conexao, Venda venda) {
        this.conexao = conexao;
        this.venda = new Venda(new Timestamp(new java.util.Date().getTime()));
        formato = new DecimalFormat("#,##0.00");
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
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Código");

        jTextArea1.setColumns(4);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextArea1.setRows(1);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("-");

        jTextArea2.setColumns(6);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextArea2.setRows(1);
        jTextArea2.setPreferredSize(new java.awt.Dimension(136, 52));
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

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText(">>>>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton2))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(42, 42, 42)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
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
                    PFrac = new ProdutoFrac(id, nome, Float.parseFloat(jTextArea2.getText()));
                    venda.addItem(PFrac.valorTotal(), 1);
                    break;
                case 1:
                    PInt = new ProdutoInt(id, nome, Integer.parseInt(jTextArea2.getText()), preco);
                    venda.addItem(PInt.valorTotal(), Integer.parseInt(jTextArea2.getText()));
                    qtd = Integer.parseInt(jTextArea2.getText());
                    break;
            }
            venda.setTotal(venda.getTotalParcial());
            
            try {
                ps = conexao.prepareStatement("INSERT INTO vendas (dataHora, idprodutos, quantidade, total, nome) VALUES (?, ?, ?, ?, ?)");
                ps.setTimestamp(1, venda.getDataHoraAtual());
                ps.setString(5, nome);
                ps.setInt(2, id);
                estoque = estoque - qtd;
                cod = jTextArea1.getText();
                //System.out.println("novo estoque " + novoEstoque);
                if (tipo == 0) {
                    ps.setInt(3, PFrac.getQtd());
                    ps.setFloat(4, PFrac.valorTotal());
                } else if (tipo == 1) {
                    ps2 = conexao.prepareStatement("UPDATE produtos SET estoque = ? WHERE cod = ?");
                    ps2.setInt(1, estoque);
                    System.out.println("ID: " + id + "pint get estoque: " + PInt.getEstoque() + "pint getqtd: " + PInt.getQtd());
                    ps2.setString(2, cod);
                    ps.setInt(3, PInt.getQtd());
                    ps.setFloat(4, PInt.valorTotal());
                    ps2.executeUpdate();
                } else {
                    JOptionPane.showMessageDialog(null, "Tipo de produto não autorizado para Venda");
                    /*dispose();
                    return;*/
                }
                ps.executeUpdate();
                
                Caixa.jLabel2.setText("R$" + formato.format(venda.getTotalParcial()));

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

        //String numeroFormatado = formato.format(numero);
        jButton1.setVisible(false);
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton3.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Botão do código acionado
        if (jTextArea1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher com codigo do Produto");
        } else if (jTextArea1.getText().equals("9")) {
            jLabel1.setText("Valor pago:");
            jTextArea1.setText("");
            jTextArea2.setEnabled(false);
            jTextArea2.setVisible(false);
            jButton3.setEnabled(true);
            jButton3.setVisible(true);
            jButton2.setEnabled(false);
            jButton2.setVisible(false);
            //dispose();
        } else {
            jButton2.setVisible(false);
            jButton2.setEnabled(false);
            jButton1.setVisible(true);
            jButton1.setEnabled(true);
            jTextArea2.requestFocus();
            cod = jTextArea1.getText();

            try {
                ps = conexao.prepareStatement("SELECT * FROM produtos where cod = ?");
                ps.setString(1, cod);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    tipo = rs.getInt("tipo");
                    estoque = rs.getInt("estoque");
                    nome = rs.getString("nome");
                    id = rs.getInt("id");
                    preco = rs.getFloat("preco");
                    System.out.println("ID: " + cod + ", Nome: " + nome + " Estoque " + estoque);

                }

                if (nome != null) {
                    if (tipo == 0) {
                        jLabel2.setText("Preço: ");
                        Caixa.jLabel1.setText(nome);
                    } else if (tipo == 1) {
                        jLabel2.setText("Quantidade");
                        Caixa.jLabel1.setText(nome + "  R$" + formato.format(preco));

                    }
                    /*else {

                    }*/
                } else {
                    JOptionPane.showMessageDialog(null, "Código invalido");
                    jButton2.setVisible(true);
                    jButton2.setEnabled(true);
                    jButton1.setVisible(false);
                    jButton1.setEnabled(false);
                    jTextArea1.setText("");
                    jTextArea1.requestFocus();
                }

            } catch (SQLException ex) {
                Logger.getLogger(popup.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jTextArea1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entre com o Valor que o cliente pagou");
        } else {
            entrada = Float.parseFloat(jTextArea1.getText());
            saida = entrada - venda.getTotal();
            Caixa.jLabel3.setText("Troco: R$" + formato.format(saida));
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        String url = "jdbc:h2:~/smartbox";
        try (Connection conexao = DriverManager.getConnection(url, "sa", "")) {
            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    new popup(conexao, venda).setVisible(true);

                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//JOptionPane.showMessageDialog(null, "Preencher com codigo do Produto");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
