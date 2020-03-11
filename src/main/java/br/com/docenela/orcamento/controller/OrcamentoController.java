package br.com.docenela.orcamento.controller;
import br.com.docenela.crudinterface.CRUDInterface;
import br.com.docenela.model.Cliente;
import br.com.docenela.model.ClienteEndereco;
import br.com.docenela.model.Evento;
import br.com.docenela.model.Produto;
import br.com.docenela.orcamento.model.Orcamento;
import br.com.docenela.orcamento.relatorio.GeraRelatorio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/orcar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity gerarPDF(@RequestBody Orcamento orcamento) {
        ArrayList<Orcamento> orcamentoArrayList = new ArrayList<>();
        orcamentoArrayList.add(orcamento);
        byte[] pdf = null;
        try {
            pdf = (new GeraRelatorio()).printReport(orcamentoArrayList);
        } catch (JRException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        } catch (NullPointerException e){
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "attachment; filename=orcamento.pdf");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(
                pdf, headers, HttpStatus.OK);

        return response;
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
