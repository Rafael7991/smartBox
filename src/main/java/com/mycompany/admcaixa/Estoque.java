package com.mycompany.admcaixa;

import java.awt.Desktop;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        volta = new javax.swing.JButton();
        print = new javax.swing.JButton();
        abrir = new javax.swing.JButton();
        arqs = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("----------------------------");

        jLabel2.setText("-----------------------------------------------------------");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(volta)
                            .addComponent(print)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(abrir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arqs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(743, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(abrir)
                            .addComponent(arqs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(print)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volta)))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        nomeProd = new ArrayList<>();
        estoqueProd = new ArrayList<>();
        try {
            conexao = Conecta.obterConexao(DB);
            String sql = "SELECT * FROM produtos WHERE estoque IS NOT NULL;";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nomeProd.add(rs.getString("nome"));
                estoqueProd.add(rs.getFloat("estoque"));
            }
            ProdutoTableModel modeloTabela = new ProdutoTableModel(nomeProd, estoqueProd);
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

        jLabel1.setText("Conectado em: " + DB + " como: " + nome + " " + sobrenome);

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
            File file = new File(System.getProperty("user.home")+ "\\" + selectedFileName);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton print;
    private javax.swing.JButton volta;
    // End of variables declaration//GEN-END:variables
}
