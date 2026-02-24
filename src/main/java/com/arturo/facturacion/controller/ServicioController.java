package com.arturo.facturacion.controller;

import com.arturo.facturacion.dto.ServicioRequest;
import com.arturo.facturacion.entity.Servicio;
import com.arturo.facturacion.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService servicioService;

    @PostMapping
    public ResponseEntity<Servicio> registrarServicio(@RequestBody ServicioRequest request) {
        Servicio servicioGuardado = servicioService.registrarServicio(request);
        return new ResponseEntity<>(servicioGuardado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> listarServicios() {
        List<Servicio> servicios = servicioService.listarServicios();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }
}
