package br.com.docenela.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovimentoInsumo {

    private Integer id;
    private Insumo insumo;
    private BigDecimal quantidadePaga;
    private BigDecimal quantidadeDeInsumo;
    private LocalDate dataCompra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public BigDecimal getQuantidadePaga() {
        return quantidadePaga;
    }

    public void setQuantidadePaga(BigDecimal quantidadePaga) {
        this.quantidadePaga = quantidadePaga;
    }

    public BigDecimal getQuantidadeDeInsumo() {
        return quantidadeDeInsumo;
    }

    public void setQuantidadeDeInsumo(BigDecimal quantidadeDeInsumo) {
        this.quantidadeDeInsumo = quantidadeDeInsumo;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
}
