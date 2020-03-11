package br.com.docenela.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Evento {

    private String endereco;
    private Date data;
    private String tipo;
    private String descricao;

}
