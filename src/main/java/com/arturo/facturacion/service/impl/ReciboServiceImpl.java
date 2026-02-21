package com.arturo.facturacion.service.impl;

import com.arturo.facturacion.entity.Cliente;
import com.arturo.facturacion.entity.Recibo;
import com.arturo.facturacion.entity.Servicio;
import com.arturo.facturacion.repository.ClienteRepository;
import com.arturo.facturacion.repository.ReciboRepository;
import com.arturo.facturacion.repository.ServicioRepository;
import com.arturo.facturacion.service.ReciboService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReciboServiceImpl implements ReciboService {


    private final ReciboRepository reciboRepository;
    private final ClienteRepository clienteRepository;
    private final ServicioRepository servicioRepository;

    private static final BigDecimal LIMITE_RETENCION = new BigDecimal("1500.00");
    private static final BigDecimal PORCENTAJE_RETENCION = new BigDecimal("0.08");


    @Override
    public Recibo emitirRecibo(Long clienteId, Long servicioId, BigDecimal montoBruto) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Error: Cliente no encontrado"));

        Servicio servicio = servicioRepository.findById(servicioId)
                .orElseThrow(() -> new RuntimeException("Error: Servicio no encontrado"));

        BigDecimal montoNeto = montoBruto;
        boolean aplicaRetencion = false;

        if (montoBruto.compareTo(LIMITE_RETENCION) > 0){
            aplicaRetencion = true;
            BigDecimal retencion = montoBruto.multiply(PORCENTAJE_RETENCION);
            montoNeto = montoBruto.subtract(retencion);
        }

        Recibo nuevoRecibo = new Recibo();
        nuevoRecibo.setCliente(cliente);
        nuevoRecibo.setServicio(servicio);
        nuevoRecibo.setFechaEmision(LocalDate.now());
        nuevoRecibo.setMontoBruto(montoBruto);
        nuevoRecibo.setRetencionAplicada(aplicaRetencion);
        nuevoRecibo.setMontoNeto(montoNeto);

        return reciboRepository.save(nuevoRecibo);
    }
}
