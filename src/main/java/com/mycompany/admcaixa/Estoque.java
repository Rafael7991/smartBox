package com.mycompany.admcaixa;

import java.awt.Desktop;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;

public class Estoque extends javax.swing.JFrame {

    private Connection conexao;
    private static String DB;
    private Func func;
    private Admin admin;
    private String nome;
    private String sobrenome;
    private ArrayList<Integer> codProd;
    private ArrayList<String> nomeProd;
    private ArrayList<Float> estoqueProd;

    public Estoque(Func usuario, Connection conexao, String DB) {
        initComponents();
        this.conexao = conexao;
        this.DB = DB;
        func = usuario;
        nome = usuario.getNome();
        sobrenome = usuario.getSobrenome();
    }

    public Estoque(Admin usuario, Connection conexao, String DB) {
        initComponents();
        this.conexao = conexao;
        this.DB = DB;
        admin = usuario;
        nome = usuario.getNome();
        sobrenome = usuario.getSobrenome();
    }

    public Estoque(Connection conexao) {
        initComponents();
        this.conexao = conexao;
        nome = "convidado";
        sobrenome = "";
    }

    public Estoque() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        volta = new javax.swing.JButton();
        print = new javax.swing.JButton();
        abrir = new javax.swing.JButton();
        arqs = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

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

        volta.setText("VOLTAR");
        volta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltaActionPerformed(evt);
            }
        });

        print.setText("SALVAR");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        abrir.setText("ABRIR");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 51, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(abrir)
                        .addGap(18, 18, 18)
                        .addComponent(arqs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(print)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(volta))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(abrir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(arqs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(print)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(volta)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jLabel3.setText("Conectado em: " + DB + " como: " + nome + " " + sobrenome);
        codProd = new ArrayList<>();
        nomeProd = new ArrayList<>();
        estoqueProd = new ArrayList<>();
        try {
            conexao = Conecta.obterConexao(DB);
            String sql = "SELECT * FROM produtos";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codProd.add(rs.getInt("cod"));
                nomeProd.add(rs.getString("nome"));
                estoqueProd.add(rs.getFloat("estoque"));
            }
            ProdutoTableModel modeloTabela = new ProdutoTableModel(nomeProd, estoqueProd, codProd);
            jTable1.setModel(modeloTabela);
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }

        String userHome = System.getProperty("user.home");
        File diretorio = new File(userHome);
        System.out.println(userHome);
        File[] files = diretorio.listFiles((dir, nome) -> nome.toLowerCase().endsWith(".pdf"));
        if (files.length > 0) {
            for (File file : files) {
                arqs.addItem(file.getName());
            }
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

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // salvar pdf
        Date dataHoraAtual = new Date();

        // Formatar a data no formato desejado
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String dataHoraFormatada = formatter.format(dataHoraAtual);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataTitulo = sdf.format(dataHoraAtual);

        // Nome do arquivo com a data
        String nomeArquivo = System.getProperty("user.home") + "/Estoque_" + dataHoraFormatada + ".pdf";

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
            document.add(new Paragraph("ESTOQUE DO DIA: " + dataTitulo));
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

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        // TODO add your handling code here:
        String selectedFileName = (String) arqs.getSelectedItem();
        try {
            File file = new File(System.getProperty("user.home") + "\\" + selectedFileName);
            Desktop desktop = Desktop.getDesktop();
            //desktop.open(file);
            if (file.exists()) {
                desktop.open(file);
            } else {
                System.out.println("Arquivo não encontrado: " + System.getProperty("user.home") + selectedFileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_abrirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();
            int cod = (Integer) jTable1.getValueAt(row,0);
            String nome = (String) jTable1.getValueAt(row, 1);
            //Float estoque = (Float) jTable1.getValueAt(row, 1);
            
            openEditStockScreen(cod,nome);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void openEditStockScreen(int cod, String nome) {
        // Crie uma nova instância da tela de edição de estoque
        if (admin == null) {           
            EditEstoque telaEdicao = new EditEstoque(conexao, func, DB,nome, cod);
            telaEdicao.show();
        } else {
            EditEstoque telaEdicao = new EditEstoque(conexao, admin, DB,nome, cod);           
            telaEdicao.show();
        }
    }

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
    private javax.swing.JButton abrir;
    private javax.swing.JComboBox<String> arqs;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton print;
    private javax.swing.JButton volta;
    // End of variables declaration//GEN-END:variables
}
