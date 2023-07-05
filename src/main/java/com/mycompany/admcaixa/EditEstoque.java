package com.mycompany.admcaixa;

import java.sql.Connection;

public class EditEstoque extends javax.swing.JFrame {

    public Connection conexao;
    private String nome;
    private static String DB;
    private Func func;
    private Admin admin;
    private int cod;
    private int priv;

    public EditEstoque(Connection conexao, Func func, String DB, String nome, int cod) {
        this.cod = cod;
        this.nome = nome;
        this.func = func;
        EditEstoque.DB = DB;
        this.conexao = conexao;
        this.priv = func.getPriv();
        initComponents();
    }

    public EditEstoque(Connection conexao, Admin admin, String DB, String nome, int cod) {
        this.cod = cod;
        this.nome = nome;
        this.admin = admin;
        EditEstoque.DB = DB;
        this.conexao = conexao;
        this.priv = admin.getPriv();
        initComponents();
    }

    public EditEstoque() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        atualizaB = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Produto:");

        jLabel2.setText("jLabel2");

        jLabel4.setText("Novo Estoque:");

        atualizaB.setText("ATUALIZAR");
        atualizaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaBActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("DELETAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Código:");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(atualizaB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atualizaB)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       jLabel2.setText(nome);
       jLabel5.setText(Integer.toString(cod));
    }//GEN-LAST:event_formComponentShown

    private void atualizaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaBActionPerformed
        // TODO add your handling code here:
        Float novoEstoque;
        if (!jTextField2.getText().isEmpty()) {
            novoEstoque = Float.valueOf(jTextField2.getText());
            if (priv == 0) {
                admin.atualizaProd(DB);
            } else {
                func.atualizaProd(DB);
            }
        }

    }//GEN-LAST:event_atualizaBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // DELETA
        if (priv == 0) {
                admin.deleteProd(DB);
            } else {
                func.deleteProd(DB);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizaB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    protected static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    protected static javax.swing.JLabel jLabel5;
    protected static javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
