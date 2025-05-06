package com.todocodeacademy.autores.controller;

import com.todocodeacademy.autores.model.Autor;
import com.todocodeacademy.autores.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private IAutorService service;

    @PostMapping("/")
    public void crear(@RequestBody Autor autor){
        service.crear(autor);
    }

    @GetMapping("/")
    public List<Autor> traerTodos(){
        return service.traerTodos();
    }

    @GetMapping("/{id}")
    public Autor traerPorId(@PathVariable Long id){
        return service.encontrarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void borrarPorId(@PathVariable Long id){
        service.eliminarPorId(id);
    }

    @PutMapping("/{id}")
    public Autor modificar(@PathVariable Long id, @RequestBody Autor autor){
        return service.editar(id, autor);
    }
}
