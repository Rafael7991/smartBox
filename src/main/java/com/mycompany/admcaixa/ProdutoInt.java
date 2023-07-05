package com.mycompany.admcaixa;

public class ProdutoInt extends Item {
    
    private int estoque;

    public ProdutoInt(int cod, String nome, int qtd, float preco) {
        this.qtd = qtd;
        this.preco = preco;
        this.cod = cod;
        this.nome = nome;
        tipo = 1;
    }

    @Override
    public float valorTotal() {
        return qtd * preco;
    }
    
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
