package com.arturo.facturacion.service;

import com.arturo.facturacion.dto.ReniecResponse;
import com.arturo.facturacion.dto.SunatResponse;

public interface ConsultaExternaService {
    ReniecResponse consultarDni(String dni);
    SunatResponse consultarRuc(String ruc);
}
