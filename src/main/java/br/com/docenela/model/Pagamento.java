package br.com.docenela.model;

import java.time.LocalDate;

public class Pagamento {
    private Integer id;
    private Cliente cliente;
    private Pedido pedido;
    private LocalDate dataPagamento;
    private Dominio metodoPagamento;

    public Pagamento() {
        this.metodoPagamento = new Dominio(3);
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Dominio getMetodoPagamento() {
        return metodoPagamento;
    }
}
