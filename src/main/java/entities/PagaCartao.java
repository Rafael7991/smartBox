
package entities;

public class PagaCartao implements iPagamento{
    
    float entrada;
    
    public PagaCartao(float entrada){
        this.entrada = entrada;
        
    }
    
    @Override
    public float calculaTroco(){
        return 0;
    }
    
}
