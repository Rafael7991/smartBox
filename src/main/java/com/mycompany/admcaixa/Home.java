package com.mycompany.admcaixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends javax.swing.JFrame {

    private Connection conexao;
    private Func func;
    private Admin admin;
    private static String DB;
    private String nome;
    private String sobrenome;

    public Home(Func usuario, Connection conexao, String DB) {
        initComponents();
        this.conexao = conexao;
        Home.DB = DB;
        func = usuario;
        nome = usuario.getNome();
        sobrenome = usuario.getSobrenome();
    }

    public Home(Admin usuario, Connection conexao, String DB) {
        initComponents();
        this.conexao = conexao;
        Home.DB = DB;
        admin = usuario;
        nome = usuario.getNome();
        sobrenome = usuario.getSobrenome();
    }

    public Home(Connection conexao) {
        initComponents();
        this.conexao = conexao;
        nome = "convidado";
        sobrenome = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgHome = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        bgHome.setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setText("Gerenciamento de Caixa");
        jButton1.setAlignmentY(0.0F);
        jButton1.setPreferredSize(new java.awt.Dimension(160, 25));
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cadastrar Produto");
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cadastrar Usuário");
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Novo Banco de Dados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Estoque");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("SAIR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("VOLTAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Deletar Usuário");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 51, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout bgHomeLayout = new javax.swing.GroupLayout(bgHome);
        bgHome.setLayout(bgHomeLayout);
        bgHomeLayout.setHorizontalGroup(
            bgHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgHomeLayout.createSequentialGroup()
                .addGroup(bgHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(bgHomeLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgHomeLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addGroup(bgHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgHomeLayout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgHomeLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jLabel2)))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        bgHomeLayout.setVerticalGroup(
            bgHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Gerenciamento de caixa
        if (admin == null) {
            Caixa caixa = new Caixa(DB, func);
            caixa.show();
        } else {
            Caixa caixa = new Caixa(DB, admin);
            caixa.show();
        }
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Cadastrar Produto
        if (admin == null) {
            CadastraProd cad = new CadastraProd(conexao, func, DB);
            cad.show();

        } else {
            CadastraProd cad = new CadastraProd(conexao, admin, DB);
            cad.show();
        }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cadastrar Usuario
        if (admin == null) {
            CadastraUser cad = new CadastraUser(conexao, func, DB);
            cad.show();
        } else {
            CadastraUser cad = new CadastraUser(conexao, admin, DB);
            cad.show();
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // CRIAR NOVO BANCO DE DADOS
        NovoDB ndb = new NovoDB();
        ndb.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // ABRIU
        jLabel2.setText("Conectado em: " + DB + " como: " + nome + " " + sobrenome);
    }//GEN-LAST:event_formComponentShown

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // ESTOQUE
        if (admin == null) {
            Estoque est = new Estoque(func, conexao, DB);
            est.show();
        } else {
            Estoque est = new Estoque(admin, conexao, DB);
            est.show();
        }
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if (conexao != null) {
                conexao.close();
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            if (conexao != null) {
                conexao.close();
                Login log = new Login();
                log.show();
                dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (admin == null) {
            Usuarios usu = new Usuarios(func, conexao, DB);
            usu.show();
        } else {
            Usuarios usu = new Usuarios(admin, conexao, DB);
            usu.show();
        }
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    public static void main(String args[]) {
        String url = "jdbc:h2:~/" + DB;
        try (Connection conexao = DriverManager.getConnection(url, "sa", "")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Home(conexao).setVisible(true);
                }
            });
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgHome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
