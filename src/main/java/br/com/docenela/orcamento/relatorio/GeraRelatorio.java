package br.com.docenela.orcamento.relatorio;

import br.com.docenela.orcamento.model.Orcamento;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class GeraRelatorio {



    public byte[] printReport(List<Orcamento> listaOrcamento) throws JRException, IOException {

        // Define o caminho do template.
        String srcPath = "reports/src";
        String imgPath = "reports/images";


        System.out.println(srcPath);
        String pathMainReport = String.format("%s/orcamento.jrxml", srcPath);
        Resource resourceMainReport = new ClassPathResource(pathMainReport);
        InputStream isMainReport = resourceMainReport.getInputStream();

        String pathSubReport = String.format("%s/listaProdutosSubReport.jrxml", srcPath);
        Resource resourceSubReport = new ClassPathResource(pathSubReport);
        InputStream isSubReport = resourceSubReport.getInputStream();

        String logoPath = String.format("%s/logo.png", imgPath);
        Resource resourceLogo = new ClassPathResource(logoPath);
        InputStream isLogo = resourceLogo.getInputStream();

        String pathJASPER = String.format("%s/src/orcamento.jasper", srcPath);
        String pathPDF = String.format("%s/orcamento.pdf", srcPath);

       // File file = new File(pathPDF);

        // Compila o template.
        ByteArrayOutputStream osMainReport = new ByteArrayOutputStream();
        OutputStream osSubReport = new ByteArrayOutputStream();
        JasperCompileManager.compileReportToStream(isMainReport, osMainReport);
        JasperCompileManager.compileReportToStream(isSubReport, osSubReport);

        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(listaOrcamento);

        Map<String, Object> params = new HashMap<String, Object>();

        BufferedImage image = ImageIO.read(isLogo);

        params.put("logo", image);
        params.put("date", new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm", new Locale("pt", "BR")).format(new Date()));
        params.put("SUBREPORT_PATH", pathSubReport.replaceAll(".jrxml",".jasper"));

        InputStream isPrint = new ByteArrayInputStream(osMainReport.toByteArray());
        ByteArrayOutputStream osPrint = new ByteArrayOutputStream();

        JasperFillManager.fillReportToStream(isPrint, osPrint, params, jrBeanCollectionDataSource);

        // Exportar o relatório para PDF.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        InputStream isPdf = new ByteArrayInputStream(osPrint.toByteArray());

        JasperExportManager.exportReportToPdfStream(isPdf, outputStream);

        //String pdf64 = Base64.encodeBase64String(outputStream.toByteArray());

        try {
            isLogo.close();
            isMainReport.close();
            isPdf.close();
            isPrint.close();
            isSubReport.close();
            osMainReport.flush();
            osMainReport.close();
            osPrint.flush();
            osPrint.close();
            osSubReport.flush();
            osSubReport.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





        return outputStream.toByteArray();
    }


}
