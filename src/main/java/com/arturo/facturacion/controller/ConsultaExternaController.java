package com.arturo.facturacion.controller;

import com.arturo.facturacion.dto.ReniecResponse;
import com.arturo.facturacion.dto.SunatResponse;
import com.arturo.facturacion.service.ConsultaExternaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaExternaController {

    private final ConsultaExternaService consultaExternaService;

    @GetMapping("/dni/{numero}")
    public ResponseEntity<ReniecResponse> consultarDni (@PathVariable String numero){
        ReniecResponse respuesta = consultaExternaService.consultarDni(numero);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/ruc/{numero}")
    public ResponseEntity<SunatResponse> consultarRuc(@PathVariable String numero) {
        SunatResponse respuesta = consultaExternaService.consultarRuc(numero);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
