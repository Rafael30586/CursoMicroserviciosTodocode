package com.todocodeacademy.libros.service;

import com.todocodeacademy.libros.model.Libro;
import com.todocodeacademy.libros.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private ILibroRepository repository;

    @Override
    public void crear(Libro libro) {
        repository.save(libro);
    }

    @Override
    public List<Libro> traerTodos() {
        return repository.findAll();
    }

    @Override
    public Libro traerPorIsbn(String isbn) {
        return repository.findById(isbn).get();
    }

    @Override
    public void eliminarPorIsbn(String isbn) {
        repository.deleteById(isbn);

    }

    @Override
    public Libro editar(String isbn, Libro libro) {
        this.crear(libro);
        return repository.findById(isbn).get();
    }
}
