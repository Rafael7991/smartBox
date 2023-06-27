package com.mycompany.admcaixa;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {
    
    private final ArrayList<String> nomeProd;
    private final ArrayList<Float> estoqueProd;
    
    public ProdutoTableModel(ArrayList<String> nomeProd, ArrayList<Float> estoqueProd) {
        this.nomeProd = nomeProd;
        this.estoqueProd = estoqueProd;
    }
    
    @Override
    public int getRowCount() {
        return nomeProd.size();
    }
    
    @Override
    public int getColumnCount() {
        return 2; // Número de colunas
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Nome";
            case 1:
                return "Estoque";
            default:
                return "";
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return nomeProd.get(row);
            case 1:
                return estoqueProd.get(row);
            default:
                return null;
        }
    }
}