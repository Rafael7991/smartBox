package entities;

public class ProdutoFrac extends Item{
    
    public float preco;
    
    public ProdutoFrac(int cod, String nome, float preco){
        this.preco = preco;
        tipo = 1;
        qtd = 1;
    }
    
    @Override
    public float valorTotal(){
        return preco;
    }

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

}
