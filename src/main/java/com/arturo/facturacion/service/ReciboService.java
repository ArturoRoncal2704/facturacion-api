package com.arturo.facturacion.service;


import com.arturo.facturacion.entity.Recibo;

import java.math.BigDecimal;

public interface ReciboService {
    Recibo emitirRecibo(Long clienteId, Long servicioId, BigDecimal montoBruto);
}
