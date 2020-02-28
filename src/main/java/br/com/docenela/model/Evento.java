package br.com.docenela.model;

import lombok.Data;

import java.util.Date;

@Data
public class Evento {

    private String endereco;
    private Date data;
    private String tipo;
    private String descricao;

}
