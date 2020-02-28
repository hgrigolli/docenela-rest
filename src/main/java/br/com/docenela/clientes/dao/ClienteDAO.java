package br.com.docenela.clientes.dao;

import br.com.docenela.model.Cliente;
import br.com.docenela.model.Endereco;

import java.util.List;

public interface ClienteDAO {

    int inserir(Cliente cliente);
    int inserir(Endereco endereco);
    void inserir(Cliente cliente, Endereco endereco);

    List<Cliente> listarTodosClientes();

}
