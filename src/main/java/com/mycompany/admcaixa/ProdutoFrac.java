package com.mycompany.admcaixa;

public class ProdutoFrac extends Item{
    
    public ProdutoFrac(int cod, String nome, float preco){
        this.preco = preco;
        tipo = 0;
        this.qtd = 0;
    }
    
    @Override
    public float valorTotal(){
        return preco;
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
*/
}
