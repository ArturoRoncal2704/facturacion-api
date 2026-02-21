package com.arturo.facturacion.repository;

import com.arturo.facturacion.entity.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReciboRepository extends JpaRepository<Recibo,Long> {
}
