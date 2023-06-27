package com.mycompany.admcaixa;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class VendasTableModel extends AbstractTableModel {

    private final ArrayList<String> nomeProd;
    private final ArrayList<String> datahora;
    private final ArrayList<Float> valor;

    public VendasTableModel(ArrayList<String> datahora, ArrayList<String> nomeProd, ArrayList<Float> valor) {
        this.nomeProd = nomeProd;
        this.datahora = datahora;
        this.valor = valor;
    }

    @Override
    public int getRowCount() {
        return nomeProd.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Data";
            case 1:
                return "Nome";
            case 2:
                return "Valor";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return datahora.get(row);
            case 1:
                return nomeProd.get(row);
            case 2:
                return valor.get(row);
            default:
                return null;
        }
    }

    
}
