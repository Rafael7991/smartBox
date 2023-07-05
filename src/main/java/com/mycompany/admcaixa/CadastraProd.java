package com.mycompany.admcaixa;

import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class CadastraProd extends javax.swing.JFrame {

    public Connection conexao;
    private static String DB;
    private Func func;
    private Admin admin;
    private String nome;
    private String sobrenome;
    private int priv;

    public CadastraProd(Connection conexao, Func func, String DB) {
        initComponents();
        CadastraProd.DB = DB;
        this.conexao = conexao;
        this.priv = func.getPriv();
        this.nome = func.getNome();
        this.sobrenome = func.getSobrenome();
        this.func = func;
    }

    public CadastraProd(Connection conexao, Admin admin, String DB) {
        initComponents();
        CadastraProd.DB = DB;
        this.conexao = conexao;
        this.admin = admin;
        this.nome = admin.getNome();
        this.sobrenome = admin.getSobrenome();
        this.priv = admin.getPriv();
    }

    public CadastraProd() {
        this.nome = "convidado";
        this.sobrenome = "";
        initComponents();
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
        fieldCod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        volta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        bgCadastProd.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome");

        precoLabel.setForeground(new java.awt.Color(255, 0, 0));
        precoLabel.setText("Preço");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Unidade");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Tipo");

        tipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - Fracionário", "1 - Inteiro", "2 - Privado" }));
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

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Estoque");

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Código");

        volta.setText("VOLTAR");
        volta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltaActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(51, 51, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout bgCadastProdLayout = new javax.swing.GroupLayout(bgCadastProd);
        bgCadastProd.setLayout(bgCadastProdLayout);
        bgCadastProdLayout.setHorizontalGroup(
            bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgCadastProdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volta)
                .addGap(338, 338, 338))
            .addGroup(bgCadastProdLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(bgCadastProdLayout.createSequentialGroup()
                        .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(precoLabel)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cadastBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgCadastProdLayout.createSequentialGroup()
                                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldNome)
                                    .addComponent(fieldPreco)
                                    .addComponent(fieldStock, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(bgCadastProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tipoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(unidBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldCod))))))
                .addContainerGap(177, Short.MAX_VALUE))
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
                    .addComponent(fieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addComponent(cadastBotao)
                .addGap(18, 18, 18)
                .addComponent(volta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bgCadastProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bgCadastProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastBotaoActionPerformed
        // Cadastrar Produto
        if (priv == 0) {
            admin.cadastraProd(DB);
        } else {
            func.cadastraProd(DB);
        }
    }//GEN-LAST:event_cadastBotaoActionPerformed

    private void tipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBoxActionPerformed
        // TODO add your handling code here:
        if (tipoBox.getSelectedIndex() == 0) {
            fieldPreco.setEnabled(false);
            fieldStock.setEnabled(false);
        } else {
            fieldPreco.setEnabled(true);
            fieldStock.setEnabled(true);
        }
    }//GEN-LAST:event_tipoBoxActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        jLabel6.setText("Conectado em: " + DB + " como: " + nome + " " + sobrenome);
        if (tipoBox.getSelectedIndex() == 0) {
            fieldPreco.setEnabled(false);
            fieldStock.setEnabled(false);

        } else {
            fieldPreco.setEnabled(true);
            fieldStock.setEnabled(true);
        }
    }//GEN-LAST:event_formComponentShown

    private void voltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltaActionPerformed
        // VOLTAR
        if (admin == null) {
            System.out.println("criado home com func");
            System.out.println(func.getNome());
            Home home = new Home(func, conexao, DB);
            home.show();
        } else {
            System.out.println("criado home com admin");
            Home home = new Home(admin, conexao, DB);
            home.show();
        }
        dispose();
    }//GEN-LAST:event_voltaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastraProd().setVisible(true);
            }
        });

        /*String url = "jdbc:h2:~/" + DB;
        try (Connection conexao = DriverManager.getConnection(url, "sa", "")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CadastraProd().setVisible(true);
                }
            });
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgCadastProd;
    private javax.swing.JButton cadastBotao;
    protected static javax.swing.JTextField fieldCod;
    protected static javax.swing.JTextField fieldNome;
    protected static javax.swing.JTextField fieldPreco;
    protected static javax.swing.JTextField fieldStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel precoLabel;
    protected static javax.swing.JComboBox<String> tipoBox;
    protected static javax.swing.JComboBox<String> unidBox;
    private javax.swing.JButton volta;
    // End of variables declaration//GEN-END:variables
}
