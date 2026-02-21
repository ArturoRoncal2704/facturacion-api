package com.arturo.facturacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReciboRequest {
    private Long clienteId;
    private Long servicioId;
    private BigDecimal montoBruto;
}
