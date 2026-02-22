package com.arturo.facturacion.service.impl;

import com.arturo.facturacion.dto.ServicioRequest;
import com.arturo.facturacion.entity.Servicio;
import com.arturo.facturacion.repository.ServicioRepository;
import com.arturo.facturacion.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    @Override
    public Servicio registrarServicio(ServicioRequest request) {
        Servicio nuevoServicio = new Servicio();
        nuevoServicio.setDescripcion(request.getDescripcion());
        nuevoServicio.setPrecioBase(request.getPrecioBase());

        return servicioRepository.save(nuevoServicio);
    }

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }
}
