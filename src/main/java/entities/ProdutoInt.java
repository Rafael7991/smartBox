package entities;

public class ProdutoInt extends Item {
    
    public int qtd;
    public float preco;
    
    public ProdutoInt(int cod, String nome, int qtd, float preco){
        this.qtd = qtd;
        this.preco = preco;
        tipo = 2;
    }
    
    @Override
    public float valorTotal(){
        return qtd*preco;
    }
    
    
}
