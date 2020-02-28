package br.com.docenela.orcamento.controller;
import br.com.docenela.crudinterface.CRUDInterface;
import br.com.docenela.model.Cliente;
import br.com.docenela.model.Evento;
import br.com.docenela.model.Produto;
import br.com.docenela.orcamento.model.Orcamento;
import br.com.docenela.orcamento.relatorio.GeraRelatorio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController implements CRUDInterface<Orcamento> {

    @Override
    public List<Orcamento> listar() {


        ArrayList<Orcamento> orcamentoArrayList = new ArrayList<Orcamento>();
        Orcamento orc = new Orcamento();
        Evento evnt = new Evento();
        evnt.setData(new Date());
        evnt.setDescricao("Teste report");
        Cliente clt = new Cliente();
        clt.setPrimeiroNome("Cliente teste");
        orc.setDataDoOrcamento(new Date());
        orcamentoArrayList.add(orc);

        return orcamentoArrayList;
    }

    @Override
    public ResponseEntity buscar(long id) {

        return null;
    }

    @GetMapping(path = "/orcar/{id}")
    public String gerarPDF(@PathVariable long id) {
        ArrayList<Orcamento> orcamentoArrayList = new ArrayList<>();

        Orcamento orc = new Orcamento();
        Evento evnt = new Evento();
        evnt.setData(new Date());
        evnt.setDescricao("Teste report");
        Cliente clt = new Cliente();
        clt.setPrimeiroNome("Cliente teste - " + id);
        orc.setDataDoOrcamento(new Date());
        orc.setCliente(clt);
        orc.setEvento(evnt);
        List<Produto> produtos = new ArrayList<>();
        Produto prod = new Produto();

        prod.setDescricao("Brigadeiro");
        prod.setPrecoVenda(new BigDecimal(5));

        produtos.add(prod);
        produtos.add(prod);
        produtos.add(prod);
        produtos.add(prod);


        orc.setProdutos(produtos);
        orcamentoArrayList.add(orc);

        try {
            (new GeraRelatorio()).printReport(orcamentoArrayList);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "pdf gerado";
    }

    @Override
    public ResponseEntity<?> remover(long id) {
        return null;
    }

    @Override
    public Orcamento criar(Orcamento objeto) {
        return null;
    }

    @Override
    public ResponseEntity atualizar(long id, Orcamento objeto) {
        return null;
    }
}
