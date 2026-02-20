package com.arturo.facturacion.repository;

import com.arturo.facturacion.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
