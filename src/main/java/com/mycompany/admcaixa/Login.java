package com.mycompany.admcaixa;

import java.io.File;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import org.h2.message.DbException;

public class Login extends javax.swing.JFrame {

    String DBEscolhido = "";
    File[] files = null;

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
        discoDB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        discoField = new javax.swing.JTextField();
        dbsAtivos = new javax.swing.JComboBox<>();
        carregaDBs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

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

        discoDB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C:/", "D:/", "Outro", "Selecione" }));
        discoDB.setSelectedIndex(3);
        discoDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discoDBActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Disco do DB");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Letra do Disco:");

        discoField.setEnabled(false);

        dbsAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbsAtivosActionPerformed(evt);
            }
        });

        carregaDBs.setText("Carregar Disco Selcionado");
        carregaDBs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregaDBsActionPerformed(evt);
            }
        });

        bg.setLayer(jUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(create, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(discoDB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(discoField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(dbsAtivos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(carregaDBs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(carregaDBs, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(create)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(login))
                    .addComponent(jPassword)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(discoDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(discoField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dbsAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
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
                    .addComponent(discoDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(discoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbsAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(create)
                    .addComponent(carregaDBs))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
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
                String url = "jdbc:h2:~/" + DBEscolhido;
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
                            Home home = new Home(usuario, conexao);
                            home.show();
                        } else if (rs.getInt("PRIV") == 0) {
                            Admin usuario = new Admin(rs.getString("LOGIN"), rs.getString("SENHA"), rs.getString("NOME"), rs.getString("SOBRENOME"));
                            System.out.println("Ben vindo Administrador");
                            Home home = new Home(usuario, conexao);
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
        Func func = new Func("anonimo");
        CadastraUser cad = new CadastraUser(1, func);
        cad.show();
        dispose();

    }//GEN-LAST:event_createActionPerformed

    private void jUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserActionPerformed

    private void discoDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoDBActionPerformed
        // TODO add your handling code here:

        if (discoDB.getSelectedIndex() == 0) {
            dbsAtivos.removeAllItems();
            File diretorio = new File("C:/Users/" + System.getProperty("user.name"));
            files = diretorio.listFiles((dir, nome) -> nome.toLowerCase().endsWith(".mv.db"));
            if (files.length > 0) {
                for (File file : files) {
                    dbsAtivos.addItem(file.getName());
                }
            }
        } else if (discoDB.getSelectedIndex() == 1) {
            dbsAtivos.removeAllItems();
            File diretorio = new File("D:/Users/" + System.getProperty("user.name"));
            files = diretorio.listFiles((dir, nome) -> nome.toLowerCase().endsWith(".mv.db"));
            if (files.length > 0) {
                for (File file : files) {
                    dbsAtivos.addItem(file.getName());
                }
            }

        } else {
            dbsAtivos.removeAllItems();
            

        }

        if (discoDB.getSelectedIndex() == 2) {
            jLabel4.setVisible(true);
            discoField.setVisible(true);
            discoField.setEnabled(true);
            carregaDBs.setVisible(true);
            carregaDBs.setEnabled(true);
        } else {
            jLabel4.setVisible(false);
            discoField.setVisible(false);
            discoField.setEnabled(false);
            carregaDBs.setVisible(false);
            carregaDBs.setEnabled(false);
        }
    }//GEN-LAST:event_discoDBActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

        jLabel4.setVisible(false);
        discoField.setVisible(false);
        discoField.setEnabled(false);
        carregaDBs.setVisible(false);
        carregaDBs.setEnabled(false);


    }//GEN-LAST:event_formComponentShown

    private void dbsAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbsAtivosActionPerformed
        // TODO add your handling code here:
        if (!DBEscolhido.equals("")) {
            DBEscolhido = (String) dbsAtivos.getSelectedItem();
            DBEscolhido = DBEscolhido.substring(0, DBEscolhido.length() - 6);
            System.out.println(DBEscolhido);
        }

    }//GEN-LAST:event_dbsAtivosActionPerformed

    private void carregaDBsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregaDBsActionPerformed
        // TODO add your handling code here:
        File diretorio = new File(discoField.getText() + ":/Users/" + System.getProperty("user.name"));
        files = diretorio.listFiles((dir, nome) -> nome.toLowerCase().endsWith(".mv.db"));
        if (files != null && !discoField.getText().isEmpty()) {

            for (File file : files) {
                dbsAtivos.addItem(file.getName());
            }

        }


    }//GEN-LAST:event_carregaDBsActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);

            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JButton carregaDBs;
    private javax.swing.JButton create;
    private javax.swing.JComboBox<String> dbsAtivos;
    private javax.swing.JComboBox<String> discoDB;
    private javax.swing.JTextField discoField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jUser;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
}
