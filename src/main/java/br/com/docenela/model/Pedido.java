package br.com.docenela.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private Integer id;
    private Cliente cliente;
    private LocalDate dataPedido;
    private BigDecimal valorTotal;
    private String observacao;
    private Dominio status;

    public Pedido() {
        this.status = new Dominio(2);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Dominio getStatus() {
        return status;
    }
}
