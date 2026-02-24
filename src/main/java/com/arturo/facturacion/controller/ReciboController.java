package com.arturo.facturacion.controller;

import com.arturo.facturacion.dto.ReciboRequest;
import com.arturo.facturacion.entity.Recibo;
import com.arturo.facturacion.service.PdfService;
import com.arturo.facturacion.service.ReciboService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recibos")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ReciboController {

    private final ReciboService reciboService;
    private final PdfService pdfService;

    @PostMapping
    public ResponseEntity<Recibo> emitirRecibo(@RequestBody ReciboRequest request){
        Recibo nuevoRecibo = reciboService.emitirRecibo(
                request.getClienteId(),
                request.getServicioId(),
                request.getMontoBruto()
        );

        return new ResponseEntity<>(nuevoRecibo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> descargarPdf(@PathVariable Long id){
        Recibo recibo = reciboService.obtenerReciboPorId(id);
        byte[] pdfBytes = pdfService.generarReciboPdf(recibo);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Recibo_Honorarios_" + id + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
