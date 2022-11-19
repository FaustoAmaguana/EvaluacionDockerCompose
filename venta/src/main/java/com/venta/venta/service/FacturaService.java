package com.venta.venta.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venta.venta.dto.FacturaValorDTO;
import com.venta.venta.model.Factura;
import com.venta.venta.repository.FacturaRepository;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public List<FacturaValorDTO> getFacturaValor(){
        return facturaRepository.findAll().stream().map(this::convertirEntidadToDTO).collect(Collectors.toList());
    }

    private FacturaValorDTO convertirEntidadToDTO(Factura factura){
        FacturaValorDTO facturaValorDTO = new FacturaValorDTO();
        facturaValorDTO.setPersonaId(factura.getId());
        facturaValorDTO.setValor(factura.getValor());
        return facturaValorDTO;
    }

    public Factura create(Factura factura){
        return facturaRepository.save(factura);
    }

    public List<Factura> listarFactura(){
        return facturaRepository.findAll();
    }

    public void eliminarFactura(Factura factura){
        facturaRepository.delete(factura);
    }


    public Factura buscarId(Long id){
        return facturaRepository.findById(id).get();
    }
}
