package com.todocodeacademy.destinatarios.controller;

import com.todocodeacademy.destinatarios.model.Destinatario;
import com.todocodeacademy.destinatarios.service.IDestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinatarios")
public class DestinatarioController {

    @Autowired
    private IDestinatarioService service;

    @GetMapping("/")
    public List<Destinatario> traerTodos(){
        return service.traerTodos();
    }

    @GetMapping("/{id}")
    public Destinatario encontrarPoId(@PathVariable Long id){
        return service.traerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        service.eliminarPorId(id);
    }

    @PostMapping("/")
    public void crear(@RequestBody Destinatario destinatario){
        service.crear(destinatario);
    }

    @PutMapping("/{id}")
    public Destinatario modificar(@PathVariable Long id, @RequestBody Destinatario destinatario){
        return service.modificar(id,destinatario);
    }
}
