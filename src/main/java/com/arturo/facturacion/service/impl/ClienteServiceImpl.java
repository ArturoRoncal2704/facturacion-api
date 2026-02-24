package com.arturo.facturacion.service.impl;

import com.arturo.facturacion.dto.ClienteRequest;
import com.arturo.facturacion.dto.ReniecResponse;
import com.arturo.facturacion.dto.SunatResponse;
import com.arturo.facturacion.entity.Cliente;
import com.arturo.facturacion.repository.ClienteRepository;
import com.arturo.facturacion.service.ClienteService;
import com.arturo.facturacion.service.ConsultaExternaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final ConsultaExternaService consultaExternaService;
    @Override
    public Cliente registrarCliente(ClienteRequest request) {
        String numeroDocumento = request.getRucDni();
        if (clienteRepository.existsByRucDNI(numeroDocumento)) {
            throw new RuntimeException("El cliente con documento " + numeroDocumento + " ya está registrado en tu base de datos.");
        }

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setRucDNI(numeroDocumento);
        nuevoCliente.setEmail(request.getEmail());

        if(numeroDocumento.length() == 8){
            ReniecResponse reniec = consultaExternaService.consultarDni(numeroDocumento);
            String nombreCompleto = reniec.getNombres() + " " + reniec.getApellidoPaterno() + " " + reniec.getApellidoMaterno();
            nuevoCliente.setRazonSocial(nombreCompleto);
        } else if (numeroDocumento.length() == 11){
            SunatResponse sunat= consultaExternaService.consultarRuc(numeroDocumento);
            nuevoCliente.setRazonSocial(sunat.getRazonSocial());
        } else {
            throw new RuntimeException("El documento debe tener exactamente 8 o 11 dígitos.");
        }

        return clienteRepository.save(nuevoCliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
