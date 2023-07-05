package com.mycompany.admcaixa;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {
    
    private final ArrayList<Integer> codProd;
    private final ArrayList<String> nomeProd;
    private final ArrayList<Float> estoqueProd;

    public ProdutoTableModel(ArrayList<String> nomeProd, ArrayList<Float> estoqueProd, ArrayList<Integer> codProd) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
        this.estoqueProd = estoqueProd;
    }
     
    @Override
    public int getRowCount() {
        return codProd.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3; // Número de colunas
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            case 2:
                return "Estoque";
            default:
                return "";
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return codProd.get(row);
            case 1:
                return nomeProd.get(row);
            case 2:
                return estoqueProd.get(row);
            default:
                return null;
        }
    }
}