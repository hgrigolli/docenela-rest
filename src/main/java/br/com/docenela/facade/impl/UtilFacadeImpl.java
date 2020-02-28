package br.com.docenela.facade.impl;

import br.com.docenela.dao.UtilDAO;
import br.com.docenela.facade.UtilFacade;
import br.com.docenela.model.Dominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UtilFacadeImpl implements UtilFacade {

    private UtilDAO utilDAO;

    @Autowired
    public UtilFacadeImpl(UtilDAO utilDAO) {
        this.utilDAO = utilDAO;
    }

    @Override
    public Map<Integer, String> buscaElementosDominio(Dominio dominio) {
        return utilDAO.buscaElementosDominio(dominio);
    }
}
