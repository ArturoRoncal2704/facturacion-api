package com.arturo.facturacion.controller;

import com.arturo.facturacion.dto.ClienteRequest;
import com.arturo.facturacion.entity.Cliente;
import com.arturo.facturacion.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> registrarCliente (@RequestBody ClienteRequest request) {
        Cliente clienteGuardado = clienteService.registrarCliente(request);
        return new ResponseEntity<>(clienteGuardado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarCliente(){
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
