package com.arturo.facturacion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SunatResponse {

    @JsonProperty("nombre")
    private String razonSocial;
    private String numeroDocumento;
    private String estado;      // Ej: ACTIVO
    private String condicion;   // Ej: HABIDO
    private String direccion;
}