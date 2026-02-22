package com.arturo.facturacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReniecResponse {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroDocumento;
}