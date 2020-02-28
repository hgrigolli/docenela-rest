package br.com.docenela.clientes.controller;

import br.com.docenela.clientes.facade.ClienteFacade;
import br.com.docenela.model.Cliente;
import br.com.docenela.model.ClienteEndereco;
import br.com.docenela.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    public final ClienteFacade clienteFacade;

    @Autowired
    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    @PostMapping("/cliente")
    public String inserirCliente(@RequestBody ClienteEndereco clienteEndereco){
        try {
            clienteFacade.inserirCliente(clienteEndereco.getCliente(), clienteEndereco.getEndereco());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return "Sucesso";
    }

    @GetMapping("/cliente")
    public List<Cliente> listarCliente(Model model){

        List<Cliente> listaDeClientes = clienteFacade.listarTodosClientes();

        return listaDeClientes;
    }


}
