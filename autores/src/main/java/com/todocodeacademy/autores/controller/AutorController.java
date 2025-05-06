package com.todocodeacademy.autores.controller;

import com.todocodeacademy.autores.model.Autor;
import com.todocodeacademy.autores.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping("/autor-por-nombre/{nombreCompleto}")
    public Autor traerPorNombre(@PathVariable String nombreCompleto,@RequestParam String nacionalidad){
        return service.traerPorNombreYNacionalidad(nombreCompleto,nacionalidad);
    }

    @PutMapping("/agregar-isbn/{isbn}")
    public void agregarIsbn(@PathVariable String isbn,
                            @RequestParam String nombreCompleto,
                            @RequestParam String nacionalidad){
        Autor autor = service.traerPorNombreYNacionalidad(nombreCompleto,nacionalidad);
        Set<String> isbns = autor.getListaIdsLibros();
        isbns.add(isbn);
        autor.setListaIdsLibros(isbns);
        service.crear(autor);
    }
}
