package com.mycompany.admcaixa;

public class ProdutoPriv extends Item {

    private int estoque;

    ProdutoPriv(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
        tipo = 2;
    }
    
    @Override
    public float valorTotal() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
