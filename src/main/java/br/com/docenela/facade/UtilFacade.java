package br.com.docenela.facade;

import br.com.docenela.model.Dominio;

import java.util.Map;

public interface UtilFacade {

    Map<Integer, String> buscaElementosDominio(Dominio dominio);
}
