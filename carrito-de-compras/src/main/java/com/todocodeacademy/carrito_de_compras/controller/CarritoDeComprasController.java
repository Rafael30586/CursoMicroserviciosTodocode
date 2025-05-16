package com.todocodeacademy.carrito_de_compras.controller;

import com.todocodeacademy.carrito_de_compras.model.CarritoDeCompras;
import com.todocodeacademy.carrito_de_compras.service.ICarritoDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos-de-compras")
public class CarritoDeComprasController {
    @Autowired
    private ICarritoDeComprasService service;

    @GetMapping("/")
    public List<CarritoDeCompras> traerTodos(){
        return service.traerTodos();
    }

    @GetMapping("/{id}")
    public CarritoDeCompras traerPorId(@PathVariable Long id){
        return service.traerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        service.eliminarPorId(id);
    }

    @PostMapping("/")
    public void crear(@RequestBody CarritoDeCompras carritoDeCompras){
        service.crear(carritoDeCompras);
    }

    @PutMapping("/{id}")
    public CarritoDeCompras modificar(@PathVariable Long id,
                                      @RequestBody CarritoDeCompras carritoDeCompras){

        return service.modificar(id,carritoDeCompras);
    }
}
