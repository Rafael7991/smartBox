/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.admcaixa;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lopes
 */
public class Usuarios extends javax.swing.JFrame {

    private Connection conexao;
    private static String DB;
    private Func func;
    private Admin admin;
    private String nome;
    private String sobrenome;
    private ArrayList<String> username;
    private ArrayList<String> nomeUsuario;
    private ArrayList<String> sobrenomeUsuario;
    private ArrayList<Integer> privUsuario;

    public Usuarios(Func usuario, Connection conexao, String DB) {
        initComponents();
        this.conexao = conexao;
        this.DB = DB;
        func = usuario;
        nome = usuario.getNome();
        sobrenome = usuario.getSobrenome();
    }

    public Usuarios(Admin usuario, Connection conexao, String DB) {
        initComponents();
        this.conexao = conexao;
        this.DB = DB;
        admin = usuario;
        nome = usuario.getNome();
        sobrenome = usuario.getSobrenome();
    }
    public Usuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("VOLTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        username = new ArrayList<>();
        nomeUsuario = new ArrayList<>();
        sobrenomeUsuario = new ArrayList<>();
        privUsuario = new ArrayList<>();
        try {
            conexao = Conecta.obterConexao(DB);
            String sql = "SELECT * FROM users";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                username.add(rs.getString("login"));
                nomeUsuario.add(rs.getString("nome"));
                sobrenomeUsuario.add(rs.getString("sobrenome"));
                privUsuario.add(rs.getInt("priv"));               
            }
            UserTableModel modeloTabela = new UserTableModel(username,nomeUsuario, sobrenomeUsuario,privUsuario);
            jTable1.setModel(modeloTabela);
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();
            String login = (String) jTable1.getValueAt(row, 3);
            String nome = (String) jTable1.getValueAt(row, 0) + " " +(String) jTable1.getValueAt(row, 1);
            //Float estoque = (Float) jTable1.getValueAt(row, 1);
            
            openDeleteUserScreen(login, nome);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (admin == null) {
            Home home = new Home(func,conexao,DB);
            home.show();
        } else {
            Home home = new Home(admin,conexao,DB);
            home.show();
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void openDeleteUserScreen(String login, String nome) {
        // Crie uma nova instância da tela de edição de estoque
        if (admin == null) {           
            DeleteUser delete = new DeleteUser(conexao, func, DB,login, nome);
            delete.show();
        } else {
            DeleteUser delete = new DeleteUser(conexao, admin, DB,login, nome);           
            delete.show();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       String url = "jdbc:h2:~/" + DB;
        try (Connection conexao = DriverManager.getConnection(url, "sa", "")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Estoque().setVisible(true);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
