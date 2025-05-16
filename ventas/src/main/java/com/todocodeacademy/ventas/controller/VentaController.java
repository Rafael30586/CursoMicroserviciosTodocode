package com.todocodeacademy.ventas.controller;

import com.todocodeacademy.ventas.model.Venta;
import com.todocodeacademy.ventas.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService service;

    @GetMapping("/")
    public List<Venta> traerTodas(){
        return service.traerTodas();
    }

    @GetMapping("/{id}")
    public Venta traerPorId(@PathVariable Long id){
        return service.traerPorId(id);
    }

    @PostMapping("/")
    public void crear(@RequestBody Venta venta){
        service.crear(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        service.eliminarPorId(id);
    }

    @PutMapping("/{id}")
    public Venta modificar(@PathVariable Long id,@RequestBody Venta venta){
        return service.modificar(id,venta);
    }
}
