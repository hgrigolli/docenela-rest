package br.com.docenela.produtos.controller;

import br.com.docenela.model.Insumo;
import br.com.docenela.model.Produto;
import br.com.docenela.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {


    public final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produto")
    public String cadastrarProduto(@ModelAttribute Produto produto, @ModelAttribute List<Insumo> listaDeInsumos) {
        return "";
    }

    @GetMapping("/produto")
    public String listarTodosProdutos(Model model){
        return "";
    }

    @GetMapping("/produto/{id}")
    public String buscarProduto(Model model, @PathVariable Integer id){
        return "";
    }

    @PutMapping("/produto/{id}")
    public String atualizarProduto(Model model, @PathVariable Integer id){
        return "";
    }

}
