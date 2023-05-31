package com.mycompany.admcaixa;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastraUser extends javax.swing.JFrame {

    private int priv;

    public CadastraUser(int priv) {
        initComponents();
        this.priv = priv;
        if (priv == 1) {
            privBox.setEnabled(false);
            privBox.setVisible(false);
            privLabel.setVisible(false);
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        bgCadastraUser.setBackground(new java.awt.Color(51, 51, 51));

        nomeLabel.setForeground(new java.awt.Color(255, 0, 0));
        nomeLabel.setText("Nome");

        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Sobrenome");

        sobrenomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobrenomeFieldActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Login");

        loginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFieldActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Senha");

        senhaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaFieldActionPerformed(evt);
            }
        });

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
                    .addComponent(cadastraBotao))
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

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void sobrenomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobrenomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sobrenomeFieldActionPerformed

    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginFieldActionPerformed

    private void senhaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaFieldActionPerformed

    private void cadastraBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraBotaoActionPerformed
        // Cadastrar a pessoa
        try {
            String url = "jdbc:h2:~/smartbox";
            Connection conexao = DriverManager.getConnection(url, "sa", "");
            String sql = "INSERT INTO users (nome, sobrenome, login, senha, priv) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            if (priv == 1) {
                
                ps.setString(1, nomeField.getText());
                ps.setString(2, sobrenomeField.getText());
                ps.setString(3, loginField.getText());
                ps.setString(4, senhaField.getText());
                ps.setInt(5, 1);
                ps.execute();
            } else {
                ps.setString(1, nomeField.getText());
                ps.setString(2, sobrenomeField.getText());
                ps.setString(3, loginField.getText());
                ps.setString(4, senhaField.getText());
                ps.setInt(5, privBox.getSelectedIndex());
                ps.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_cadastraBotaoActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField loginField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JComboBox<String> privBox;
    private static javax.swing.JLabel privLabel;
    private javax.swing.JTextField senhaField;
    private javax.swing.JTextField sobrenomeField;
    // End of variables declaration//GEN-END:variables
}
