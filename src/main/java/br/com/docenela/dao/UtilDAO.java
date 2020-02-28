package br.com.docenela.dao;

import br.com.docenela.model.Dominio;

import java.util.Map;

public interface UtilDAO {

    Map<Integer, String> buscaElementosDominio(Dominio dominio);
}
