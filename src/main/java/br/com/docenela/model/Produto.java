package br.com.docenela.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class Produto {

    private Integer id;
    private String descricao;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private BigDecimal multiplicador;
    private LocalDate dataInclusao;
    private Dominio categoria;
    private Map<Insumo, BigDecimal> insumosUtilizados;

    public Produto(){
        this.categoria = new Dominio(1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Dominio getCategoria() {
        return categoria;
    }

    public Map<Insumo, BigDecimal> getInsumosUtilizados() {
        return insumosUtilizados;
    }

    public void setInsumosUtilizados(Map<Insumo, BigDecimal> insumosUtilizados) {
        this.insumosUtilizados = insumosUtilizados;
    }

    public BigDecimal getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(BigDecimal multiplicador) {
        this.multiplicador = multiplicador;
    }
}
