package br.com.docenela.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Produto {

    private Integer id;
    private String descricao;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private BigDecimal multiplicador;
    private LocalDate dataInclusao;
    private Dominio categoria;
    //private Map<Insumo, BigDecimal> insumosUtilizados;

    public Produto(){
        this.categoria = new Dominio(1);
    }
}
