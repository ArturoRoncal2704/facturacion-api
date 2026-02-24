package com.arturo.facturacion.service;

import com.arturo.facturacion.dto.ClienteRequest;
import com.arturo.facturacion.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente registrarCliente(ClienteRequest request);
    List<Cliente> listarClientes();
    void eliminarCliente(Long id);
}
