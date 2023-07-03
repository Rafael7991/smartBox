
package com.mycompany.admcaixa;

public class ProdutoPriv extends Item{
    
    ProdutoPriv(int cod, String nome){
        this.cod = cod;
        this.nome = nome;
        tipo = 2;
    }
    
    @Override
    public float valorTotal(){
        return preco*estoque;
    }
/*
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

    public int getEstoque() {
        return estoque;
    }
*/
}
