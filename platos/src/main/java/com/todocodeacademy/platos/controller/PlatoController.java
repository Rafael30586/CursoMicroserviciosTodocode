package com.todocodeacademy.platos.controller;

import com.todocodeacademy.platos.model.Plato;
import com.todocodeacademy.platos.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private IPlatoService service;

    @GetMapping("/")
    public List<Plato> listarTodos(){
        return service.traerTodos();
    }

    @GetMapping("/{id}")
    public Plato traerPrId(@PathVariable Long id){
        return service.traerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
    }

    @PostMapping("/")
    public void crearPlato(@RequestBody Plato plato){
        service.crear(plato);
    }

    @PutMapping("/{id}")
    public Plato modificar(@PathVariable Long id, @RequestBody Plato plato){
        return service.editar(id,plato);
    }
}
