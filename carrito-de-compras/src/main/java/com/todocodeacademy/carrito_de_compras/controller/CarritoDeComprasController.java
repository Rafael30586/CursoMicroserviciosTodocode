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

    @PutMapping("/agregar-producto")
    public CarritoDeCompras agregarProducto(@RequestParam("id-producto") Long idProducto,
                                            @RequestParam("cantidad-producto") int cantidadProducto,
                                            @RequestParam("id-carrito-de-compras") Long idCarritoDeCompras){
        return service.agregarProducto(idProducto,cantidadProducto,idCarritoDeCompras);
    }

    @PutMapping("/quitar-producto")
    public String quitarProducto(@RequestParam Long idProducto,
                                 @RequestParam Long idCarritoDeCompras){
        service.quitarProducto(idProducto,idCarritoDeCompras);
        return "Producto removido correctamente";
    }
}
