package br.ufrn.SmartRecibos.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import br.ufrn.SmartRecibos.model.Recibo;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class PDFReciboService {
    public void exportarRecibo(HttpServletResponse response, Recibo recibo) {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fontTitle.setSize(18);
            document.add(new Paragraph("Recibo", fontTitle));
            document.add(new Paragraph("", fontTitle));
            Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
            fontParagraph.setSize(12);
            document.add(new Paragraph("Valor: " + recibo.getValor(), fontParagraph));
            document.add(new Paragraph("Descrição: " + recibo.getDescricao(), fontParagraph));
            document.add(new Paragraph("Data de emissão: " + recibo.getDataCriacao(), fontParagraph));
            document.add(new Paragraph("Data de vencimento: " + recibo.getDataVencimento(), fontParagraph));
            document.add(new Paragraph("Cliente: " + recibo.getCliente().getNome(), fontParagraph));
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
