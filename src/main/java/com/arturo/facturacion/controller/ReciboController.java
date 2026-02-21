package com.arturo.facturacion.controller;

import com.arturo.facturacion.dto.ReciboRequest;
import com.arturo.facturacion.entity.Recibo;
import com.arturo.facturacion.service.ReciboService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recibos")
@RequiredArgsConstructor
public class ReciboController {

    private final ReciboService reciboService;

    @PostMapping
    public ResponseEntity<Recibo> emitirRecibo(@RequestBody ReciboRequest request){
        Recibo nuevoRecibo = reciboService.emitirRecibo(
                request.getClienteId(),
                request.getServicioId(),
                request.getMontoBruto()
        );

        return new ResponseEntity<>(nuevoRecibo, HttpStatus.CREATED);
    }
}
