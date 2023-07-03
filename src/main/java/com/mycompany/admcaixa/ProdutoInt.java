package com.mycompany.admcaixa;

public class ProdutoInt extends Item {

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
    /*
    public String getNome() {
        return nome;
    }

    public int getCod() {
        return cod;
    }

    

    public int getQtd() {
        return qtd;
    }

    public float getPreco() {
        return preco;
    }
*/
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    

}
