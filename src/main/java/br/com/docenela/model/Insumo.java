package br.com.docenela.model;

import java.math.BigDecimal;

public class Insumo {

    private Integer id;
    private Insumo insumo;
    private String descricao;
    private BigDecimal preco;
    private BigDecimal quantidade;
    private Dominio unidadeDeMedida;


    public Insumo(){
        this.unidadeDeMedida = new Dominio(4);
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Dominio getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

}
