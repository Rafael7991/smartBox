package com.mycompany.admcaixa;

public abstract class Item {
    protected String nome;
    protected int cod;
    protected int tipo;
    protected int qtd;
    protected float preco;
    
    
    public abstract float valorTotal();

    public String getNome() {
        return nome;
    }

    public int getCod() {
        return cod;
    }

    public int getTipo() {
        return tipo;
    }

    public int getQtd() {
        return qtd;
    }

    public float getPreco() {
        return preco;
    }
    
}
