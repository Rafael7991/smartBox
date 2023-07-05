package com.mycompany.admcaixa;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
    
    private final ArrayList<String> login;
    private final ArrayList<String> nome;
    private final ArrayList<String> sobrenome;
    private final ArrayList<Integer> priv;

    public UserTableModel(ArrayList<String>login, ArrayList<String> nome, ArrayList<String> sobrenome, ArrayList<Integer> priv) {
        this.login = login;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.priv = priv;
    }

    @Override
    public int getRowCount() {
        return nome.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nome";
            case 1:
                return "Sobrenome";
            case 2:
                return "Privilegio";
            case 3:
                return "Usuário";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return nome.get(row);
            case 1:
                return sobrenome.get(row);
            case 2:
                return priv.get(row);
            case 3:
                return login.get(row);
            default:
                return null;
        }
    }
}
