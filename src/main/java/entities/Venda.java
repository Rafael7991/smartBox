package entities;

import java.sql.Timestamp;

import java.util.Date;

public class Venda{

    public int qtdItens = 0;
    public int qtdLinhas = 0;
    public float total;
    public float totalParcial = 0;
    public Date dataHoraAtual;


    public Venda(Timestamp dataHoraAtual) {
        this.dataHoraAtual = dataHoraAtual;
    }


    public void addItem(float valor, int qtd) {
        this.totalParcial += valor;
        this.qtdItens += qtd;
        this.qtdLinhas++;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public float getTotalParcial() {
        return totalParcial;
    }

    public Timestamp getDataHoraAtual() {
        return (Timestamp) dataHoraAtual;
    }

    public int getQtdLinhas() {
        return qtdLinhas;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotal() {
        return total;
    }

}
