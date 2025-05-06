package com.todocodeacademy.libros.service;

import com.todocodeacademy.libros.dto.AutorDTO;
import com.todocodeacademy.libros.model.Libro;
import com.todocodeacademy.libros.repository.IAutoresClient;
import com.todocodeacademy.libros.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private ILibroRepository repository;

    @Autowired
    private IAutoresClient autorClient;

    @Override
    public void crear(Libro libro) {
        Set<AutorDTO> autores = libro.getAutores();
        for(AutorDTO a : autores){
            if(autorClient.traerAutorPorNombre(a.getNombreCompleto(),a.getNacionalidad())==null){
                autorClient.guardarAutor(a);
                autorClient.agregarIsbnAAutor(libro.getIsbn(), a.getNombreCompleto(), a.getNacionalidad());
            }

        }
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
