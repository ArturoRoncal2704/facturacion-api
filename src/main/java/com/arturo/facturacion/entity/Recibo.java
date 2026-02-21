package com.arturo.facturacion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "tb_recibos")
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación de Muchos a Uno: Muchos recibos pueden pertenecer a un solo cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id",nullable = false)
    private Cliente cliente;

    // Relación de Muchos a Uno: Muchos recibos pueden ser por el mismo tipo de servicio
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(name = "fecha_emision",nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "monto_bruto",nullable = false)
    private BigDecimal montoBruto;

    @Column(name = "retencion_aplicado",nullable = false)
    private Boolean retencionAplicada;

    @Column(name = "monto_neto", nullable = false)
    private BigDecimal montoNeto;


}
