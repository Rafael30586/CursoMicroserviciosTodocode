package com.todocodeacademy.productos.controller;

import com.todocodeacademy.productos.model.Producto;
import com.todocodeacademy.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;
    @Value("${server.port}")
    private int server_port;

    @GetMapping("/")
    public List<Producto> traerTodos(){
        return service.traerTodos();
    }

    @GetMapping("/{id}")
    public Producto traerPorId(@PathVariable Long id){
        System.out.println("Puerto: "+server_port);
        return service.traerPorId(id);
    }

    @PostMapping("/")
    public void crear(@RequestBody Producto producto){
        service.crear(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        service.eliminarPorId(id);
    }

    @PutMapping("/{id}")
    public Producto modificar(@PathVariable Long id,@RequestBody Producto producto){
        return service.modificar(id,producto);
    }
}
