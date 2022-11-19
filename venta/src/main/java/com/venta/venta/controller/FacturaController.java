package com.venta.venta.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venta.venta.dto.FacturaValorDTO;
import com.venta.venta.model.Factura;
import com.venta.venta.service.FacturaService;


@RestController
@RequestMapping("/api/factura/")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("facturavalor")
    public List<FacturaValorDTO> listarFacturaValor() {
        return facturaService.getFacturaValor();
    }

    @PostMapping
    private ResponseEntity<Factura> guardar(@RequestBody Factura factura) {
        Factura factura2 = facturaService.create(factura);

        try {
            return ResponseEntity.created(new URI("/api/factura" + factura2.getId())).body(factura2);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Factura>> listarFactura() {
        return ResponseEntity.ok(facturaService.listarFactura());

    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity<Void> eliminarFactura(@PathVariable("id") Long id) {
        Factura p = facturaService.buscarId(id);
        facturaService.eliminarFactura(p);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Factura> buscarPersona(@PathVariable("id") Long id) {
        return ResponseEntity.ok(facturaService.buscarId(id));

    }

    @PutMapping(value = "{id}")
    public Factura editar(@PathVariable("id") Long id, @RequestBody Factura factura){
        factura.setId(id);
        return facturaService.create(factura);
    }

}
