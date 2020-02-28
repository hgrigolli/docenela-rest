package br.com.docenela.produtos.service;

import br.com.docenela.model.Insumo;
import br.com.docenela.produtos.dao.InsumoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class InsumoService {

    private final InsumoDAO insumoDAO;

    @Autowired
    public InsumoService(InsumoDAO insumoDAO) {
        this.insumoDAO = insumoDAO;
    }

    public void inserirInsumo(Insumo insumo) {
        insumoDAO.inserirInsumo(insumo);
    }

    public List<Insumo> listarTodosInsumos() {
        List<Insumo> listaDeInsumos = insumoDAO.listarTodosInsumos();
        return listaDeInsumos;
    }

    public void atualizarInsumo(Insumo insumo) {
        insumoDAO.atualizarInsumo(insumo);
    }

    public Insumo buscarInsumo(Integer id) {
        return insumoDAO.buscarInsumo(id);
    }

    public void cadastrarCompraDeInsumos(List<Insumo> listaDeInsumos) {
        insumoDAO.cadastrarCompraDeInsumos(listaDeInsumos);
    }

    public void deletarInsumo(Integer id) {
        insumoDAO.deletarInsumo(id);
    }
}
