package com.todocodeacademy.envios.controller;

import com.todocodeacademy.envios.dto.DestinatarioDTO;
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
    public Envio modificar(@PathVariable Long id,@RequestBody Envio envio){
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

    @GetMapping("/mostrar-destinatario/{idEnvio}")
    public DestinatarioDTO mostrarDestinatario(@PathVariable Long idEnvio){
        return service.traerDestinatario(idEnvio);
    }

    @GetMapping("/por-destinatario/{idDestinatario}")
    public List<Envio> traerPorIdDestinatario(@PathVariable Long idDestinatario){
        return service.traerPorIdDestinatario(idDestinatario);
    }
}
