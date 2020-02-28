package br.com.docenela.clientes.facade.impl;

import br.com.docenela.clientes.dao.ClienteDAO;
import br.com.docenela.clientes.facade.ClienteFacade;
import br.com.docenela.model.Cliente;
import br.com.docenela.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteFacadeImpl implements ClienteFacade {

    public final ClienteDAO clienteDAO;

    @Autowired
    public ClienteFacadeImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void inserirCliente(Cliente cliente, Endereco endereco) {
        try {
            cliente.setId(clienteDAO.inserir(cliente));
            endereco.setId(clienteDAO.inserir(endereco));
            clienteDAO.inserir(cliente, endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteDAO.listarTodosClientes();
    }
}
