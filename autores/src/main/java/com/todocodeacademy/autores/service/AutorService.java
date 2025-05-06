package com.todocodeacademy.autores.service;

import com.todocodeacademy.autores.model.Autor;
import com.todocodeacademy.autores.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutorService{

    @Autowired
    private IAutorRepository repository;

    @Override
    public void crear(Autor autor) {
        repository.save(autor);
    }

    @Override
    public List<Autor> traerTodos() {
        return repository.findAll();
    }

    @Override
    public Autor encontrarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Autor editar(Long id, Autor autor) {
        this.crear(autor);
        return repository.findById(id).get();
    }
}
