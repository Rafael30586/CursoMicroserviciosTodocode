package com.todocodeacademy.ingredientes.service;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import com.todocodeacademy.ingredientes.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService implements IIngredienteService{

    @Autowired
    private IIngredienteRepository repository;

    @Override
    public void crearIngrediente(Ingrediente ingrediente) {
        repository.save(ingrediente);
    }

    @Override
    public List<Ingrediente> traerIngredientes() {
        return repository.findAll();
    }

    @Override
    public void borrarIngrediente(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Ingrediente modificarIngrediente(Long id,Ingrediente ingrediente) {
        repository.save(ingrediente);
        return repository.findById(id).get();
    }

    @Override
    public Ingrediente encontrarIngrediente(Long id){
        return repository.findById(id).get();
    }
    @Override
    public Ingrediente traerPorNombre(String nombre){
        return repository.findByNombreIngrediente(nombre);
    }
}
