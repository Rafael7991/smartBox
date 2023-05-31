package com.mycompany.admcaixa;

import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import org.h2.message.DbException;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        jUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        create = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(51, 51, 51));
        bg.setOpaque(true);

        jUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 204, 102));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Usuário");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Senha");

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        create.setText("Criar Usuário");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        bg.setLayer(jUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(create, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(create)
                        .addGap(18, 18, 18)
                        .addComponent(login))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(jUser))))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(create))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleParent(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

        if (jUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Entre com o nome de usuario");
        } else if (jPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Entre com a senha");
        } else {
            try {
                String url = "jdbc:h2:~/smartbox";
                Connection conexao = DriverManager.getConnection(url, "sa", "");
                String sql = "SELECT * FROM users";
                PreparedStatement ps = conexao.prepareStatement(sql);
                Statement qs = conexao.createStatement();
                ResultSet rs = ps.executeQuery();
                ResultSet ss = qs.executeQuery("select count(*) from users");
                int cont = 0;
                if (ss.next()) {
                    cont = ss.getInt(1);
                }
                while (rs.next()) {
                    if (jUser.getText().equals(rs.getString("LOGIN")) && jPassword.getText().equals(rs.getString("SENHA"))) {

                        if (rs.getInt("PRIV") == 1) {
                            Func usuario = new Func(rs.getString("LOGIN"), rs.getString("SENHA"), rs.getString("NOME"), rs.getString("SOBRENOME"));
                            System.out.println("Ben vindo funcionario");
                            Home home = new Home(usuario);
                            home.show();
                        } else if (rs.getInt("PRIV") == 0) {
                            Admin usuario = new Admin(rs.getString("LOGIN"), rs.getString("SENHA"), rs.getString("NOME"), rs.getString("SOBRENOME"));
                            System.out.println("Ben vindo Administrador");
                            Home home = new Home(usuario);
                            home.show();
                        }
                        dispose();
                        break;
                    } else if (rs.getInt("ID") == cont) {
                        JOptionPane.showMessageDialog(null, "nao encontrada ");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_loginActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        //Cadastrar Usuario
       
        CadastraUser cad = new CadastraUser(1);
        cad.show();
        dispose();
        
        
        
        
        
    }//GEN-LAST:event_createActionPerformed

    private void jUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);

            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JButton create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jUser;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
}
