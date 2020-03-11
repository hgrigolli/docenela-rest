package br.com.docenela.orcamento.model;

import br.com.docenela.model.Cliente;
import br.com.docenela.model.Evento;
import br.com.docenela.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Orcamento {

    private Date dataDoOrcamento;
    private Cliente cliente;
    private Evento evento;
    private List<Produto> produtos;

}
