package com.arturo.facturacion.service.impl;

import com.arturo.facturacion.entity.Recibo;
import com.arturo.facturacion.service.PdfService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    @Override
    public byte[] generarReciboPdf(Recibo recibo) {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subtituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font textoFont = FontFactory.getFont(FontFactory.HELVETICA, 12);


            Paragraph titulo = new Paragraph("RECIBO POR HONORARIOS ELECTRÓNICO", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            document.add(new Paragraph("DATOS DEL CLIENTE", subtituloFont));
            document.add(new Paragraph("Señor(es): " + recibo.getCliente().getRazonSocial(), textoFont));
            document.add(new Paragraph("Documento (RUC/DNI): " + recibo.getCliente().getRucDNI(), textoFont));
            document.add(new Paragraph("Fecha de Emisión: " + recibo.getFechaEmision(), textoFont));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("POR CONCEPTO DE", subtituloFont));
            document.add(new Paragraph("Servicio prestado: " + recibo.getServicio().getDescripcion(), textoFont));
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("RESUMEN FINANCIERO", subtituloFont));
            document.add(new Paragraph("Monto Bruto: S/ " + recibo.getMontoBruto(), textoFont));

            if (recibo.getRetencionAplicada()) {
                document.add(new Paragraph("Retención (8%): S/ " + recibo.getMontoBruto().subtract(recibo.getMontoNeto()), textoFont));
            } else {
                document.add(new Paragraph("Retención (8%): S/ 0.00", textoFont));
            }

            document.add(new Paragraph("Monto Neto a Pagar: S/ " + recibo.getMontoNeto(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
            document.close();

        } catch (DocumentException e) {
            throw new RuntimeException("Error al generar el PDF del recibo", e);
        }

        return out.toByteArray();
    }
}

