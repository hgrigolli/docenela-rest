package br.com.docenela.produtos.dao;

import br.com.docenela.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProdutosDAO {


    private final DataSource dataSource;

    @Autowired
    public ProdutosDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Produto> listarProdutos() {
        return null;
    }


}
