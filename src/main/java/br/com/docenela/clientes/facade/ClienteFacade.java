package br.com.docenela.clientes.facade;

import br.com.docenela.model.Cliente;
import br.com.docenela.model.Endereco;

import java.util.List;

public interface ClienteFacade {


    void inserirCliente(Cliente cliente, Endereco endereco);

    List<Cliente> listarTodosClientes();
}
