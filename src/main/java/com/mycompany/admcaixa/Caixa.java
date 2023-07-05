package com.mycompany.admcaixa;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.getRootFrame;

public class Caixa extends javax.swing.JFrame {

    public Connection conexao;
    private static String DB;
    private Func func;
    private Admin admin;
    private String nome;
    private String sobrenome;
    private ArrayList<String> datahora;
    private ArrayList<String> nomeProd;
    private ArrayList<Float> valor;

    public Caixa(String DB, Func usuario) {
        initComponents();
        System.out.println("Criado usuario func");
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        this.func = usuario;
        this.DB = DB;
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        //this.conexao = conexao;
    }

    public Caixa(String DB, Admin usuario) {
        initComponents();
        System.out.println("Criado usuario admin");
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        this.admin = usuario;
        this.DB = DB;
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        //this.conexao = conexao;
    }
    
    public Caixa(Connection conexao){
        this.nome = "convidado";
        this.sobrenome = "";
        initComponents();
        DecimalFormat formato = new DecimalFormat("#,##0.00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vendaBotao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        vendaBotao.setText("Nova Venda");
        vendaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaBotaoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 56)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 300, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton1.setText("SAIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("VOLTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        print.setText("GERAR PDF");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jButton3.setText("Apagar todos os Registros");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Consultar Códigos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                    .addComponent(vendaBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(print))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(print)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addComponent(vendaBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    }//GEN-LAST:event_formWindowActivated

    private void vendaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendaBotaoActionPerformed

        Venda venda = new Venda(new Timestamp(new java.util.Date().getTime()));
        popup popup = new popup(conexao, venda);
        popup.show();
    }//GEN-LAST:event_vendaBotaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // SAIR
            conexao.close();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        jLabel4.setText("Conectado em: " + DB + " como: " + nome + " " + sobrenome);
        nomeProd = new ArrayList<>();
        valor = new ArrayList<>();
        datahora = new ArrayList<>();
        try {
            conexao = Conecta.obterConexao(DB);
            System.out.println("conectado a: " + DB);
            String sql = "SELECT * FROM vendas;";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datahora.add(rs.getString("datahora"));
                nomeProd.add(rs.getString("nome"));
                valor.add(rs.getFloat("total"));
            }
            VendasTableModel modeloTabela = new VendasTableModel(datahora, nomeProd, valor);
            jTable1.setModel(modeloTabela);
        } catch (SQLException ex) {
            Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // VOLTAR
        if (admin == null) {
            System.out.println("criado home com func");
            System.out.println(func.getNome());
            Home home = new Home(func,conexao,DB);
            home.show();
        } else {
            System.out.println("criado home com admin");
            Home home = new Home(admin,conexao,DB);
            home.show();
        }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
         Date dataHoraAtual = new Date();

        // Formatar a data no formato desejado
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String dataHoraFormatada = formatter.format(dataHoraAtual);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataTitulo = sdf.format(dataHoraAtual);

        // Nome do arquivo com a data
        String nomeArquivo = System.getProperty("user.home") + "/Vendas_" + dataHoraFormatada + ".pdf";

        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo));
            document.open();

            PdfPTable pdfTable = new PdfPTable(jTable1.getColumnCount());

            // Preenchimento da tabela com os dados da JTable
            for (int column = 0; column < jTable1.getColumnCount(); column++) {
                PdfPCell cell = new PdfPCell(new Paragraph(jTable1.getColumnName(column)));
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Preenchimento da tabela com os dados da JTable
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                for (int column = 0; column < jTable1.getColumnCount(); column++) {
                    pdfTable.addCell(jTable1.getValueAt(row, column).toString());
                }
            }

            document.add(new Paragraph(" "));
            document.add(new Paragraph("VENDAS ATÉ O DIA: " + dataTitulo));
            document.add(new Paragraph(" "));
            pdfTable.setHeaderRows(1);
            document.add(pdfTable);

            JOptionPane.showMessageDialog(null, "arquivo salvo em: " + System.getProperty("user.home"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }//GEN-LAST:event_printActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showOptionDialog(
                null,
                "Deseja Apagar todos os registros de Venda?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                new Object[]{"Sim", "Não"},
                "Sim"
        );
        
        if (resposta == JOptionPane.YES_OPTION) {
            deleteVendas();
        } else if (resposta == JOptionPane.NO_OPTION) {
            getRootFrame().dispose();
        } else if (resposta == JOptionPane.CLOSED_OPTION) {
           getRootFrame().dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        TabelaConsulta tc = new TabelaConsulta(DB);
        tc.show();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void deleteVendas(){
        try {
            String sql = "DELETE FROM VENDAS";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro: " + ex.getMessage());
        }
    }
    public static void main(String args[]) {
        String url = "jdbc:h2:~/" + DB;
        try (Connection conexao = DriverManager.getConnection(url, "sa", "")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Caixa(conexao).setVisible(true);
                }
            });
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    protected static javax.swing.JLabel jLabel1;
    protected static javax.swing.JLabel jLabel2;
    protected static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton print;
    private javax.swing.JButton vendaBotao;
    // End of variables declaration//GEN-END:variables

}
