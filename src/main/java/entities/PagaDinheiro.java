package entities;

public class PagaDinheiro implements iPagamento{

    float entrada;
    float total;

    public PagaDinheiro(float entrada, float total){
        this.entrada = entrada;
        this.total = total;
    }
    
    @Override
    public float calculaTroco(){
        return entrada - total;
    }

}
