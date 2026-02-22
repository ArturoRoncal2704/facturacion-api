package com.arturo.facturacion.service;

import com.arturo.facturacion.dto.ServicioRequest;
import com.arturo.facturacion.entity.Servicio;

import java.util.List;

public interface ServicioService {
    Servicio registrarServicio(ServicioRequest request);
    List<Servicio> listarServicios();
}
