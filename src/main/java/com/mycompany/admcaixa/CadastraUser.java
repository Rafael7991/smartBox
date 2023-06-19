package com.mycompany.admcaixa;

import java.sql.*;
import javax.swing.JOptionPane;

public class CadastraUser extends javax.swing.JFrame {

    private int priv;
    private Func func;
    private Admin admin;

    public CadastraUser(int priv, Func func) {
        initComponents();
        this.priv = priv;
        this.func = func;
        privBox.setEnabled(false);
        privBox.setVisible(false);
        privLabel.setVisible(false);

    }

    public CadastraUser(int priv, Admin admin) {
        initComponents();
        this.admin = admin;
        this.priv = priv;
    }

    public CadastraUser(int priv) {
        this.priv = priv;
        initComponents();
    }

    public CadastraUser() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCadastraUser = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sobrenomeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        senhaField = new javax.swing.JTextField();
        privBox = new javax.swing.JComboBox<>();
        privLabel = new javax.swing.JLabel();
        cadastraBotao = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgCadastraUser.setBackground(new java.awt.Color(51, 51, 51));

        nomeLabel.setForeground(new java.awt.Color(255, 0, 0));
        nomeLabel.setText("Nome");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Sobrenome");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Login");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Senha");

        privBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        privLabel.setForeground(new java.awt.Color(255, 0, 0));
        privLabel.setText("Privilegio");

        cadastraBotao.setText("Cadastrar");
        cadastraBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraBotaoActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");

        jButton1.setText("SAIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgCadastraUserLayout = new javax.swing.GroupLayout(bgCadastraUser);
        bgCadastraUser.setLayout(bgCadastraUserLayout);
        bgCadastraUserLayout.setHorizontalGroup(
            bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCadastraUserLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bgCadastraUserLayout.createSequentialGroup()
                        .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nomeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sobrenomeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgCadastraUserLayout.createSequentialGroup()
                            .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(privLabel))
                            .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgCadastraUserLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(privBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(cadastraBotao))
                                .addGroup(bgCadastraUserLayout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(220, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgCadastraUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        bgCadastraUserLayout.setVerticalGroup(
            bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCadastraUserLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sobrenomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgCadastraUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(privBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(privLabel)
                    .addComponent(cadastraBotao)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCadastraUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCadastraUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastraBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraBotaoActionPerformed
        // Cadastrar a pessoa
        if (nomeField.getText().isEmpty() || sobrenomeField.getText().isEmpty() || loginField.getText().isEmpty() || senhaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher todos os campos!");
        } else {
            if (priv == 0) {
                admin.cadastraUser();
            } else {
                func.cadastraUser();
            }
        }
    }//GEN-LAST:event_cadastraBotaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // SAIR
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastraUser().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgCadastraUser;
    private javax.swing.JButton cadastraBotao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    protected static javax.swing.JTextField loginField;
    protected static javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    protected static javax.swing.JComboBox<String> privBox;
    private static javax.swing.JLabel privLabel;
    protected static javax.swing.JTextField senhaField;
    protected static javax.swing.JTextField sobrenomeField;
    // End of variables declaration//GEN-END:variables
}
