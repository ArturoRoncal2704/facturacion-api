package com.arturo.facturacion.service;

import com.arturo.facturacion.entity.Recibo;
import org.springframework.stereotype.Service;


public interface PdfService {
    byte[] generarReciboPdf(Recibo recibo);
}
