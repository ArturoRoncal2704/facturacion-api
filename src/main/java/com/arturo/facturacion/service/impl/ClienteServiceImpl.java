package com.arturo.facturacion.service.impl;

import com.arturo.facturacion.dto.ClienteRequest;
import com.arturo.facturacion.entity.Cliente;
import com.arturo.facturacion.repository.ClienteRepository;
import com.arturo.facturacion.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente registrarCliente(ClienteRequest request) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setRucDNI(request.getRucDni());
        nuevoCliente.setRazonSocial(request.getRazonSocial());
        nuevoCliente.setEmail(request.getEmail());

        return clienteRepository.save(nuevoCliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
