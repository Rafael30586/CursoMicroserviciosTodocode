package com.todocodeacademy.ingredientes.controller;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import com.todocodeacademy.ingredientes.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IIngredienteService service;

    @GetMapping("/")
    public List<Ingrediente> mostrarTodos(){
        return service.traerIngredientes();
    }

    @PostMapping("/")
    public void guardar(@RequestBody Ingrediente ingrediente){
        service.crearIngrediente(ingrediente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.borrarIngrediente(id);
    }

    @GetMapping("/{id}")
    public Ingrediente traerPorId(@PathVariable Long id){
        return service.encontrarIngrediente(id);
    }

    @PutMapping("/{id}")
    public Ingrediente modificar(@PathVariable Long id, @RequestBody Ingrediente ingrediente){
        return service.modificarIngrediente(id, ingrediente);
    }

    @GetMapping("/por-nombre/{nombre}")
    public Ingrediente traerPorNombre(@PathVariable String nombre){
        return service.traerPorNombre(nombre);
    }
}
