package br.com.docenela.produtos.controller;

import br.com.docenela.crudinterface.CRUDInterface;
import br.com.docenela.model.Insumo;
import br.com.docenela.produtos.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insumo")
public class InsumoController implements CRUDInterface<Insumo> {

    public final InsumoService insumoService;

    @Autowired
    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @Override
    public List<Insumo> listar() {
        return insumoService.listarTodosInsumos();
    }

    @Override
    public ResponseEntity buscar(long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> remover(long id) {
        return null;
    }

    @Override
    public Insumo criar(Insumo objeto) {
        insumoService.inserirInsumo(objeto);
        return null;
    }

    @Override
    public ResponseEntity atualizar(long id, Insumo objeto) {
        insumoService.atualizarInsumo(objeto);
        return null;
    }
}
