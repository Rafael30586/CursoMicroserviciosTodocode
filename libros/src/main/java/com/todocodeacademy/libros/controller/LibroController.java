package com.todocodeacademy.libros.controller;

import com.todocodeacademy.libros.model.Libro;
import com.todocodeacademy.libros.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private ILibroService service;

    @GetMapping("/")
    public List<Libro> listarTodos(){
        return service.traerTodos();
    }

    @PostMapping("/")
    public void crear(@RequestBody Libro libro){
        service.crear(libro);
    }

    @DeleteMapping("/{isbn}")
    public void eliminarPorIsbn(@PathVariable String isbn){
        service.eliminarPorIsbn(isbn);
    }

    @GetMapping("/{isbn}")
    public Libro tarerPorIsbn(@PathVariable String isbn){
        return service.traerPorIsbn(isbn);
    }

    @PutMapping("/{isbn}")
    public Libro modificar(@PathVariable String isbn, @RequestBody Libro libro){
        return service.editar(isbn, libro);
    }
}
