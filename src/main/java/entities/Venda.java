package entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Venda extends Item {

    public int qtdItens = 0;
    public int qtdLinhas = 0;
    public float total;
    public float totalParcial = 0;
    public Date dataHoraAtual;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Venda(Timestamp dataHoraAtual) {
        this.dataHoraAtual = dataHoraAtual;
    }

    @Override
    public float valorTotal() {
        return total;
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
