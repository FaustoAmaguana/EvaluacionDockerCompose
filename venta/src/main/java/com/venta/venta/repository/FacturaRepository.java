package com.venta.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venta.venta.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{
    
}
