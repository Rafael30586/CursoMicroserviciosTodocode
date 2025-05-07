package com.todocodeacademy.envios.controller;

import com.todocodeacademy.envios.model.Envio;
import com.todocodeacademy.envios.service.IEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private IEnvioService service;

    @GetMapping("/")
    public List<Envio> traerTodos(){
        return service.traerTodos();
    }

    @PutMapping("/{id}")
    public Envio mopdificar(@PathVariable Long id,@RequestBody Envio envio){
        return service.modificar(id,envio);
    }

    @GetMapping("/{id}")
    public Envio encontrarPorId(@PathVariable Long id){
        return service.traerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        service.eliminarPorId(id);
    }

    @PostMapping("/")
    public void crear(@RequestBody Envio envio){
        service.crear(envio);
    }
}
