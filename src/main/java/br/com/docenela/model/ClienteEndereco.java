package br.com.docenela.model;

import lombok.Data;

@Data
public class ClienteEndereco {

    private Cliente cliente;
    private Endereco endereco;

}
