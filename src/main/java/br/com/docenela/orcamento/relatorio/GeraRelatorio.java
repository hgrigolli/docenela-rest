package br.com.docenela.orcamento.relatorio;

import br.com.docenela.orcamento.model.Orcamento;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class GeraRelatorio {



    public String printReport(List<Orcamento> listaOrcamento) throws JRException, IOException {

        String pdfURL = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        // Define o caminho do template.

        URL initPath = this.getClass().getClassLoader().getResource("reports");

        String pathMainReport = String.format("%s!/src!/orcamento.jrxml", initPath.getPath());
        String pathSubReport = String.format("%s!/src!/listaProdutosSubReport.jrxml", initPath.getPath());
        String logoPath = String.format("%s!/images!/logo.png", initPath.getPath());

        String pathJASPER = String.format("%s!/src!/orcamento.jasper", initPath.getPath());
        String pathPDF = String.format("%s!/orcamento.pdf", initPath.getPath());

        File file = new File(pathPDF);

        // Compila o template.
        JasperCompileManager.compileReportToFile(pathMainReport);
        JasperCompileManager.compileReportToFile(pathSubReport);

        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(listaOrcamento);

        Map<String, Object> params = new HashMap<String, Object>();

        BufferedImage image = ImageIO.read(new File(logoPath));

        params.put("logo", image);
        params.put("date", new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm", new Locale("pt", "BR")).format(new Date()));

        JasperPrint print = JasperFillManager.fillReport(pathJASPER, params, jrBeanCollectionDataSource);


        // Exportar o relatório para PDF.
        OutputStream outputStream = new FileOutputStream(file);

        JasperExportManager.exportReportToPdfStream(print, outputStream);

        outputStream.flush();
        outputStream.close();


        return null;
    }


}
